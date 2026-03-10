package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {
    @Test
    void testValidTriangle() {
        double area = TriangleArea.area(3, 4, 5);
        assertEquals(6.0, area, 1e-9);
    }


    @Test
    void testNonPositiveSideThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.area(-1, 2, 2));
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.area(0, 3, 4));
    }

    @Test
    void testInvalidTriangleThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.area(1, 1, 3));

    }
}
