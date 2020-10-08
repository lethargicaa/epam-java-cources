package com.epam.university.java.core.task003;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        String temp;
        int n = source.length;
        for (int i = 0; i < n / 2; i++) {
            temp = source[n - i - 1];
            source[n - i - 1] = source[i];
            source[i] = temp;
        }
        return source;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        int firstlength = first.length;
        int secondlength = second.length;
        String[] result = new String[firstlength + secondlength];
        System.arraycopy(first, 0, result, 0, firstlength);
        System.arraycopy(second, 0, result, firstlength, secondlength);
        return result;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException();
        }
        int maxValue = source[0];
        for (int i = 0; i < source.length; i++) {
            if (source[i] > maxValue) {
                maxValue = source[i];
            }
        }
        return maxValue;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> list = new ArrayList<>(source.length);
        for (int i = 0; i < source.length; i++) {
            if (condition.isValid(source[i])) {
                list.add(source[i]);
            }
        }
        String[] ret = new String[list.size()];
        ret = list.toArray(ret);
        return ret;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> list = new ArrayList<>(source.length);
        for (int i = 0; i < source.length; i++) {
            String current = source[i];
            if (!Arrays.stream(toRemote).anyMatch(x -> x == current)) {
                list.add(current);
            }
        }
        String[] ret = new String[list.size()];
        ret = list.toArray(ret);
        return ret;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < source.length; i++) {
            source[i] = operation.map(source[i]);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < source.length; i++) {
            String[] parsedSource = operation.flatMap(source[i]);
            for (int j = 0; j < parsedSource.length; j++) {
                set.add(Integer.parseInt(parsedSource[j].trim()));
            }
        }
        String[] ret = new String[set.size()];
        int i = 0;
        for (Integer number : set) {
            ret[ret.length - ++i] = number.toString();
        }
        return ret;
    }
}