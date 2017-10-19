package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int summ = 0;
        for (int i =1; i<=1000; i++){
            summ += i;
        }

        int div = summ/1234;
        int div2 = summ%1234;
        System.out.println(div<div2);
    }
}
