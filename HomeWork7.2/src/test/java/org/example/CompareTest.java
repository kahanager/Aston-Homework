package org.example;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareTest {
    @DataProvider(name = "compareObject")
    public Object[][] compareObject() {
        return new Object[][]{
                {3, 4, "3 < 4"},
                {50, 6, "50 > 6"},
                {0, 0, "0 = 0"},
                {-1, -100, "-1 > -100"}
        };
    }
    @Test(dataProvider = "compareObject")
    public void testCompare(int inputA, int inputB, String out) {
        assertEquals(Compare.compare(inputA, inputB), out);
    }
}
