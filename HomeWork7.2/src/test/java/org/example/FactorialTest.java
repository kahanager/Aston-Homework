package org.example;

import org.testng.annotations.*;
import java.math.BigInteger;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorial1() {
        assertEquals(BigInteger.ONE, Factorial.factorial(0));
    }

    @Test
    public void testFactorial2() {
        assertEquals(BigInteger.ONE, Factorial.factorial(1));
    }

    @DataProvider(name = "factorialObject")
    public Object[][] factorialObject() {
        return new Object[][]{
                {2, 2},
                {3, 6},
                {4, 24}
        };
    }
    @Test(dataProvider = "factorialObject")
    public void testFactorial3(int input, int out) {
        assertEquals(BigInteger.valueOf(out), Factorial.factorial(input));
    }

    @Test
    public void testFactorial4() {
        BigInteger result = Factorial.factorial(20);
        assertEquals(BigInteger.valueOf(2432902008176640000L), result);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorial5() {
        Factorial.factorial(-1);
    }
}
