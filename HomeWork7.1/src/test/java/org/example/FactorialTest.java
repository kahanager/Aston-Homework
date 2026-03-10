package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FactorialTest {
    @Test
    void testFactorial1() {
        assertEquals(BigInteger.ONE, Factorial.factorial(0));
    }

    @Test
    void testFactorial2() {
        assertEquals(BigInteger.ONE, Factorial.factorial(1));
    }

    @ParameterizedTest
    @CsvSource({"2, 2", "3, 6", "4, 24"})
    void testFactorial3(int input, int out) {
        assertEquals(BigInteger.valueOf(out), Factorial.factorial(input));
    }

    @Test
    void testFactorial4() {
        BigInteger result = Factorial.factorial(20);
        assertEquals(BigInteger.valueOf(2432902008176640000L), result);
    }

    @Test
    void testFactorial5() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
}
