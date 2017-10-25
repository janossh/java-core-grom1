package lesson27.order;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(useList().toArray()));
    }

    public static LinkedList<Order> useList() {
        LinkedList<Order> list = new LinkedList<>();
        Order order1 = new Order(11,111,"EUR", "Name", "DkfjhdfhHH454");
        Order order2 = new Order(12,111,"EUR", "Name", "DkfjhdfhHH454");
        Order order3 = new Order(13,111,"EUR", "Name", "DkfjhdfhHH454");
        Order order4 = new Order(14,111,"EUR", "Name", "DkfjhdfhHH454");
        Order order5 = new Order(15,111,"EUR", "Name", "DkfjhdfhHH454");
        Order order6 = new Order(16,111,"EUR", "Name", "DkfjhdfhHH454");
        Order order7 = new Order(17,111,"EUR", "Name", "DkfjhdfhHH454");
        Order order8 = new Order(18,111,"EUR", "Name", "DkfjhdfhHH454");
        Order order9 = new Order(19,111,"EUR", "Name", "DkfjhdfhHH454");

        list.add(order1);
        list.add(0,order2);
        list.add(order3);
        list.add(order4);
        list.add(order5);
        list.add(order1);

        LinkedList<Order> list1 = new LinkedList<>();
        list.add(order6);
        list.add(order7);

        list.addAll(list1);

        list.remove(0);
        list.remove(order1);

        list.subList(list.size()-3, list.size()-1);

        list.set(list.size()-1, order1);

        System.out.println(list.contains(order8));

        list1.toArray();

        list1.clear();

        while (list.size()>5){
            list.remove(list.size()-1);
        }



        return list;
    }
}
