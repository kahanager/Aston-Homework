package org.example;

public class Task8 {
    public static void main(String[] args) {
        //8. Напишите метод, которому в качестве аргументов передается
        // строка и число, метод должен отпечатать в консоль указанную строку,
        // указанное количество раз;
        printString("Меня заело", 10);
    }

    public static void printString(String b, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(b);
        }
    }
}