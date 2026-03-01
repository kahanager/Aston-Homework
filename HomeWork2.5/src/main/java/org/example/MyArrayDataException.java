package org.example;

public class MyArrayDataException extends RuntimeException {
    private int rows;
    private int columns;

    public MyArrayDataException(String message, int rows, int columns) {
        super(message);
        this.rows = rows;
        this.columns = columns;
    }
}
