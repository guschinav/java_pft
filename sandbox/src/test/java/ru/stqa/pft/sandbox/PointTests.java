package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


    @Test

    public void testPoint (){
        Point p1 = new Point();
        Point p2 = new Point();
        p1.x = -2.0;
        p1.y = -8.0;
        p2.x = 4.0;
        p2.y = 9.0;
        Assert.assertEquals(p1.distance(p2), 18.027756377319946);
    }
}
