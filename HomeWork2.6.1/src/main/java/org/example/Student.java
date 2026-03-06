package org.example;


import java.util.Collection;
import java.util.Set;

public class Student {
    public String name;
    public String group;
    public int course;
    public double avaragePoint;

    public Student(String name, String group, int course, double avaragePoint) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.avaragePoint = avaragePoint;
    }
    // Удаление студентов со средним баллом < 3
    public static void removeStudents(Collection<Student> students) {
        students.removeIf(s -> s.avaragePoint < 3.0);
    }
    // Перевод на следующий курс при среднем балле >= 3
    public static void promoteStudents(Collection<Student> students) {
        for (Student s : students) {
            if (s.avaragePoint >= 3.0) {
                s.course++;
            }
        }
    }
    // Печать студентов заданного курса
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        for (Student s : students) {
            if (s.course == course) {
                System.out.println("  - " + s.name);
            }
        }
    }
    // метод для вывода всех студентов
    public static void printAllStudents(Collection<Student> students) {
        System.out.println("Все студенты:");
        for (Student s : students) {
            System.out.printf(s.name, s.group, s.course, s.avaragePoint);
        }
    }


}
