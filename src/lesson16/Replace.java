package lesson16;

import java.util.Arrays;

public class Replace {
    public static void main(String[] args) {
        System.out.println("test str here was here aaaaaa two times or not no test");
        System.out.println(replace("test str here was here aaaaaa two times or not no test", "aaa", "X"));
    }


    public static String replace(String input, String target, String replacement) {
        if (input==null||target==null||replacement==null||target.isEmpty())
            return input;

        char[] charInput = input.toCharArray();
        char[] charTarget = target.toCharArray();

        int countOfInput = 0;
        for (int i = 0; i < charInput.length; i++) {
            boolean greateFlag = true;
            if (charInput[i] == charTarget[0]) {

                boolean flag = true;
                int m = 1;
                for (int k = i + 1; k < i + charTarget.length; k++) {

                    if (k >= charInput.length || charInput[k] != charTarget[m]) {
                        flag = false;
                        greateFlag = false;
                    }
                    if (!flag) {
                        break;
                    }
                    m++;
                }
                if (greateFlag){
                    countOfInput++;
                    i+=charTarget.length-1;
                }

            }
        }
        if (countOfInput == 0)
            return input;

        int[] inputIndexs = new int[countOfInput];
        int mm = 0;
        for (int i = 0; i < charInput.length; i++) {
            boolean greateFlag = true;
            if (charInput[i] == charTarget[0]) {

                boolean flag = true;
                int m = 1;
                for (int k = i + 1; k < i + charTarget.length; k++) {

                    if (k >= charInput.length || charInput[k] != charTarget[m]) {
                        flag = false;
                        greateFlag = false;
                    }
                    if (!flag) {
                        break;
                    }
                    m++;
                }
                if (greateFlag) {
                    inputIndexs[mm++] = i;
                    i+=charTarget.length-1;
                }
            }
        }
        String resultString = "";
        String catString = "";
        int j = 0;
        for (int index : inputIndexs) {
            for (; j < index; j++)
                resultString += charInput[j];
            resultString += replacement;
            j = index + charTarget.length;
        }

        for (int i = inputIndexs[inputIndexs.length - 1] + charTarget.length; i < charInput.length; i++)
            resultString += charInput[i];
        return resultString;
    }
}
