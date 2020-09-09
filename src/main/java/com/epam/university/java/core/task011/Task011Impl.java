package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        List<String> list1 = new ArrayList<String>();
        Collections.addAll(list1, collection);
        int pos = -1;
        while (list1.size() > 1) {
            pos = (pos + 1) % list1.size();
            list1.remove(pos);
        }
        return (list1.get(0));
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        int pos = -1;
        while (collection.size() != 1) {
            pos = (pos + 1) % collection.size();
            collection.remove(pos);
        }
        return (collection.get(0));
    }


    @Override
    public String getLastName(LinkedList<String> collection) {
        List<String> list1 = new ArrayList<String>(collection);
        int pos = -1;
        while (list1.size() != 1) {
            pos = (pos + 1) % list1.size();
            list1.remove(pos);
        }
        return (list1.get(0));
    }
}
