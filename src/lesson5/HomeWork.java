package lesson5;

public class HomeWork {
    public static void main(String[] args) {
        int[] array = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(array));
    }

   public static int uniqueCount(int[] array) {
        int count = 0;
        int index = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            boolean unique = true;
            for (int ii = 0; ii <= array.length - 1; ii++) {
                if (array[ii] == array[i] && ii != i && i > ii) {
                    unique = false;
                }
            }
            if (unique)
                count++;
        }
        return count;
    }
}
