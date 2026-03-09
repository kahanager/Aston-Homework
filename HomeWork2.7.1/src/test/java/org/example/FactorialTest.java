package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    void testFactorialOfZero() {
        assertEquals(BigInteger.ONE, Factorial.factorial(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(BigInteger.ONE, Factorial.factorial(1));
    }

    @ParameterizedTest
    @CsvSource({"2, 2", "3, 6", "4, 24", "5, 120" })
    void testFactorialOfPositiveNumbers(int input, int expected) {
        assertEquals(BigInteger.valueOf(expected), Factorial.factorial(input));
    }

    @Test
    void testFactorialOfLargeNumber() {
        BigInteger result = Factorial.factorial(10);
        assertEquals(BigInteger.valueOf(3628800), result);
    }

    @Test
    void testFactorialOfNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
}
