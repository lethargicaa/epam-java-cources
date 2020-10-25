package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker)
            throws Exception {
        if (ticker == null || tacker == null) {
            throw new IllegalArgumentException();
        }
        List<String> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures.add(ticker.call());
            futures.add(tacker.call());
        }

        return futures;
    }
}
