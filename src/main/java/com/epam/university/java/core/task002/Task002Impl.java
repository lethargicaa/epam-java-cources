package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null) {
            throw new IllegalArgumentException();
        } else if (secondString == null) {
            throw new IllegalArgumentException();
        }
        if (firstString.equals(secondString)) {
            return true;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
        @Override
        public String left (String sourceString,int number){
            return sourceString.substring(0, number);
        }

        @Override
        public String left (String sourceString, String separator){
            return null;
        }

        @Override
        public String right (String sourceString,int number){
            return null;
        }

        @Override
        public String right (String sourceString, String separator){
            return null;
        }

        @Override
        public String[] split (String sourceString, String split){
            return new String[0];
        }

        @Override
        public String join (String[]sourceCollection, String glue){
            return null;
        }
    }