package org.example;

public class Task7 {
    public static void main(String[] args) {
        //7. Напишите метод, которому в качестве параметра передается целое число.
        // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        //Замечание: ноль считаем положительным числом.
        System.out.println(trueFalse(-20));
    }

    public static boolean trueFalse(int a) {
        return a < 0;
    }
}