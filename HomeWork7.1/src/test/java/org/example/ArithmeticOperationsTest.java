package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.example.ArithmeticOperations.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {
    @ParameterizedTest
    @CsvSource({"1, 2, 3", "0, 0, 0", "-1, 100, 99"})
    void testAddition(int inputA, int inputB, int out) {
        assertEquals(addition(inputA, inputB), out);
    }

    @ParameterizedTest
    @CsvSource({"4, 2, 2", "0, 0, 0", "-1, 100, -101"})
    void testSubtract(int inputA, int inputB, int out) {
        assertEquals(subtract(inputA, inputB), out);
    }

    @ParameterizedTest
    @CsvSource({"2, 2, 4", "0, 4, 0", "-1, 100, -100"})
    void testMultiply(int inputA, int inputB, int out) {
        assertEquals(multiply(inputA, inputB), out);
    }

    @ParameterizedTest
    @CsvSource({"2, 2, 1", "0, 4, 0", "-100, 1, -100"})
    void testDivide(int inputA, int inputB, int out) {
        assertEquals(divide(inputA, inputB), out);
    }

    @Test
    void testDivideThrow() {
        assertThrows(ArithmeticException.class,
                () -> divide(1, 0));
    }
}
