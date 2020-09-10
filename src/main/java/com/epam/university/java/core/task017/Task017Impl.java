package com.epam.university.java.core.task017;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        if (args.length == 0 || args[0] == null) {
            throw new IllegalArgumentException();
        }
        return String.format("You know " + args[0] + ", " + args[1] + "!");
    }

    @Override
    public String formatNumbers(Object... args) {
        if (args.length == 0 || args[0] == null) {
            throw new IllegalArgumentException();
        }
        String s1 = Double.toHexString((double) args[0]);
        String s2 = String.format(Locale.ROOT, "%+.2f", (double) args[0]);
        String s3 = String.format(Locale.ROOT, "%.2f", (double) args[0]);
        String s = ((double) args[0] + ", " + s3 + ", " + s2 + ", " + s1);
        return s;
    }

    @Override
    public String formatDates(Object... args) {
        if (args.length == 0 || args[0] == null) {
            throw new IllegalArgumentException();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        String s = dateFormat.format(args[0]);
        return s;
    }
}
