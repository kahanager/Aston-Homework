package org.example;

public class Park {
    private String name;
    public Park(String name) {
        this.name = name;
    }
    public class Attraction {
        private String name;
        private String time;
        private int cost;

        public Attraction(String name, String time, int cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }

        public void printAttractionInfo() {
            System.out.println("Парк: " + Park.this.name);
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + time);
            System.out.println("Стоимость: " + cost);

        }
    }
    public static void main(String[] args) {
        Park park1 = new Park("парк1");
        Park.Attraction attraction1 = park1.new Attraction("Аттракцион1", "10 часов", 1000);
        attraction1.printAttractionInfo();
    }
}