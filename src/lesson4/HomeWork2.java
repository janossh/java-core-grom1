package lesson4;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println(compareSums(1,10,2,10));
    }

    public static long sum(int from, int to) {
        long sum = 0;
        for (long i = from; i <= to; i++)
            sum += i;

        return sum;
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        long sum1 = sum(a, b);
        long sum2 = sum(c, d);

        return sum1 > sum2 ? true : false;
    }
}
