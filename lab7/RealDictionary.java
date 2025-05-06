package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RealDictionary implements Dictionary {
    private final Set<String> words = new HashSet<>();

    public RealDictionary(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.toLowerCase());
            }
        }
    }

    @Override
    public boolean isWord(String word) {
        return words.contains(word.toLowerCase());
    }
}
