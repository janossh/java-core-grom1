package lesson5;

import java.util.Arrays;

public class HomeWork1 {
    public static void main(String[] args) {

        int[] array = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};

        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));

    }

    public static int[] sortAscending(int[] array) {

        Arrays.sort(array);
        return array;
    }

    public static int[] sortDescending(int[] array) {
        Arrays.sort(array);
        int[] newArray = new int[array.length];
        for (int ii = 0; ii < array.length; ii++) {
            newArray[array.length-ii-1] = array[ii];
        }
        return newArray;
    }
}
