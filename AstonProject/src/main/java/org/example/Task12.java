package org.example;

public class Task12 {
    public static void main(String[] args) {
        //12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i]*2;
            }
        }


        for (int i = 0; i < arr.length; i++) {

            System.out.println(i + " " + arr[i]);
        }


    }
}
