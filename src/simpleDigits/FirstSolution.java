package simpleDigits;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FirstSolution {

    public static void main(String[] args) {
        Date start = new Date();
        System.out.println(findingTheLargest(findingPrimeNumbers(100000, 999999)));
        Date finish = new Date();
        Long sekonds = (finish.getTime() - start.getTime());
        System.out.println(sekonds);
    }


    public static long findingTheLargest(List<Long> array) {

        long max = array.get(0);

        for (Long number : array) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static ArrayList<Long> findingPrimeNumbers(long start, long end) {

        //int divisor = 0;

        ArrayList<Long> primeNumbers = new ArrayList<>();

        for (long i = 2; i <= end; i++) {
            boolean divisor = true;
            for (long j = 2; j <= i; j++) {
                if (i % j == 0 && i!=j) {
                    divisor = false;
                    break;
                }
//                if (divisor > 2) {
//                    divisor = 0;
//                }
            }
            if (divisor) {
                primeNumbers.add(i);
            }
        }
        //return primeNumbers;
        ArrayList<Long> primePalindromeNumbers = new ArrayList<>();
        for (long i = 0; i < primeNumbers.size(); i++) {
            for (long j = i; j < primeNumbers.size(); j++) {
                long multiplicationResult = primeNumbers.get((int) i) * primeNumbers.get((int) j);
                if (checkPalindrome(multiplicationResult)){
                    primePalindromeNumbers.add(multiplicationResult);
                }
            }
        }


        return primePalindromeNumbers;
    }

    private static boolean checkPalindrome(Long number) {

        String origin = number.toString();

        int i = origin.length() - 1;
        int j = 0;

        while (i > j) {
            if (origin.charAt(i) != origin.charAt(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
