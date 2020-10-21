package com.epam.university.java.core.task015;

import com.epam.university.java.core.task013.Vertex;

import java.util.ArrayList;


public class Task015Impl implements Task015 {
    public final int limit = 100;

    @Override
    public double getArea(Square first, Square second) {
        ArrayList<Point> points = getPoints((SquareImpl) first, (SquareImpl) second);
        if (points.size() < 3) {
            return 0;
        }
        ArrayList<Point> sortedPoints = convexHull(points);
        double sum = 0;
        for (int i = 0; i < points.size(); i++) {
            sum += (sortedPoints.get(i).getX() * sortedPoints.get((i + 1)
                    % sortedPoints.size()).getY()) - (sortedPoints.get((i + 1)
                    % sortedPoints.size()).getX() * sortedPoints.get(i).getY());
        }

        return Math.abs(sum / 2);
    }

    private static boolean surround(Point point, Point[] points) {
        int i1;
        int i2;
        double s;
        double s1;
        double s2;
        double s3;
        boolean flag = false;
        for (int i = 0; i < points.length; i++) {
            flag = false;
            i1 = (i + 1) % points.length;
            while (!flag) {
                i2 = (i1 + 1) % points.length;
                if (i2 == (i + 1) % points.length) {
                    break;
                }
                s = Math.abs((points[i1].getX() * (points[i2].getY() - points[i].getY()))
                        + (points[i2].getX() * (points[i].getY() - points[i1].getY()))
                        + (points[i].getX() * (points[i1].getY() - points[i2].getY())));

                s1 = Math.abs((points[i1].getX() * (points[i2].getY() - point.getY()))
                        + (points[i2].getX() * (point.getY() - points[i1].getY()))
                        + (point.getX() * (points[i1].getY() - points[i2].getY())));

                s2 = Math.abs((points[i].getX() * (points[i2].getY() - point.getY()))
                        + (points[i2].getX() * (point.getY() - points[i].getY()))
                        + (point.getX() * (points[i].getY() - points[i2].getY())));

                s3 = Math.abs((points[i1].getX() * (points[i].getY() - point.getY()))
                        + (points[i].getX() * (point.getY() - points[i1].getY()))
                        + (point.getX() * (points[i1].getY() - points[i].getY())));
                if (s == s1 + s2 + s3) {
                    flag = true;
                    break;
                }
                i1 = (i1 + 1) % points.length;
            }
            if (!flag) {
                break;
            }
        }
        return flag;
    }

    private static boolean isOutside(double x, double y, Point prevPoint, Point currPoint) {
        return (x < prevPoint.getX() && x < currPoint.getX())
                || (x > prevPoint.getX() && x > currPoint.getX())
                || (y < prevPoint.getY() && y < currPoint.getY())
                || (y > prevPoint.getY() && y > currPoint.getY());
    }

    private static Point tryFindIntersection(Point prevPoint1, Point currPoint1,
                                             Point prevPoint2, Point currPoint2) {
        double a1 = currPoint1.getY() - prevPoint1.getY();
        double b1 = prevPoint1.getX() - currPoint1.getX();
        double c1 = a1 * prevPoint1.getX() + b1 * prevPoint1.getY();

        double a2 = currPoint2.getY() - prevPoint2.getY();
        double b2 = prevPoint2.getX() - currPoint2.getX();
        double c2 = a2 * prevPoint2.getX() + b2 * prevPoint2.getY();

        double delta = a1 * b2 - a2 * b1;

        if (delta == 0) {
            return null;
        }
        double x = (b2 * c1 - b1 * c2) / delta;
        double y = (a1 * c2 - a2 * c1) / delta;

        if (isOutside(x, y, prevPoint1, currPoint1) || isOutside(x, y, prevPoint2, currPoint2)) {
            return null;
        }

        return new PointImpl(x, y);
    }

    private static double orientation(Point p, Point q, Point r) {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX())
                - (q.getX() - p.getX()) * (r.getY() - q.getY());
        if (val == 0) {
            return 0;
        }
        return (val > 0) ? 1 : 2;
    }

    private static ArrayList<Point> convexHull(ArrayList<Point> points) {
        int n = points.size();
        if (n < 3) {
            throw new IllegalArgumentException();
        }
        ArrayList<Point> hull = new ArrayList<>();
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
        return hull;
    }

    private static ArrayList<Point> getPoints(SquareImpl a, SquareImpl b) {
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < a.getPoints().length; i++) {
            if ((surround(a.getPoints()[i], b.getPoints())) && !points.contains(a.getPoints()[i])) {
                points.add(a.getPoints()[i]);
            }
        }
        for (int i = 0; i < b.getPoints().length; i++) {
            if ((surround(b.getPoints()[i], a.getPoints())) && !points.contains(b.getPoints()[i])) {
                points.add(b.getPoints()[i]);
            }
        }
        for (int i = 0; i < a.getPoints().length; i++) {
            for (int j = 0; j < b.getPoints().length; j++) {
                Point crossPoint = tryFindIntersection(a.getPoints()[i],
                        a.getPoints()[(i + 1) % a.getPoints().length], b.getPoints()[j],
                        b.getPoints()[(j + 1) % b.getPoints().length]);
                if ((crossPoint != null) && !points.contains(crossPoint)) {
                    points.add(crossPoint);
                }
            }
        }
        return points;
    }
}