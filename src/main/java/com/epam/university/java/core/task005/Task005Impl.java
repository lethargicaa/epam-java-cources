package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits < 1 || digits > 10) {
            throw new IllegalArgumentException();
        }

        int from = (int) Math.pow(10, digits - 1);
        int to = (int) Math.pow(10, digits) - 1;

        double temp;
        int first = 0;
        int second = 0;
        double diff = Math.abs(((double) to / from) - Math.PI);

        for (int i = to; i > from; i--) {
            for (int j = from; j <= to; j++) {
                if (i < j * 3) {
                    break;
                }
                temp = Math.abs(((double) i / j) - Math.PI);
                if (temp <= diff) {
                    diff = temp;
                    first = i;
                    second = j;
                }
            }
        }
        return new PiHolderImpl(first, second);
    }
}
