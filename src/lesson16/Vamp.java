package lesson16;

public class Vamp {
    public static void main(String[] args) {
        String a = "test str here was here two times or not no test e";
        System.out.println(a);
        System.out.println(replace(a, "e", "ee"));
    }



    public static String replace(String input, String target, String replacement) {
        String result = input;

        if (input!=null&&input!=""&&target!=null&&target!=""&&replacement!=null) {

            while (result.contains(target)) {
                int index = result.indexOf(target);
                String a = result.substring(0, index);
                a += "PooopPPPPPPPP";
                String b = a + result.substring(index + target.length());
                result = b;
            }

            while (result.contains("PooopPPPPPPPP")) {
                int index = result.indexOf("PooopPPPPPPPP");
                String a = result.substring(0, index);
                a += replacement;
                String b = a + result.substring(index + "PooopPPPPPPPP".length());
                result = b;
            }

        }
        return result;
    }
}