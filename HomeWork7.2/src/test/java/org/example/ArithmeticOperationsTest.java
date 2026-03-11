package org.example;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.example.ArithmeticOperations.*;


public class ArithmeticOperationsTest {

    @DataProvider(name = "addObject")
    public Object[][] addObject() {
        return new Object[][]{
                {1, 2, 3},
                {0, 0, 0},
                {-1, 100, 99}
        };
    }
    @Test(dataProvider = "addObject")
    public void testAddition(int inputA, int inputB, int out) {
        assertEquals(addition(inputA, inputB), out);
    }

    @DataProvider(name = "subObject")
    public Object[][] subObject() {
        return new Object[][]{
                {4, 2, 2},
                {0, 0, 0},
                {-1, 100, -101}
        };
    }
    @Test(dataProvider = "subObject")
    public void testSubtract(int inputA, int inputB, int out) {
        assertEquals(subtract(inputA, inputB), out);
    }

    @DataProvider(name = "mulObject")
    public Object[][] mulObject() {
        return new Object[][]{
                {2, 2, 4},
                {0, 4, 0},
                {-1, 100, -100}
        };
    }
    @Test(dataProvider = "mulObject")
    public void testMultiply(int inputA, int inputB, int out) {
        assertEquals(multiply(inputA, inputB), out);
    }

    @DataProvider(name = "divObject")
    public Object[][] divObject() {
        return new Object[][]{
                {2, 2, 1},
                {0, 4, 0},
                {-100, 1, -100}
        };
    }
    @Test(dataProvider = "divObject")
    public void testDivide(int inputA, int inputB, int out) {
        assertEquals(divide(inputA, inputB), out);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideThrow() {
        divide(1, 0);
    }
}
