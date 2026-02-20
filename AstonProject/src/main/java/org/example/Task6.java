package org.example;

public class Task6 {
    public static void main (String[] args) {
        //6. Напишите метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль, положительное ли число передали или
        // отрицательное. Замечание: ноль считаем положительным числом.
        signNum(-1);
    }
    public static void signNum (int a) {
        if (a >= 0) {
            System.out.print("Число положительное");
        } else {
            System.out.print("Число отрицательное");
        }

    }
}
