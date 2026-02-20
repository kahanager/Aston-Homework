package org.example;

import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) {
        //10. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и
        // условия заменить 0 на 1, 1 на 0;
        int[] binArray = {0, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        for (int i = 0; i < 9; i++) {
            if (binArray[i] == 0) {
                binArray[i] = 1;
            } else binArray[i] = 0;
        }
        System.out.println(Arrays.toString(binArray));
    }
}
