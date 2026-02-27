package org.example;

public class Dog extends Animal {
    final int maxRunDistance = 500;
    final int maxSwimDistance = 10;
    static int dogCount = 0;
    public Dog(String name) {
        this.name = name;
        dogCount++;
    }
    public static int getDogCount() {
        return dogCount;
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
    public void swim ( int distance) {
        if (distance <= maxSwimDistance) {
        System.out.println(name + " проплыл " + distance + "м");
        } else {
            System.out.println(name + " не может проплыть " + distance +
                    " м (максимум " + maxSwimDistance + " м).");
        }
    }
}
