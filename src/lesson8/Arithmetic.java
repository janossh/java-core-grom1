package lesson8;

public class Arithmetic {


    public static boolean check(int[] array) {
        int maxEl = array[0];
        int minEl = array[0];
        for (int el : array) {
            if (maxEl < el)
                maxEl = el;
            if (minEl > el)
                minEl = el;
        }
        return (maxEl + minEl) > 100;
    }
}
