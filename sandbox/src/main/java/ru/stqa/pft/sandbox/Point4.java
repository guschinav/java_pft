package ru.stqa.pft.sandbox;

public class Point4 {
    public double x1, y1, x2, y2;

    public static void main(String[] args) {
        Distance4 p1 = new Distance4(-2.4, -8.8, 4.7, 9.8);

        System.out.println("Расстояние между точками Point 1(" + p1.x1 + ";" + p1.y1 + ") и Point 2(" + p1.x2 + ";" + p1.y2 + ") = " + p1.distance());

    }

}
