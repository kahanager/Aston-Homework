package org.example;

public class ArrayExceptions {
    public static int checkArray(String[][] array) {
        if (array.length != 4){
            throw new MyArraySizeException("Массив должен содержать 4 строки");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Строка должна содержать 4 элемента");
            }
        }
        System.out.println("Размер массива корректен (4x4)");

        // Проход по всем ячейкам
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String cell = array[i][j];
                if (cell == null || !cell.matches("-?\\d+")) {
                    throw new MyArrayDataException(
                            "Нечисловое значение в ячейке [" + i + "][" + j + "]: " + cell,
                            i, j);
                }
                sum += Integer.parseInt(cell);
            }
        }
        return sum;
    }


}
