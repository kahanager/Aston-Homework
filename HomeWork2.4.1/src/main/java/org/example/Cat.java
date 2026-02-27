package org.example;

public class Cat extends Animal {
    final int maxRunDistance = 200;
    static int catCount = 0;
    int appetite;
    boolean isFull;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
        catCount++;
    }
    public static int getCatCount() {
        return catCount;
    }
    public int getAppetite() {
        return appetite;
    }
    public boolean isFull() {
        return isFull;
    }
    @Override
    public void run ( int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + "м");
        } else {
            System.out.println(name + " не может пробежать " + distance +
                    " м (максимум " + maxRunDistance + " м).");
        }
    }
    @Override
    public void swim ( int distance){
        System.out.println(name + " не умеет плавать.");
    }
    // Метод для попытки поесть из миски
    public void eat(Bowl bowl) {
        if (bowl.takeFood(appetite)) {
            isFull = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " не поел: недостаточно еды в миске.");
        }
    }
}
