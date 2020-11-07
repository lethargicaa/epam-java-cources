package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null || actions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (var action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        if (figure == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Vertex> arr = (ArrayList<Vertex>) figure.getVertexes();
        return convexHull(arr).size() == arr.size();
    }

    private static int orientation(Vertex p, Vertex q, Vertex r) {
        int val = (q.getY() - p.getY()) * (r.getX() - q.getX())
                - (q.getX() - p.getX()) * (r.getY() - q.getY());
        if (val == 0) {
            return 0;
        }
        return (val > 0) ? 1 : 2;
    }

    private static ArrayList<Vertex> convexHull(ArrayList<Vertex> points) {
        int n = points.size();
        if (n < 3) {
            throw new IllegalArgumentException();
        }
        ArrayList<Vertex> hull = new ArrayList<>();
        int l = 0;
        for (int i = 1; i < n; i++) {
            if (points.get(i).getX() < points.get(l).getX()) {
                l = i;
            }
        }
        int p = l;
        int q;
        do {
            hull.add(points.get(p));
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                if (orientation(points.get(p), points.get(i), points.get(q)) == 2) {
                    q = i;
                }
            }
            p = q;
        } while (p != l);
        Vertex last = hull.get(hull.size() - 1);
        Vertex first = hull.get(0);
        for (Vertex point  : points)
        {
            if (!point.equals(last) && !point.equals(first) && orientation(last, point, first) == 0)
            {
                hull.add(point);
            }
        }
        return hull;
    }

    private static boolean withIn(int a, int b, int c) {
        return (b < a && a < c) || (c < a && a < b);
    }

    private static boolean pointOnLine(Vertex target, Vertex a, Vertex b) {
        return (target.getX() - a.getX()) * (b.getY() - a.getY())
                - (target.getY() - a.getY()) * (b.getX() - a.getX()) == 0
                && withIn(target.getX(), a.getX(), b.getX());
    }
}
