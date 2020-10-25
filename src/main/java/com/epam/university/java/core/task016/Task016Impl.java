package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;

public class Task016Impl implements Task016 {
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        radius = radius * 2;
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        Collection<Coordinate> result = new ArrayList<>();
        for (int i = -radius; i < radius; i++) {
            for (int j = -radius; j < radius; j++) {
                if (getDistanceFromZero(i, j) < radius && i != 0 && j != 0) {
                    result.add(new CoordinateImpl(i, j));
                }
            }
        }
        return result;
    }

    private static double getDistanceFromZero(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }


}


// A = √(X²+Y²) = √ ((X2-X1)²+(Y2-Y1)²)