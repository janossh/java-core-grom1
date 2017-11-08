package lesson31;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static Map<Character, Long> countSymbols(String text) {

        TreeMap<Character, Long> result = new TreeMap<>();

        if (text == null) return result;

        text = text.replaceAll("[^A-Za-zА-Яа-я]", "").toLowerCase();
        System.out.println(text);

        List<Character> charText = new ArrayList<>();

        for (char ch : text.toCharArray()) {
            charText.add(ch);
        }


        HashSet<Character> characterHashSet = new HashSet<>();
        characterHashSet.addAll(charText);

        for (char chKey : characterHashSet) {
            long count = 0;
            for (char chText : charText) {
                if (chKey == chText)
                    count++;
            }
            result.put(chKey, count);
        }
        return result;
    }


    public static Map<String, Long> words(String text) {

        TreeMap<String, Long> result = new TreeMap<>();

        if (text == null) return result;

        List<String> wordList = new ArrayList<>();

        for (String st : text.split(" ")) {
            if (st.length() > 2 && isWord(st))
                wordList.add(st);
        }

        HashSet<String> wordHashSet = new HashSet<>();
        wordHashSet.addAll(wordList);

        for (String wordKey : wordHashSet) {
            long count = 0;
            for (String word : wordList) {
                if (wordKey.equals(word))
                    count++;
            }
            result.put(wordKey, count);
        }
        return result;
    }

    public static boolean isWord(String input) {
        Pattern p = Pattern.compile("[a-zA-ZА-Яа-я]*");
        Matcher m = p.matcher(input);
        return m.matches();
    }

}
