package com.epam.university.java.core.task066;

public class Task066Impl implements Task066 {
    @Override
    public long repeatString(String infiniteString, long limiter) {
        if (infiniteString == null || limiter < 0) {
            throw new IllegalArgumentException();
        }
        if (infiniteString.equals("a")) {
            return limiter;
        }
        long count = countIt(infiniteString, infiniteString.length());
        long div = limiter / infiniteString.length();
        return (div * count) + countIt(infiniteString, limiter % infiniteString.length());
    }

    /**
     * Knight attack.
     */
    public static long countIt(String s, long times) {
        long count = 0;
        for (int i = 0; i < times; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }
}
