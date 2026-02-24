package org.example;

public class Task4 {
    public static void main (String[] args) {
        //4. Создайте метод compareNumbers(), в теле которого объявите две int
        // переменные a и b, и инициализируйте их любыми значениями, которыми захотите.
        // Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
        // в противном случае “a < b”;
        compareNumbers();
    }
    public static void compareNumbers () {
        int a = 300;
        int b = 255;
        if (a >= b) {
            System.out.print("a >= b");
        } else {
            System.out.print("a < b");
        }
        }
    }
