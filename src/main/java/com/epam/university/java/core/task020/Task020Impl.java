package com.epam.university.java.core.task020;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        if (stones == null || stones.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Set<Character> set = convertToSet(stones.toString());
        for (String s : stones) {
            set.retainAll(convertToSet(s));
        }
        return set.size();
    }

    private Set<Character> convertToSet(String s) {
        Set<Character> set = new HashSet<Character>(26);
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}

