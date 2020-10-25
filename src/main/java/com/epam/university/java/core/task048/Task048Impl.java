package com.epam.university.java.core.task048;


import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Task048Impl implements Task048 {
    private static List<Integer> replica = new ArrayList<>();

    @Override

    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {
        if (from == null || to == null || from < 0 || to < 0) {
            throw new IllegalArgumentException();
        }
        int[] array = getNumbers(to);
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> armstrongNumbers = new TreeSet<>(Arrays.stream(array)
                .boxed().collect(Collectors.toSet()));

        for (int a : armstrongNumbers) {
            if (a != 0 && a >= from) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * getNumbers.
     */
    public static int[] getNumbers(int n) {
        for (int i = 0; i <= n; i++) {
            if (isNumberUnique(i)) {
                int sumOfPowers = sum(i);
                if (isArmstrongNumber(sumOfPowers)) {
                    replica.add(sumOfPowers);
                }
            }
        }

        int[] result = new int[replica.size()];
        for (int i = 0; i < replica.size(); i++) {
            result[i] = replica.get(i);
        }

        return result;
    }

    private static boolean isArmstrongNumber(int number) {
        if (sum(number) == number) {
            return true;
        }

        return false;
    }

    private static boolean isNumberUnique(int number) {
        int lastDigit = 0;
        int currentDigit;

        while (number > 0) {
            currentDigit = number % 10;
            if (lastDigit > currentDigit) {
                return false;
            }
            lastDigit = currentDigit;
            number /= 10;
        }

        return true;
    }

    /**
     * Sum.
     */
    public static int sum(int a) {
        int addition = 0;
        int d = ("" + a).length();
        int b = a % 10;
        while (a >= 1) {
            addition += Math.pow(b, d);
            a /= 10;
            b = a % 10;
        }

        return addition;
    }
}