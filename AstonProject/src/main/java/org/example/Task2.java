package org.example;

public class Task2 {
    public static void main (String[] args) {
        //2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
        // и инициализируйте их любыми значениями, которыми захотите. Далее метод должен
        // просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в
        // консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
        checkSumSign();
    }

    public static void checkSumSign() {
        int a = 1;
        int b = -1;
        int sum = a + b;
        if (sum >= 0) {
            System.out.print("Сумма положительная");
        } else {
            System.out.print("Сумма отрицательная");
        }
    }
}
