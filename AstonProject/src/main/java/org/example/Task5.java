package org.example;

public class Task5 {
    public static void main (String[] args) {
        //5. Напишите метод, принимающий на вход два целых числа и проверяющий,
        // что их сумма лежит в пределах от 10 до 20 (включительно), если да –
        // вернуть true, в противном случае – false.
        System.out.println(sumInRange(0,20));
    }
    public static boolean sumInRange (int a, int b) {

        return (a + b) >= 10 && (a + b) <= 20;
        }
}
