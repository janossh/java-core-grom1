package lesson29;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        System.out.println(useHashSet());
    }

    public static HashSet<Order> useHashSet(){
        Order order1 = new Order(12, 12, "USD", "AAA", "456");
        Order order2 = new Order(123, 12, "USD", "AAA", "456");
        Order order3 = new Order(124, 12, "USD", "AAA", "456");
        Order order4 = new Order(125, 12, "USD", "AAA", "456");
        Order order5 = new Order(126, 12, "USD", "AAA", "456");
        Order order6 = new Order(127, 12, "USD", "AAA", "456");
        Order order7 = new Order(1278, 12, "USD", "AAA", "456");
        Order order8 = new Order(127, 12, "USD", "AAA", "456");

        HashSet<Order> orders = new HashSet<>();

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);

        orders.remove(order6);

        Order[] arrayOrder = orders.toArray(new Order[orders.size()]);
        System.out.println(arrayOrder.toString());

        HashSet<Order> orders1 = new HashSet<>();

        orders1.add(order1);
        orders1.add(order2);
        orders1.add(order3);
        orders1.add(order4);
        orders1.add(order5);

        orders.retainAll(orders1);

        return orders;
    }
}
