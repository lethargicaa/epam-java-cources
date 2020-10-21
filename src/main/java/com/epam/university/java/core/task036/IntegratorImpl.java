package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double increment = 1E-4;
        double area = 0;
        double modifier = 1;
        if (left > right) {
            double tempA = left;
            left = right;
            right = tempA;
            modifier = -1;
        }
        for (double i = left + increment; i < right; i += increment) {
            double dFromA = i - left;
            area += (increment / 2) * (function.apply(left + dFromA)
                    + function.apply(left + dFromA - increment));
        }
        return area;
    }
}
//(7 / (Math.pow(x, 2) + 1))