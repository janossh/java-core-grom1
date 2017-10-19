package lesson16.homework;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(countWords("123 13 ds ddd f    123 123 123 123 123 123 123"));
        //System.out.println(maxWord("456454465465 f ff f46546546465465464665465465464654"));
//        System.out.println(minWord("sdfdsfdsfsdfdsfdsfdsfsdfdsfsdfsdfsdf"));
        //System.out.println(mostCountedWord("                                      a"));
        System.out.println(validate("http://sd//fsdf.org"));
    }

    public static int countWords(String input) {
        String[] words = input.split(" ");
        int count = 0;
        Pattern p = Pattern.compile("[a-zA-Z]*");

        for (String word : words)
            if (!word.isEmpty()) {
                Matcher m = p.matcher(word);
                if (m.matches())
                    count++;
            }
        return count;
    }

    public static String maxWord(String input) {
        if (input == null || input.isEmpty())
            return input;

        String[] words = input.split(" ");

        String max = "";

        for (String word : words)
            if (!word.isEmpty())
                if (isWord(word)) {
                    max = word;
                    break;
                }

        for (String word : words)
            if (!word.isEmpty())
                if (isWord(word)) {
                    if (word.trim().length() > max.trim().length())
                        max = word;
                }

        return max;
    }


    public static String minWord(String input) {
        if (input == null || input.isEmpty())
            return input;

        String[] words = input.split(" ");

        String min = "";

        for (String word : words)
            if (!word.isEmpty())
                if (isWord(word)) {
                    min = word;
                    break;
                }

        for (String word : words)
            if (!word.isEmpty())
                if (isWord(word)) {
                    if (word.length() < min.length())
                        min = word;
                }

        return min;
    }


    public static boolean isWord(String input) {
        Pattern p = Pattern.compile("[a-zA-Z]*");
        Matcher m = p.matcher(input);
        return m.matches();
    }

    public static String mostCountedWord(String input) {
        if (input == null)
            return null;
        String result = null;

        String[] arrayInput = input.split(" ");

        String[] onlyWords;

        int countWord = 0;
        for (String word : arrayInput) {
            if (!word.isEmpty() && isWord(word))
                countWord++;
        }
        if (countWord != 0) {
            onlyWords = new String[countWord];
            countWord = 0;
            for (int i = 0; i < arrayInput.length; i++)
                if (!arrayInput[i].isEmpty() && isWord(arrayInput[i])) {
                    onlyWords[countWord] = arrayInput[i];
                    countWord++;
                }
            String[] cloneOnlyWords = onlyWords.clone();

            countWord = 0;
            for (int i = 0; i < onlyWords.length; i++)
                for (int j = i + 1; j < onlyWords.length; j++)
                    if (cloneOnlyWords[j].equals(onlyWords[i]))
                        cloneOnlyWords[j] = "";

            for (String el : cloneOnlyWords)
                if (!el.isEmpty())
                    countWord++;

            if (countWord == 0)
                return onlyWords[0];

            String[] uniqeWords = new String[countWord];
            countWord = 0;
            for (String el : cloneOnlyWords)
                if (!el.isEmpty()) {
                    uniqeWords[countWord] = el;
                    countWord++;
                }
            int[] arrayOfQuntyty = new int[countWord];

            for (int i = 0; i < uniqeWords.length; i++) {
                countWord = 0;
                for (int j = 0; j < onlyWords.length; j++)
                    if (uniqeWords[i].equals(onlyWords[j])) {
                        countWord++;
                    }
                arrayOfQuntyty[i] = countWord;
            }

            int indexOfMax = findIndexOfMaxElement(arrayOfQuntyty);

            result = uniqeWords[indexOfMax];

        }

        return result;
    }

    private static int findIndexOfMaxElement(int[] inputArray) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < inputArray.length; i++)
            if (inputArray[i] > max) {
                index = i;
                max = inputArray[i];
            }

        return index;
    }


    public static boolean validate(String address) {
        if (address == null || address.isEmpty())
            return false;
        int indexOfBeginOfAddress = -2;

        indexOfBeginOfAddress = address.indexOf("http://");

        if (indexOfBeginOfAddress != 0) {
            indexOfBeginOfAddress = address.indexOf("https://");

            if (indexOfBeginOfAddress != 0)
                return false;
        }

        String domen = address.substring(address.length() - 4, address.length());
        if (!domen.equals(".com") && !domen.equals(".org") && !domen.equals(".net"))
            return false;

        String[] partsOfAdress = address.split("//");

        if (partsOfAdress.length == 1 || partsOfAdress.length > 2)
            return false;

        String[] secondPatrOfAddress = partsOfAdress[1].split("\\.");

        if (secondPatrOfAddress.length > 3) {
            return false;
        } else if (secondPatrOfAddress.length == 3) {
            if (!secondPatrOfAddress[0].equals("www"))
                return false;

            if (!secondPatrOfAddress[2].equals("com") && !secondPatrOfAddress[2].equals("org") && !secondPatrOfAddress[2].equals("net"))
                return false;

            if (secondPatrOfAddress[1].length() > 63)
                return false;

            char[] charOfAddress = secondPatrOfAddress[1].toCharArray();
            if (secondPatrOfAddress[1].length() == 0)
                return false;

            for (int i = 0; i < secondPatrOfAddress[1].length(); i++)
                if ("abcdefghijklmnopqrstuwuxyz0123456789".indexOf(charOfAddress[i]) == -1)
                    return false;

        } else if (secondPatrOfAddress.length == 2) {
            if (!secondPatrOfAddress[1].equals("com") && !secondPatrOfAddress[1].equals("org") && !secondPatrOfAddress[1].equals("net"))
                return false;

            if (secondPatrOfAddress[0].length() > 63)
                return false;

            char[] charOfAddress = secondPatrOfAddress[0].toCharArray();
            if (secondPatrOfAddress[0].length() == 0)
                return false;

            for (int i = 0; i < secondPatrOfAddress[0].length(); i++)
                if ("abcdefghijklmnopqrstuwuxyz0123456789".indexOf(charOfAddress[i]) == -1)
                    return false;
        }

        return true;


    }

}
