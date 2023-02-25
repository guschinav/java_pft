package ru.stqa.pft.sandbox;

public class Point {
    public double x, y;


    public  Point (double x, double y){
        this.x = x;
        this.y = y;
    }


    public static void main (String[] args) {
        Point p1 = new Point(-2.0, -8.0);
        Point p2 = new Point(4.0, 9.0);


        System.out.println("Расстояние между точками Point 1(" + p1.x + ";" + p1.y + ") и Point 2(" + p2.x + ";" + p2.y + ") = " + distance(p1, p2));

        //Использование метода
        System.out.println("Расстояние между точками Point 1(" + p1.x + ";" + p1.y + ") и Point 2(" + p2.x + ";" + p2.y + ") = " + p1.distance(p2));

    }

    //Функция
    public static double distance (Point p1, Point p2) {

        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

    //Метод
    public double distance (Point p2) {

        return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
    }
}
