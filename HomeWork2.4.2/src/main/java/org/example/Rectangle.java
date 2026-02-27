package org.example;

public class Rectangle implements FigureParameters{
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double[] numSides() {
        // Возвращаем все четыре стороны
        return new double[]{width, height, width, height};
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
        return "прямоугольник";
    }
}
