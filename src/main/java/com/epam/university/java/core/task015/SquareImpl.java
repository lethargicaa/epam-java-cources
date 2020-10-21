package com.epam.university.java.core.task015;


public class SquareImpl implements Square {


    private Point first;
    private Point second;

    private int currentIndex;
    private Point[] points;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    /**
     * SquareImpl.
     */
    public SquareImpl(Point first, Point second) {
        this.first = first;
        this.second = second;
        Point center = new PointImpl((first.getX() + second.getX()) / 2,
                (first.getY() + second.getY()) / 2);
        Point p = new PointImpl(first.getX() - center.getX(), first.getY() - center.getY());
        Point half = cross(p);

        this.points = new Point[]{first,
                new PointImpl(center.getX() - half.getX(), center.getY() - half.getY()),
                second,
                new PointImpl(center.getX() + half.getX(), center.getY() + half.getY())
                //
        };
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public Point getFirst() {
        return first;
    }

    @Override
    public Point getSecond() {
        return second;
    }

    @Override
    public void setFirst(Point first) {
        this.first = first;
    }

    @Override
    public void setSecond(Point second) {
        this.second = second;
    }

    private Point cross(Point p) {
        return new PointImpl(-p.getY(), p.getX());
    }

}
