package com.epam.university.java.core.task067;

import java.util.HashSet;
import java.util.Set;

public class Task067Impl implements Task067 {
    @Override
    public int knightMovements(int x1, int y1, int x2, int y2) {
        Set<int[]> coords = new HashSet<>();
        Set<int[]> coords2 = new HashSet<>();
        int count = 0;
        coords.add(new int[]{x1, y1});
        while (true) {
            for (int[] i : coords) {
                if (i[0] == x2 && i[1] == y2) {
                    return count;
                }
                coords2.add(new int[]{i[0] + 1, i[1] - 2});
                coords2.add(new int[]{i[0] + 1, i[1] + 2});
                coords2.add(new int[]{i[0] + 2, i[1] - 1});
                coords2.add(new int[]{i[0] + 2, i[1] + 1});
                coords2.add(new int[]{i[0] - 1, i[1] - 2});
                coords2.add(new int[]{i[0] - 1, i[1] + 2});
                coords2.add(new int[]{i[0] - 2, i[1] - 1});
                coords2.add(new int[]{i[0] - 2, i[1] + 1});
            }
            coords.clear();
            for (int[] i : coords2) {
                if (!(i[0] < 1 || i[0] > 8 || i[1] < 1 || i[1] > 8)) {
                    coords.add(i);
                }
            }
            coords2.clear();
            count++;
        }
    }
}
