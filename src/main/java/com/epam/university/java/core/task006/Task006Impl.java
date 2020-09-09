package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        double i = 0;
        double u = 0;
        int count = 0;
        for (Measurement m : measurements) {
            i += m.getAmperage();
            u += m.getVoltage();
            count++;
        }
        double avgI = i / count;
        double avgU = u / count;

        double devU = 0;
        double devI = 0;

        for (Measurement m : measurements) {
            devU += (m.getVoltage() - avgU) * (m.getAmperage() - avgI);
            devI += Math.pow(m.getAmperage() - avgI, 2);
        }

        return ((int) ((devU / devI) * 1000)) / 1000.0;
    }
}
