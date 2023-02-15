package ru.stqa.pft.sandbox;

public class Point {
    public double x1, y1, x2, y2;

    public static void main (String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();

        p1.x1 = -2.4;
        p1.y1 = -8.8;
        p2.x2 = 4.7;
        p2.y2 = 9.8;

        System.out.println("Расстояние между точками Point 1(" + p1.x1 + ";" + p1.y1 + ") и Point 2(" + p2.x2 + ";" + p2.y2 + ") = " + distance(p1, p2));

    }

    public static double distance (Point p1, Point p2) {

        return Math.sqrt((p2.x2 - p1.x1) * (p2.x2 - p1.x1) + (p2.y2 - p1.y1) * (p2.y2 - p1.y1));
    }
}
