package com.epam.university.java.core.task014;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VampireNumberImpl that = (VampireNumberImpl) o;
        return multiplication == that.multiplication &&
                (first == that.first &&
                second == that.second) ||
                (first == that.second &&
                second == that.first);
    }
}
