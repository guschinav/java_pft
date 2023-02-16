package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


    @Test

    public void testDistance (){
        Distance4 p1 = new Distance4(-2.4, -8.8, 4.7, 9.8);
        Assert.assertEquals(p1.distance(), 19.9090431713832);
    }
}
