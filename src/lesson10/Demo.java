package lesson10;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Goods1", new Date(),  "Днепр", 600, new Customer("Tamara", "Днепр", "Женский"), 12);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Goods2", new Date(),  "Одесса", 1600, new Customer("Вова", "Одесса", "Мужской"), 12);

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Goods1", new Date(),  "Днепр", 600, new Customer("Tamara", "Днепр", "Женский"), "12");
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Goods2", new Date(),  "Львов", 400, new Customer("Вова", "Львов", "Мужской"), "12");

        electronicsOrder1.validateOrder();
        electronicsOrder1.calculatePrice();
        electronicsOrder1.confirmShipping();

        electronicsOrder2.validateOrder();
        electronicsOrder2.calculatePrice();
        electronicsOrder2.confirmShipping();

        furnitureOrder1.validateOrder();
        furnitureOrder1.calculatePrice();
        furnitureOrder1.confirmShipping();

        furnitureOrder2.validateOrder();
        furnitureOrder2.calculatePrice();
        furnitureOrder2.confirmShipping();

    }
}
