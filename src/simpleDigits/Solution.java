package simpleDigits;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        int max = 999999;
        int min = 100000;
        Date start = new Date();
        //System.out.println(findMaxPolindrom(simpleDigits(min, max)).lastEntry());
        System.out.println(simpleDigits(2, 100));
        Date finish = new Date();
        Long sekonds = (finish.getTime() - start.getTime());
        System.out.println(sekonds);
    }

    private static ArrayList<Integer> simpleDigits(int min, int max) {
        boolean[] reshito = new boolean[max + 1];

        int p = 2;
        do {
            reshito[p] = true;
            p++;
        } while (p <= max);

        for (int i = 2; i <= max; i++) {
            if (reshito[i] == true) {
                if ((long) (i) * (long) (i) <= (long) max)
                    for (int j = i * i; j <= max; j += i)
                        reshito[j] = false;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (reshito[i] == true) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isPalindrome(String text) {

        StringBuilder strBuilder = new StringBuilder(text);
        strBuilder.reverse(); //переворачиваем строку
        String invertedText = strBuilder.toString();//присваиваем перевернутую строку

        return text.equalsIgnoreCase(invertedText);//возвращаем сравнение двух строк вне зависимости от регистра
    }

    private static TreeMap<Long, Long> findMaxPolindrom(ArrayList<Integer> simpleDigits) {

        TreeMap<Long, Long> polindromMap = new TreeMap<>();

        for (int i = 0; i < simpleDigits.size(); i++) {
            long result = 0;
            for (int j = i; j < simpleDigits.size(); j++) {
                result = (long) simpleDigits.get(i) * (long) simpleDigits.get(j);
                if (isPalindrome(String.valueOf(result))) {
                    polindromMap.put(result, (long) simpleDigits.get(i));
                    //System.out.println(result);
                }
            }

        }
        return polindromMap;
    }
}
