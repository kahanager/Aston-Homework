package org.example;

public class Bowl {
    int food;
    public Bowl(int initialFood) {
        this.food = initialFood;
    }
    // Метод добавления еды в миску
    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + food);
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды");
        }
    }
    // Попытка взять еду из миски
    public boolean takeFood(int amount) {
        if (amount > 0 && amount <= food) {
            food -= amount;
            return true;
        }
        return false;
    }
}
