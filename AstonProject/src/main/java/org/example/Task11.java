package org.example;

public class Task11 {
    public static void main(String[] args) {
        //11. Задать пустой целочисленный массив длиной 100.
        // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
        int [] arr = new int [100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
            System.out.println(i + " " + arr[i]);
        }


    }
}
