package org.example;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Bag {
    private final Queue<Tile> letters = new LinkedList<>();

    public Bag() {
        Random rand = new Random();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < 10; i++) {
                letters.add(new Tile(c, rand.nextInt(10) + 1));
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany && !letters.isEmpty(); i++) {
            extracted.add(letters.poll());
        }
        return extracted;
    }

    public synchronized boolean isEmpty() {
        return letters.isEmpty();
    }

    public synchronized int size() {
        return letters.size();
    }
}
