package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Player implements Runnable {
    private final String name;
    private final Game game;
    private int score = 0;
    private final List<Tile> tiles = new ArrayList<>();

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }


    @Override
    public void run() {
        tiles.addAll(game.getBag().extractTiles(7));
        while (!game.getBag().isEmpty()) {
            synchronized (game) {
                while (!game.isMyTurn(this)) {
                    try {
                        game.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                submitWord();
                game.nextTurn();
                game.notifyAll();
            }

//            try {
//                Thread.sleep(100); //"timp de gandire"
//            } catch (InterruptedException ignored) {}
        }
    }

    private void submitWord() {
        if (tiles.isEmpty()) {
            return;
        }

        List<Character> letters = tiles.stream()
                .map(Tile::getLetter)
                .collect(Collectors.toList());

        String word = findValidWord(letters);
        if (word == null) {
            tiles.clear();
            tiles.addAll(game.getBag().extractTiles(7));
            return;
        }

        int wordScore = 0;

        for (char c : word.toCharArray()) {
            for (int i = 0; i < tiles.size(); i++) {
                Tile t = tiles.get(i);
                if (t.getLetter() == c) {
                    wordScore += t.getPoints();
                    tiles.remove(i);
                    break;
                }
            }
        }

        game.getBoard().addWord(this, word);
        this.score += wordScore;

        tiles.addAll(game.getBag().extractTiles(word.length()));

        System.out.println(name + " played " + word + " (+" + wordScore + " points)");
        System.out.println("tiles left in bag: " + game.getBag().size());
    }


    private String findValidWord(List<Character> letters) {
        Set<String> permutations = generateAllPermutations(letters);
        for (String word : permutations) {
            if (game.getDictionary().isWord(word)) {
                return word;
            }
        }
        return null;
    }


    private Set<String> generateAllPermutations(List<Character> letters) {
        Set<String> result = new HashSet<>();
        permute("", letters, result);
        return result;
    }

    private void permute(String prefix, List<Character> remaining, Set<String> result) {
        if (!prefix.isEmpty()) result.add(prefix);
        for (int i = 0; i < remaining.size(); i++) {
            List<Character> next = new ArrayList<>(remaining);
            char c = next.remove(i);
            permute(prefix + c, next, result);
        }
    }
}
