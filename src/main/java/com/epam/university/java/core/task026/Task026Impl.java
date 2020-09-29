package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {

    @Override
    public String encrypt(String sourceString, int shift) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        if (shift > 26) {
            shift = shift % 26;
        }
        char[] chars = sourceString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) ((c - 'A' + shift) % 26 + 'A');
            } else if (c >= 'a' && c <= 'z') {
                chars[i] = (char) ((c - 'a' + shift) % 26 + 'a');
            }
        }
        String z = new String(chars);
        return z;
    }


    @Override
    public String decrypt(String encryptedString, int shift) {
        if (shift > 26) {
            shift = shift % 26;
        }
        char[] chars = encryptedString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) ((c - 'A' + 26 - shift) % 26 + 'A');
            } else if (c >= 'a' && c <= 'z') {
                chars[i] = (char) ((c - 'a' + 26 - shift) % 26 + 'a');
            }
        }
        String z = new String(chars);
        return z;
    }
}

