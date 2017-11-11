package lesson32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void readNumbers() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int n = 3;

        while (!countNumbers(bufferedReader.readLine()) && n != 1) {
            System.out.println("Your numbers are wrong. You have " + (--n) + " attempts to try again");
        }

        if (n == 1)
            System.out.println("Your numbers are wrong. Number of attempts exceeded");

    }

    private static boolean countNumbers(String str) {
        boolean flag = true;

        String[] arrayList =  str.split(" ");

        if (!isDigits(str) && arrayList.length != 10)
            return false;

        int count = 0;
        for (String st : arrayList) {
            if (Integer.valueOf(st) > 100)
                return false;
            count += Integer.valueOf(st);
        }
        System.out.println("Сумма 10ти чисел = " + count);
        return flag;
    }

    public static boolean isDigits(String input) {
        Pattern p = Pattern.compile("\\d+\\s?");
        Matcher m = p.matcher(input);
        return m.matches();
    }
}
