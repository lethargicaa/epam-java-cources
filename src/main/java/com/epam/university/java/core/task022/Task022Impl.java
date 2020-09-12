package com.epam.university.java.core.task022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(numbers);
        Collections.sort(list);
        int max = 0;
        for (int j = 0; j < (list.size() - 1); j++) {
            max = max + list.get(j + 1);
        }
        return max;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(numbers);
        Collections.sort(list);
        int min = 0;
        for (int j = 0; j < (list.size() - 1); j++) {
            min = min + list.get(j);
        }
        return min;
    }
}
