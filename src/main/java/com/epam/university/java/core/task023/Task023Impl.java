package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        if (phoneString == null || phoneString.isBlank()) {
            throw new IllegalArgumentException();
        }
        Pattern pat = Pattern.compile("9.2");
        Matcher matcher = pat.matcher(phoneString);
        String next = "";
        if (matcher.find()) {
            next = matcher.group(0);
        } else {
            throw new IllegalArgumentException();
        }
        return next;
    }
}
