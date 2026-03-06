package org.example;


public class Main {
    public static void main(String[] args) {
        PhoneDirectory phoneBook = new PhoneDirectory();

        // Добавляем записи
        phoneBook.add("Иванов", "+7-111-111-11-11");
        phoneBook.add("Петров", "+7-222-222-22-22");
        phoneBook.add("Иванов", "+7-333-333-33-33");
        phoneBook.add("Сидоров", "+7-444-444-44-44");

        // Ищем по фамилии
        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));

    }
}