package org.example;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTest {
    @ParameterizedTest
    @CsvSource({"3, 4, '3 < 4'", "50, 6, '50 > 6'", "0, 0, '0 = 0'", "-1, -100, '-1 > -100'"})
    void testCompare(int inputA, int inputB, String out) {
        assertEquals(Compare.compare(inputA, inputB), out);
    }
}
