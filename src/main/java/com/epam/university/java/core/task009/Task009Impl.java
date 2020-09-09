package com.epam.university.java.core.task009;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;


public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Scanner in = null;
        try {
            in = new Scanner(sourceFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashSet<String> set = new HashSet<>();
        while (in.hasNext()) {
            set.addAll(Arrays.asList(in.nextLine().replaceAll("[^a-zA-Z ]", "")
                    .toLowerCase().split("\\s+")));
        }
        return set;
    }
}


