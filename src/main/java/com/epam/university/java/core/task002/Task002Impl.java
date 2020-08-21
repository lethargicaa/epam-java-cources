package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null) {
            throw new IllegalArgumentException();
        } else if (secondString == null) {
            throw new IllegalArgumentException();
        }
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        try {
            return sourceString.substring(0, number).trim();
        } catch (IndexOutOfBoundsException ex) {
            return sourceString;
        }
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        try {
            int index = sourceString.indexOf(separator);
            return sourceString.substring(0, index).trim();
        } catch (IndexOutOfBoundsException ex) {
            return sourceString;
        }
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        try {
            return sourceString.substring(number + 1).trim();
        } catch (IndexOutOfBoundsException ex) {
            return sourceString;
        }
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        try {
            int index = sourceString.indexOf(separator);
            return sourceString.substring(index + 1).trim();
        } catch (IndexOutOfBoundsException ex) {
            return sourceString;
        }
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null || sourceCollection.length < 1 || glue == null) {
            throw new IllegalArgumentException();
        }
        return String.join(glue, sourceCollection);
    }
}