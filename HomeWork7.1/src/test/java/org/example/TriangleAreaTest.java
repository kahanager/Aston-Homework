package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {
    @Test
    void testTriangle1() {
        double area = TriangleArea.area(3, 4, 5);
        assertEquals(6.0, area);
    }

    @ParameterizedTest
    @CsvSource({"3, 4, 5, 6", "5, 6, 7, 14.70"})
    void testTriangle2(int inputA, int inputB, int inputC, double out) {
        double area = TriangleArea.area(inputA, inputB, inputC);
        assertEquals(out, area);
    }

    @Test
    void testTriangleNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.area(-1, 2, 3));
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.area(0, 1, 2));
    }

    @Test
    void testTriangleWrongSides() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.area(1, 1, 3));

    }
}
