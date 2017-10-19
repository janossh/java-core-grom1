package lesson18;

public class Converter {
    public static void main(String[] args) {
        System.out.println(stringToInt("1234567"));
        System.out.println(stringToInt("546546546546546546546464565"));
        System.out.println(stringToInt(""));
        System.out.println(stringToInt(null));
        System.out.println(stringToInt("1234a567"));
    }

    public static String intToStirng(int input) {
        return String.valueOf(input);
    }

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(input + " can not be converted to int");
            return 0;
        }
    }
}
