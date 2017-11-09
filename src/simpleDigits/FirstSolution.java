package simpleDigits;

import java.util.ArrayList;
import java.util.List;

public class FirstSolution {

    public static void main(String[] args) {
        System.out.println(findingPrimeNumbers(2, 100));
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

        int divisor = 0;

        ArrayList<Long> primeNumbers = new ArrayList<>();

        for (long i = start; i <= end; i++) {
            for (long j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisor++;
                }
                if (divisor > 2) {
                    divisor = 0;
                }
            }
            if (divisor == 2) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
//        ArrayList<Long> primePalindromeNumbers = new ArrayList<>();
//        for (long i = 0; i < primeNumbers.size(); i++) {
//            for (long j = i; j < primeNumbers.size(); j++) {
//                long multiplicationResult = primeNumbers.get((int) i) * primeNumbers.get((int) j);
//                if (checkPalindrome(multiplicationResult)){
//                    primePalindromeNumbers.add(multiplicationResult);
//                }
//            }
//        }
//
//
//        return primePalindromeNumbers;
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
