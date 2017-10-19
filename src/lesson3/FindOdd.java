package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int d;
        int sum = 0;
        for (int i = 0; i<=1000; i++){
            d = i%2;
            if (d != 0){
                System.out.println("Found");
                sum += i;

            }
        }
        if (sum*5> 5000)
            System.out.println("Bigger");
        else
            System.out.println("Smaller or equal");
    }
}
