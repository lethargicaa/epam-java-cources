package com.epam.university.java.core.task043;

public class Task043Impl implements Task043 {

    static String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", "!", ",", "?", ".", "'"};
    static String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "-.-.--", "--..--",
            "..--..", ".-.-.-", ".----.",};

    @Override
    public String decode(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        String build = "";
        String change = sourceString.trim();
        String[] words = change.split("   ");
        for (String word : words) {
            for (String letter : word.split(" ")) {
                for (int x = 0; x < morse.length; x++) {
                    if (letter.equals(morse[x])) {
                        build = build + alpha[x];
                    }
                }
            }
            build += " ";
        }

        return build.toUpperCase().trim();
    }

    @Override
    public String encode(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        String build = "";
        String change = sourceString.trim();
        String[] words = change.split(" ");
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                for (int x = 0; x < morse.length; x++) {
                    if (word.substring(i, i + 1).equalsIgnoreCase(alpha[x])) {
                        build = build + morse[x] + " ";
                    }
                }
            }
            build += "  ";
        }

        return build.trim();
    }

}