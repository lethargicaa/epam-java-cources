package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    private int multiplication;
    private int first;
    private int second;

    public VampireNumberImpl(int multiplication, int first, int second) {
        this.multiplication = multiplication;
        this.first = first;
        this.second = second;
    }


    @Override
    public int getMultiplication() {
        return this.multiplication;
    }

    @Override
    public int getFirst() {
        return this.first;
    }

    @Override
    public int getSecond() {
        return this.second;
    }
}

//equals
//Check if two vampire numbers are equals in spite of the order of parts.