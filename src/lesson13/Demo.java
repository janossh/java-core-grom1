package lesson13;

import lesson10.Customer;
import lesson10.ElectronicsOrder;
import lesson10.FurnitureOrder;
import lesson11.homework.*;
import lesson4.*;
import lesson6.Car;
import lesson6.Order;
import lesson7.DemoHomeWork;
import lesson8.Adder;
import lesson9.homeWork.User;
import lesson9.homeWork.UserRepository;

import java.util.Arrays;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        System.out.println("lesson4");
        System.out.println("lesson4.HomeWork");

        System.out.println(HomeWork.concat("1", "2.3", "3"));
        System.out.println(HomeWork.concat(null, "df", "df"));
        System.out.println(HomeWork.concat(null, "df", null));

        System.out.println();
        System.out.println("lesson4.HomeWork1");

        System.out.println(HomeWork1.findDivCount(Short.MAX_VALUE, Short.MIN_VALUE, 0));
        System.out.println(HomeWork1.findDivCount((short) 0, (short) 0, 5));
        System.out.println(HomeWork1.findDivCount((short) 50, (short) 7, Integer.MAX_VALUE));

        System.out.println();
        System.out.println("lesson4.HomeWork2");

        System.out.println(HomeWork2.sum(0, Integer.MAX_VALUE));
        System.out.println(HomeWork2.sum(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(HomeWork2.sum(Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println(HomeWork2.compareSums(0, Integer.MAX_VALUE, 45, Integer.MAX_VALUE));
        System.out.println(HomeWork2.compareSums(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, Integer.MAX_VALUE));
        System.out.println(HomeWork2.compareSums(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));

        System.out.println();
        System.out.println("lesson4.MethodExample");

        System.out.println(MethodExample.increaser(0, Integer.MAX_VALUE));
        System.out.println(MethodExample.increaser(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(MethodExample.increaser(Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println(MethodExample.min(0, Integer.MAX_VALUE));
        System.out.println(MethodExample.min(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(MethodExample.min(Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println();
        System.out.println("lesson4.PracticeExample");

        System.out.println(PracticeExample.min(0, Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(PracticeExample.min(Integer.MAX_VALUE, Integer.MIN_VALUE, 10));
        System.out.println(PracticeExample.min(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE));

        System.out.println(PracticeExample.average(50));
        System.out.println(PracticeExample.average(0));
        System.out.println(PracticeExample.average(-15));

        System.out.println(PracticeExample.average(50, 65));
        System.out.println(PracticeExample.average(0, 200));
        System.out.println(PracticeExample.average(-15, 400));

        System.out.println(PracticeExample.count(50, 65, 45));
        System.out.println(PracticeExample.count(0, 200, 400));
        System.out.println(PracticeExample.count(-15, 400, Integer.MIN_VALUE));

        System.out.println("lesson5");
        System.out.println("lesson5.HomeWork");

        System.out.println(lesson5.HomeWork.uniqueCount(new int[]{11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11}));
        System.out.println(lesson5.HomeWork.uniqueCount(new int[]{11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11, Integer.MIN_VALUE}));
        System.out.println(lesson5.HomeWork.uniqueCount(new int[]{11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11, 465464, 7987, Integer.MIN_VALUE}));

        System.out.println();
        System.out.println("lesson5.HomeWork1");

        System.out.println(Arrays.toString(lesson5.HomeWork1.sortDescending((new int[]{11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11}))));
        System.out.println(Arrays.toString(lesson5.HomeWork1.sortDescending(new int[]{11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11, Integer.MAX_VALUE})));
        System.out.println(Arrays.toString(lesson5.HomeWork1.sortDescending(new int[]{11, 12, 10, 5, 4, 44, 0, 44, 11, 10, 11, 465464, 7987, Integer.MIN_VALUE})));

        System.out.println(Arrays.toString(lesson5.HomeWork1.sortAscending((new int[]{11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11}))));
        System.out.println(Arrays.toString(lesson5.HomeWork1.sortAscending(new int[]{11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11, Integer.MAX_VALUE})));
        System.out.println(Arrays.toString(lesson5.HomeWork1.sortAscending(new int[]{11, 12, 10, 5, 4, 44, 0, 44, 11, 10, 11, 465464, 7987, Integer.MIN_VALUE})));

        System.out.println();
        System.out.println("lesson5.HomeWork2");

        System.out.println(lesson5.HomeWork2.withdraw(new String[]{"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"}, new int[]{100, 500, 8432, -100, 12000, -54, 0}, "Andrey", Integer.MAX_VALUE));
        System.out.println(lesson5.HomeWork2.withdraw(new String[]{"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"}, new int[]{100, 500, 8432, -100, 12000, -54, 0}, "Phil", Integer.MAX_VALUE));
        System.out.println(lesson5.HomeWork2.withdraw(new String[]{"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"}, new int[]{100, 500, 8432, -100, 12000, -54, 0}, "John", Integer.MIN_VALUE));

        System.out.println(lesson5.HomeWork2.findClientIndexByName(new String[]{"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"}, "Andrey"));
        System.out.println(lesson5.HomeWork2.findClientIndexByName(new String[]{"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"}, "Phil"));
        System.out.println(lesson5.HomeWork2.findClientIndexByName(new String[]{"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"}, "Jack"));

        System.out.println();
        System.out.println("lesson6.Order");

        Order order = new Order(5000, new Date(), false, null, "Kiev", "Ukraine", "Sold");
        order.confirmOrder();
        System.out.println(order.toString());

        order = new Order(Integer.MAX_VALUE, null, false, null, "Kiev", "Ukraine", "Sold");
        order.confirmOrder();
        System.out.println(order.toString());

        order = new Order(Integer.MAX_VALUE, new Date(), false, new Date(), "Kiev", "Ukraine", "Sold");
        order.confirmOrder();
        System.out.println(order.toString());

        System.out.println();
        System.out.println("lesson7.DemoHomeWork");

        DemoHomeWork demoHomeWork = new DemoHomeWork();
        System.out.println(demoHomeWork.createOrder().toString());
        System.out.println(demoHomeWork.createOrderAndCallMethods().toString());

        System.out.println();
        System.out.println("lesson8.Adder");

        System.out.println(Adder.add(Integer.MAX_VALUE, 1));
        System.out.println(Adder.add(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(Adder.add(Integer.MAX_VALUE, Integer.MAX_VALUE));

        System.out.println("lesson8.Arithmetic");
        System.out.println(Adder.check(new int[]{11, 12, 10, 5, 4, 44, 94, 44, 11, 10, 11}));
        System.out.println(Adder.check(new int[]{Integer.MIN_VALUE, 0, 0, 0, 0, 0, 11, Integer.MAX_VALUE}));
        System.out.println(Adder.check(new int[]{Integer.MAX_VALUE, 12, 10, 5, 4, 44, 94, 44, Integer.MAX_VALUE, 10, 11}));

        System.out.println();
        System.out.println("lesson9.UserRepository");

        User user0 = new User(100, "Ivan0", "0");
        User user1 = new User(101, "Ivan1", "1");
        User user2 = new User(102, "Ivan2", "2");
        User user3 = new User(103, "Ivan3", "3");

        User[] users = new User[]{user0, null, user2};

        UserRepository userRepository = new UserRepository(new User[3]);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        UserRepository userRepository1 = new UserRepository(users);
        System.out.println(Arrays.deepToString(userRepository1.getUsers()));

        userRepository.save(user2);
        userRepository.save(user1);
        userRepository.save(null);
        userRepository.save(user0);
        userRepository.save(user3);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println(Arrays.toString(userRepository1.getUserNames()));//find mistake

        System.out.println(Arrays.toString(userRepository1.getUserIds()));//same mistake

        System.out.println(userRepository1.getUserNameById(100));
        System.out.println(userRepository1.getUserNameById(101));
        System.out.println(userRepository1.getUserNameById(102));

        System.out.println(userRepository1.getUserByName("Ivan0"));
        System.out.println(userRepository1.getUserByName("Ivan1"));

        System.out.println(userRepository1.getUserById(100));
        System.out.println(userRepository1.getUserById(101));

        System.out.println(userRepository1.getUserBySessionId("0"));
        System.out.println(userRepository1.getUserBySessionId("1"));

        System.out.println(userRepository1.findById(100));
        System.out.println(userRepository1.findById(101));

        user0.setSessionId("45");
        userRepository1.update(user0);
        userRepository1.update(user3);
        System.out.println(Arrays.deepToString(userRepository1.getUsers()));

        userRepository1.delete(100);
        userRepository1.delete(101);
        System.out.println(Arrays.deepToString(userRepository1.getUsers()));


        System.out.println();
        System.out.println("lesson10");

        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Goods1", new Date(), "Днепр", 600, new Customer("Tamara", "Днепр", "Женский"), 12);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Goods2", new Date(), "Одесса", 1600, new Customer("Вова", "Одесса", "Мужской"), 12);

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Goods1", new Date(), "Днепр", 600, new Customer("Tamara", "Днепр", "Женский"), "12");
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Goods2", new Date(), "Львов", 400, new Customer("Вова", "Львов", "Мужской"), "12");

        electronicsOrder1.validateOrder();
        System.out.println(electronicsOrder1);
        electronicsOrder1.calculatePrice();
        System.out.println(electronicsOrder1);
        electronicsOrder1.confirmShipping();
        System.out.println(electronicsOrder1);

        electronicsOrder2.validateOrder();
        System.out.println(electronicsOrder2);
        electronicsOrder2.calculatePrice();
        System.out.println(electronicsOrder2);
        electronicsOrder2.confirmShipping();
        System.out.println(electronicsOrder2);

        furnitureOrder1.validateOrder();
        System.out.println(furnitureOrder1);
        furnitureOrder1.calculatePrice();
        System.out.println(furnitureOrder1);
        furnitureOrder1.confirmShipping();
        System.out.println(furnitureOrder1);

        furnitureOrder2.validateOrder();
        System.out.println(furnitureOrder1);
        furnitureOrder2.calculatePrice();
        System.out.println(furnitureOrder1);
        furnitureOrder2.confirmShipping();
        System.out.println(furnitureOrder1);

        System.out.println();
        System.out.println("lesson11");

        Room room0 = new Room(100, 100, 5, null, "Paradise", "Odessa");
        Room room1 = new Room(101, 50, 4, null, "Paradise", "Odessa");
        Room room2 = new Room(102, 25, 3, null, "Paradise", "Odessa");
        Room room3 = new Room(103, 10, 2, null, "Paradise", "Odessa");

        Room room4 = new Room(104, 100, 5, null, "Paradise", "Odessa");
        Room room5 = new Room(105, 75, 4, null, "Paradise", "Odessa");
        Room room6 = new Room(106, 25, 3, null, "Paradise", "Odessa");
        Room room7 = new Room(107, 15, 2, null, "Paradise", "Odessa");

        Room room8 = new Room(108, 1000, 5, null, "Paradise", "Odessa");
        Room room9 = new Room(109, 705, 4, null, "Paradise", "Odessa");
        Room room10 = new Room(110, 205, 3, null, "Paradise", "Odessa");
        Room room11 = new Room(111, 150, 2, null, "Paradise", "Odessa");

        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(new Room[]{null, null, null, null});
        BookingComAPI bookingComAPI = new BookingComAPI(new Room[]{null, null, null, null});
        GoogleAPI googleAPI = new GoogleAPI(new Room[]{null, null, null, null});
        Controller controller = new Controller(new API[]{tripAdvisorAPI, bookingComAPI, googleAPI});

        System.out.println(Arrays.deepToString(controller.requestRooms(100, 4, "Odessa", "Paradise")));

        controller = new Controller(new API[]{null, null, null});

        System.out.println(Arrays.deepToString(controller.requestRooms(100, 4, "Odessa", "Paradise")));

        tripAdvisorAPI = new TripAdvisorAPI(new Room[]{room0, room1, room2, room3});
        bookingComAPI = new BookingComAPI(new Room[]{room4, room5, room6, room7});
        googleAPI = new GoogleAPI(new Room[]{room8, room9, room10, room11});
        controller = new Controller(new API[]{tripAdvisorAPI, bookingComAPI, googleAPI});

        System.out.println(Arrays.deepToString(controller.requestRooms(100, 4, "Odessa", "Paradise")));
        System.out.println();
        System.out.println();
        System.out.println(Arrays.deepToString(controller.check(tripAdvisorAPI, bookingComAPI)));
        System.out.println(Arrays.deepToString(controller.check(null, bookingComAPI)));
        System.out.println(Arrays.deepToString(controller.check(tripAdvisorAPI, null)));
        System.out.println(Arrays.deepToString(controller.check(null, null)));

    }

}
