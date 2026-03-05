package org.example;

import java.util.Arrays;

public class Task14 {
    public static void main(String[] args) {
        //14. Написать метод, принимающий на вход два аргумента:
        // len и initialValue, и возвращающий одномерный массив
        // типа int длиной len, каждая ячейка которого равна initialValue.

        System.out.println(Arrays.toString(createArray(10, 5)));
    }

    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}
