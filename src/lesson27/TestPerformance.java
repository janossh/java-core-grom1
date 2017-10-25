package lesson27;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class TestPerformance {
    public static void main(String[] args) {
        testAddMetod();
        testRemoveMetod();
        testGetMetod();
    }

    private static void testGetMetod() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            arrayList.add(i, String.valueOf(i));
        }

        Date start = new Date();

        for (int i = 0; i < 100_000; i++) {
            arrayList.get(50000);
        }

        Date finish = new Date();

        System.out.println("get - array list: " + (finish.getTime() - start.getTime()));

        //linkedList
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100_000; i++) {
            linkedList.add(i, String.valueOf(i));
        }

        start = new Date();

        for (int i = 0; i < 100_000; i++) {
            linkedList.get(50000);
        }

        finish = new Date();

        System.out.println("get - linked list: " + (finish.getTime() - start.getTime()));

    }


    private static void testAddMetod() {
        ArrayList<String> arrayList = new ArrayList<>();

        Date start = new Date();

        for (int i = 0; i < 100_000; i++) {
            arrayList.add(i, String.valueOf(i));
        }

        Date finish = new Date();

        System.out.println("add - array list: " + (finish.getTime() - start.getTime()));

        //linkedList
        LinkedList<String> linkedList = new LinkedList<>();

        start = new Date();

        for (int i = 0; i < 100_000; i++) {
            linkedList.add(i, String.valueOf(i));
        }

        finish = new Date();

        System.out.println("add - linked list: " + (finish.getTime() - start.getTime()));

    }

    private static void testRemoveMetod() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            arrayList.add(i, String.valueOf(i));
        }

        Date start = new Date();

        for (int i = 0; i < 90_000; i++) {
            arrayList.remove(10000);
        }

        Date finish = new Date();

        System.out.println("remove - array list: " + (finish.getTime() - start.getTime()));

        //linkedList
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100_000; i++) {
            linkedList.add(i, String.valueOf(i));
        }

        start = new Date();

        for (int i = 0; i < 90_000; i++) {
            linkedList.remove(10000);
        }

        finish = new Date();

        System.out.println("remove - linked list: " + (finish.getTime() - start.getTime()));

    }
}
