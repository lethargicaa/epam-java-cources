package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.Collection;

public class Task021Impl implements Task021 {


    @Override
    public Point calculate(Collection<Point> minePositions) {

        if (minePositions == null || minePositions.size() < 3) {
            throw new IllegalArgumentException();
        }
        Point[] points = new Point[3];
        int i = 0;
        for (Point x : minePositions) {
            points[i] = x;
            i++;
        }


        Point a = points[0];
        Point b = points[1];
        Point c = points[2];

        Point c1 = getEqTrianglePoint(a, b, c);
        Point b1 = getEqTrianglePoint(a, c, b);

        return getCrossPoint(c, c1, b, b1);
    }


    private static double getDistance(Point a, Point b) {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }
    private static Point getEqTrianglePoint(Point a, Point b, Point c) {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();

        double x = (x1 + x2 - (y1 - y2) * Math.sqrt(3)) / 2;
        double y = (y1 + y2 + (x1 - x2) * Math.sqrt(3)) / 2;
        Point c1 = new PointImpl(x, y);

        x = (x1 + x2 + (y1 - y2) * Math.sqrt(3)) / 2;
        y = (y1 + y2 - (x1 - x2) * Math.sqrt(3)) / 2;
        Point c2 = new PointImpl(x, y);

        return getDistance(c, c1) > getDistance(c, c2) ? c1 : c2;
    }
    private static Point getCrossPoint(Point a, Point b, Point c, Point d) {
        double a1 = b.getY() - a.getY();
        double b1 = a.getX() - b.getX();
        double c1 = a1 * a.getX() + b1 * a.getY();

        double a2 = d.getY() - c.getY();
        double b2 = c.getX() - d.getX();
        double c2 = a2 * c.getX() + b2 * c.getY();

        double delta = a1 * b2 - a2 * b1;

        if (delta == 0) {
            return null;
        }

        double x = (b2 * c1 - b1 * c2) / delta;
        double y = (a1 * c2 - a2 * c1) / delta;

        return new PointImpl(x, y);
    }
}
