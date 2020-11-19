package com.epam.university.java.core.task025;

import java.util.Stack;

public class Task025Impl implements Task025 {

    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        }

        int errors = 0;
        char[] array = sourceMessage.toLowerCase().toCharArray();
        Stack<Character> sos = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 's') {
                if (sos.size() == 0) {
                    sos.push('s');
                } else if (sos.size() == 2) {
                    sos.clear();
                } else {
                    errors++;
                    sos.clear();
                }
            } else if (array[i] == 'o') {
                if (sos.size() == 0 & i == 7) {
                    sos.push('o');
                }
                if (sos.size() == 1) {
                    sos.push('o');
                } else {
                    errors++;
                    sos.clear();
                }
            } else {
                errors++;
                if (sos.size() == 1 && i < array.length - 1 && array[i + 1] == 's') {
                    i++;
                }
                if (i < array.length - 2 && array[i + 1] == 'o' && array[i + 2] == 's') {
                    i += 2;
                }
                sos.clear();
            }
        }
        return errors;
    }
}


