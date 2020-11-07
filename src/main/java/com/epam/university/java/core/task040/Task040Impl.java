package com.epam.university.java.core.task040;

import java.util.ArrayList;

public class Task040Impl implements Task040 {
    @Override
    public int countScore(String str) {
        if (str == null || str == "") {
            throw new IllegalArgumentException();
        }
        final int strike = 10;
        int frame = 0;
        int score = 0;
        int previousScore = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        char[] massive = str.toCharArray();
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == ' ') {
                continue;
            } else if (massive[i] == 'X') {
                arrayList.add(10);
            } else if (massive[i] == '/') {
                arrayList.add(10 - (massive[i - 1] - '0'));
            } else {
                arrayList.add(massive[i] - '0');
            }
        }
        int[] ballThrows = new int[arrayList.size()];
        for (int i = 0; i < ballThrows.length; i++) {
            ballThrows[i] = arrayList.get(i).intValue();
        }
        int i = 0;
        while (frame < 10) {
            if (ballThrows[i] == strike) {
                score = previousScore + strike + ballThrows[i + 1] + ballThrows[i + 2];
                if (frame == 9) {
                    i += 2;
                }
                i++;
            } else {
                if (ballThrows[i] + ballThrows[i + 1] == strike) {
                    score = previousScore + strike + ballThrows[i + 2];
                    if (frame == 9) {
                        i++;
                    }
                } else if (ballThrows[i] + ballThrows[i + 1] < strike) {
                    score = previousScore + ballThrows[i] + ballThrows[i + 1];
                }
                i += 2;
            }
            previousScore = score;
            frame++;
        }
        return score;
    }
}
