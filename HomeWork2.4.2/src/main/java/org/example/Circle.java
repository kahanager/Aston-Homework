package org.example;

public class Circle implements FigureParameters {
    double radius;
    String fillColor;
    String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double area() {
        return 3.14 * radius * radius;
    }

    @Override
    public double[] numSides() {
        return new double[]{radius};
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
    @Override
    public String getName() {
        return "круг";
    }
}
