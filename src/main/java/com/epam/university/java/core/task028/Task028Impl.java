package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        return countWaysUtil(value, power, 1);
    }

    static int countWaysUtil(int x, int n, int num) {
        // Base cases
        int val = (int) (x - Math.pow(num, n));
        if (val == 0) {
            return 1;
        }
        if (val < 0) {
            return 0;
        }

        // Consider two possibilities, num is
        // included and num is not included.
        return countWaysUtil(val, n, num + 1) + countWaysUtil(x, n, num + 1);
    }
}
