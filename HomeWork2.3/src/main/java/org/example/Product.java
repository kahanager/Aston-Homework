package org.example;

public class Product {
    private String name;
    private String date;
    private String manufacturer;
    private String country;
    private int price;
    private boolean status;

    public Product(String name, String date, String manufacturer,
                   String country, int price, boolean status) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.status = status;
    }

    public void printInfo() {
        System.out.println("Товар: " + name);
        System.out.println("Дата производства: " + date);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Статус: " + status);
    }

    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Стиральная машина LG F2J3NS0W", "12.05.2023",
                "LG Electronics", "Корея", 35000, true);
        productsArray[2] = new Product("Кофеварка DeLonghi ECAM", "20.01.2024",
                "DeLonghi", "Италия", 45000, false);
        productsArray[3] = new Product("Велосипед Stels Navigator", "10.03.2024",
                "Велосипедный завод", "Россия", 15000, true);
        productsArray[4] = new Product("Настольная лампа Xiaomi Mi Desk Lamp", "01.11.2023",
                "Xiaomi", "Китай", 2000, false);
        productsArray[0].printInfo();
        productsArray[1].printInfo();
        productsArray[2].printInfo();
        productsArray[3].printInfo();
        productsArray[4].printInfo();
    }
}