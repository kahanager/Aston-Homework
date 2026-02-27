package org.example;

public class Animal {
    static int animalCount = 0;
    String name;
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public Animal() {
    }

    public static int getAnimalCount() {
        return animalCount;
    }
    public void run ( int distance){
        System.out.println(Animal.this.name + " пробежал " + distance + "м");
    }
    public void swim ( int distance){
         System.out.println(Animal.this.name + " проплыл " + distance + "м");
    }
}
