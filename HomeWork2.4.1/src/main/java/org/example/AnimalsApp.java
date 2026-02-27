package org.example;

public class AnimalsApp {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Бобс");
        Cat cat1 = new Cat("Барсик", 20);
        Cat cat2 = new Cat("Феликс", 12);
        Dog dog1 = new Dog("Бобик");
        animal1.run(10);
        cat1.run(200);
        dog1.run(555);
        dog1.swim(111);

        Bowl bowl = new Bowl(30);  // миска с 30 еды
        Cat[] cats = {
                new Cat("Барсик", 15),
                new Cat("Мурка", 20),
                new Cat("Рыжик", 10),
                new Cat("Снежок", 25),
                new Cat("Васька", 5)
        };
        System.out.println("В миске " + bowl.food + " еды.");
        System.out.println("Коты:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " (аппетит: " + cat.getAppetite() + ")");
        }
        System.out.println("Кормим котов:");
        for (Cat cat : cats) {
            cat.eat(bowl);
        }
        //сытость
        System.out.println("Результаты:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }

        // Добавляем еду в миску
        System.out.println("Добавляем еду:");
        bowl.addFood(20);

        // Выводим количество созданных животных:
        int vsego = Animal.getAnimalCount() + Dog.getDogCount() + Cat.getCatCount();
        System.out.println("Всего животных: " + vsego);
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

    }
}
