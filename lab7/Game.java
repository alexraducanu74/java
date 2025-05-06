package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary;
    private final List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    private boolean gameOver = false;

    public Game(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public synchronized boolean isMyTurn(Player p) {
        return players.get(currentPlayerIndex) == p;
    }

    public synchronized void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        if (bag.isEmpty()) gameOver = true;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void play() {
        List<Thread> threads = new ArrayList<>();

        for (Player player : players) {
            Thread t = new Thread(player);
            threads.add(t);
            t.start();
        }

        Thread timekeeper = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (!gameOver) {
                long passed = (System.currentTimeMillis() - start) / 1000;
                System.out.println("time passed: " + passed + "s");
                if (passed > 30) {
                    System.out.println("no time left");
                    System.exit(0);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        });
        timekeeper.setDaemon(true);
        timekeeper.start();

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ignored) {}
        }

        showFinalScores();
    }
    public void showFinalScores() {
        System.out.println("\nfinal scores");
        Player winner = null;
        int maxScore = -1;
        for (Player player : players) {
            int score = player.getScore();
            System.out.println(player.getName() + ": " + score);
            if (score > maxScore) {
                maxScore = score;
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("\nwinner: " + winner.getName() + " with " + maxScore + " points");
        }
    }
    public static void main(String[] args) throws IOException {
        Game game = new Game(new RealDictionary("C:\\Users\\Administrator\\IdeaProjects\\lab7\\src\\main\\java\\org\\example\\words.txt"));
        game.addPlayer(new Player("P1", game));
        game.addPlayer(new Player("P2", game));
        game.addPlayer(new Player("P3", game));
        game.play();
    }
}
