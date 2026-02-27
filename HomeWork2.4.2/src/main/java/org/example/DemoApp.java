package org.example;

public class DemoApp {
    public static void main(String[] args) {
        FigureParameters circle = new Circle(5, "красный", "чёрный");
        FigureParameters rectangle = new Rectangle(4, 6, "синий", "зелёный");
        FigureParameters triangle = new Triangle(3, 4, 5, "жёлтый", "чёрный");

        System.out.println("Характеристики фигур:");
        circle.printCharacteristics();
        rectangle.printCharacteristics();
        triangle.printCharacteristics();
    }
}
