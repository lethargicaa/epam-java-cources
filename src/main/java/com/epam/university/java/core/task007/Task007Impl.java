package com.epam.university.java.core.task007;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {

        int[] arr1 = first.stream().mapToInt(i -> i).toArray();
        int[] arr2 = second.stream().mapToInt(i -> i).toArray();

        int m = arr1.length;
        int n = arr2.length;
        int[] prod = new int[m + n - 1];

        for (int i = 0; i < m + n - 1; i++) {
            prod[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prod[i + j] += arr1[i] * arr2[j];
            }
        }
        Integer[] iArray = Arrays.stream(prod).boxed().toArray(Integer[]::new);
        List<Integer> result = new ArrayList<>();
        Collections.addAll(result, iArray);
        return result;
    }
}

