package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Иванов","Группа А", 1, 4.2));
        studentList.add(new Student("Петров", "Группа Б", 2, 2.5));
        studentList.add(new Student("Сидоров", "Группа В", 3, 4.8));
        studentList.add(new Student("Алексеев", "Группа А", 1, 3.0));
        studentList.add(new Student("Попов", "Группа Б", 2, 2.8));
        studentList.add(new Student("Васильев", "Группа В", 3, 1.5));


        System.out.println("=== Исходные данные ===");
        Student.printAllStudents(studentList);


        Student.removeStudents(studentList);
        System.out.println("=== После удаления неуспевающих (ср.балл < 3) ===");
        Student.printAllStudents(studentList);

        Student.promoteStudents(studentList);

        Set<Student> studentSet = new HashSet<>(studentList);
        System.out.println("\n=== Выборочный вывод по курсам ===");
        Student.printStudents(studentSet, 1);
        Student.printStudents(studentSet, 2);
        Student.printStudents(studentSet, 3);
        Student.printStudents(studentSet, 4);
    }
}