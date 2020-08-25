package com.epam.university.java.core.task004;

import java.util.ArrayList;
import java.util.Arrays;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> list = new ArrayList<>(first.length > second.length ? second.length : first.length);
        for (int i = 0; i < first.length; i++) {
            String current = first[i];
            if (Arrays.stream(second).anyMatch(x -> x == current)) {
                list.add(current);
            }
        }
        String[] ret = new String[list.size()];
        ret = list.toArray(ret);
        return ret;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> list = new ArrayList<String>(first.length + second.length);
        for (int i = 0; i < first.length; i++) {
            if (!list.contains(first[i])) {
                list.add(first[i]);
            }
        }
        for (int i = 0; i < second.length; i++) {
            if (!list.contains(second[i])) {
                list.add(second[i]);
            }
        }
        String[] ret = new String[list.size()];
        ret = list.toArray(ret);
        return ret;
    }
}