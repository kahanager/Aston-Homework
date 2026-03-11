package org.example;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториала отрицательного числа нет");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
