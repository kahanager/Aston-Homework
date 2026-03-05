package org.example;

public class Task3 {
    public static void main (String[] args) {
        //3. Создайте метод printColor() в теле которого задайте int переменную value
        // и инициализируйте ее любым значением. Если value меньше 0 (0 включительно),
        // то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах о
        // т 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100
        // (100 исключительно) - “Зеленый”;

        printColor();
    }
    public static void printColor() {
        int value = 311;
        if (value <= 0) {
            System.out.print("Красный");
        } else if (value > 0 && value <=100) {
            System.out.print("Желтый");
        } else {
            System.out.print("Зеленый");
        }
    }
}

