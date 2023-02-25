package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


    @Test

    public void testPoint1 () {

        Point p1 = new Point(-2.0, -8.0);
        Point p2 = new Point(4.0, 9.0);

        Assert.assertEquals(p1.distance(p2), 18.027756377319946);
    }

    @Test
    public void testPoint2 () {
        Point p1 = new Point(-1.0, -7.0);
        Point p2 = new Point(6.0, 8.0);

        Assert.assertEquals(p1.distance(p2), 16.55294535724685);
    }

    @Test
    public void testPoint3 () {
        Point p1 = new Point(2.0, 3.0);
        Point p2 = new Point(6.0, 8.0);

        Assert.assertEquals(p1.distance(p2), 6.4031242374328485);
    }
}
