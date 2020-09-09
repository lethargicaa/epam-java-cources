package com.epam.university.java.core.task010;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {

        Map<String, Integer> wordCount = new HashMap<>();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(source.toPath(),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : lines) {

            String[] words = line.toLowerCase().split("\\s+");

            for (String word : words) {

                if (word.endsWith(":") || word.endsWith(".") || word.endsWith("!")
                        || word.endsWith("?") || word.endsWith(",")) {
                    word = word.substring(0, word.length() - 1);
                }

                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);

                } else {
                    wordCount.put(word, 1);
                }
            }
        }
        return wordCount;
    }
}
