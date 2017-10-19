package lesson3;

public class TernarOperator {
    public static void main(String[] args) {
        int a;
        byte b = 100;
        a = b > 200 ? b : b - 500;
        System.out.println(a);
    }
}
