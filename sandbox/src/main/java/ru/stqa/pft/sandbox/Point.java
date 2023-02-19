package ru.stqa.pft.sandbox;

public class Point {
    public double x;
    public double y;

    public static void main (String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();

        p1.x = -2.0;
        p1.y = -8.0;
        p2.x = 4.0;
        p2.y = 9.0;

        System.out.println("Расстояние между точками Point 1(" + p1.x + ";" + p1.y + ") и Point 2(" + p2.x + ";" + p2.y + ") = " + distance(p1, p2));

    }

    public static double distance (Point p1, Point p2) {

        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }
}
