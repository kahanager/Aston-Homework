package org.example;

public interface FigureParameters {
    String getFillColor();
    String getBorderColor();
    double area();
    String getName();
    double[] numSides();

    default double getPerimeter() {
        double[] sides = numSides();
        if (sides.length == 1) {
            return 2 * 3.14 * sides[0];
        } else {
            double perimeter = 0;
            for (double side : sides) {
                perimeter += side;
            }
            return perimeter;
        }
    }
    default void printCharacteristics () {
        System.out.println("Фигура: " + getName());
       System.out.println("Периметр: " + getPerimeter());
       System.out.println("Площадь: " + area());
       System.out.println("Цвет заливки: " + getFillColor());
       System.out.println("Цвет границы: " + getBorderColor());
    }
}


