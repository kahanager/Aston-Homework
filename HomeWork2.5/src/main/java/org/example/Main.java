package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            String newRequest = array[0][5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка доступа к строке: " + e.getMessage());
        }

        try {
            System.out.println("Сумма: " + ArrayExceptions.checkArray(array));
        } catch (MyArraySizeException e) {
            System.err.println("Поймано исключение: " + e.getMessage());
            e.printStackTrace();
        }
    }
}