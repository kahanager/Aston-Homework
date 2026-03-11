package org.example;


import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TriangleAreaTest {

    @Test
    public void testTriangle1() {
        double area = TriangleArea.area(3, 4, 5);
        assertEquals(6.0, area);
    }

    @DataProvider(name = "triangleObject")
    public Object[][] triangleObject() {
        return new Object[][]{
                {3, 4, 5, 6},
                {5, 6, 7, 14.70}
        };
    }
    @Test(dataProvider = "triangleObject")
    public void testTriangle2(int inputA, int inputB, int inputC, double out) {
        double area = TriangleArea.area(inputA, inputB, inputC);
        assertEquals(out, area);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleNegative1() {
        TriangleArea.area(-1, 2, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleNegative2() {
        TriangleArea.area(0, 1, 2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleWrongSides() {
        TriangleArea.area(1, 1, 3);
    }
}
