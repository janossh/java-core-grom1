package lesson18;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers1("sdf 45 56 78 98 sd sdffsdf sdf 45f45     ")));
    }

    public static int[] findNumbers(String text) {
        int[] result = null;
        String[] arrayText = text.split(" ");

        int count = 0;

        for (String el : arrayText) {
            int number = 0;
            try {
                number = Integer.parseInt(el);
                count++;
            } catch (Exception e) {

            }
        }
        if (count != 0) {
            result = new int[count];
            count = 0;
            for (String el : arrayText) {
                int number = 0;
                try {
                    number = Integer.parseInt(el);
                    result[count++] = number;

                } catch (Exception e) {
                    System.out.println(el + " not a number");
                }
            }
        }


        return result;
    }

    public static int[] findNumbers1(String text) {

        int[] result = null;

        if (text == null || text.isEmpty())
            return null;

        String[] arrayText = text.split(" ");

        int count = 0;

        for (String el : arrayText) {
            int number = 0;
            if (isNumber(el))
                count++;
        }
        if (count != 0) {
            result = new int[count];
            count =0;
            for (String el : arrayText) {
                int number = 0;
                if (isNumber(el))
                    result[count++]=Integer.parseInt(el);
                else
                    System.out.println(el + " not a number");
            }
        }


        return result;
    }

    private static boolean isNumber(String input) {

        if (input == null || input.isEmpty())
            return false;
        char[] chars = input.toCharArray();

        for (char el : chars)
            if ("0123456789".indexOf(el) == -1)
                return false;


        return true;
    }
}
