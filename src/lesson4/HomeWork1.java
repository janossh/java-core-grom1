package lesson4;

public class HomeWork1 {
    public static void main(String[] args) {
        System.out.println(findDivCount((short)5, (short)15, 3));
    }

    public static int findDivCount(short a, short b, int n) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
        return count;
    }
}
