package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        List<String> list = new ArrayList<String>();
        if (source.equals("")) {
            return list;
        }
        String[] r = source.split("(?=\\p{Lu})");
        for (String s : r) {
            list.add(s.toLowerCase());
        }
        return list;
    }
}
