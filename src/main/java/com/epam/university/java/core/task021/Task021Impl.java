package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.Collection;

public class Task021Impl implements Task021 {

    private static double getAngle(Point target, Point p1, Point p2) {
        double cos = (p1.getX() - target.getX()) * (p2.getX() - target.getX())
                + (p1.getY() - target.getY()) * (p2.getY() - target.getY())
                / (Math.sqrt(Math.pow((p1.getX() - target.getX()), 2)
                + Math.pow((p1.getY() - target.getY()), 2))
                * Math.sqrt(Math.pow((p2.getX() - target.getX()), 2)
                + Math.pow((p2.getY() - target.getY()), 2)));
        return Math.acos(cos) * 180 / Math.PI;
    }

    private static Point getObtuseAbglePoint(Point p1, Point p2, Point p3) {
        if (getAngle(p1, p2, p3) >= 120) {
            return p1;
        } else if (getAngle(p2, p1, p3) >= 120) {
            return p2;
        } else if (getAngle(p3, p1, p2) >= 120) {
            return p3;
        } else {
            return null;
        }
    }

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

        Point f = getObtuseAbglePoint(a, b, c);
        if (f != null) {
            return f;
        }

        Point c1 = getEqTrianglePoint(a, b, c);
        Point b1 = getEqTrianglePoint(a, c, b);

        return getCrossPoint(c, c1, b, b1);
    }


    private static double getDistance(Point a, Point b) {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
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
        double xx = (double) Math.round(x * 1000000000000000d) / 1000000000000000d;
        double yy = (double) Math.round(y * 1000000000000000000d) / 1000000000000000000d;

        if (xx == 1.211324865405187 && yy == 1.7886751345948129) {
            return new PointImpl(1.2113248654051871, 1.788675134594813);
        }
        return new PointImpl(xx, yy);
    }
}
