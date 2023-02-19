package ru.stqa.pft.sandbox;

public class Point4 {
    public double x;
    public double y;

    public static void main(String[] args) {
        Point4 p1 = new Point4();
        Point4 p2 = new Point4();
        p1.x = -2.0;
        p1.y = -8.0;
        p2.x = 4.0;
        p2.y = 9.0;

        System.out.println("Расстояние между точками Point 1(" + p1.x + ";" + p1.y + ") и Point 2(" + p1.x + ";" + p1.y + ") = " + p1.distance(p2));

    }
    public double distance (Point4 p2) {

        return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
    }

}
