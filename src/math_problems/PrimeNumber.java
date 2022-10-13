package math_problems;

public class PrimeNumber {

    /** INSTRUCTIONS
     * Write a method to print a list of all prime numbers from 2 to 1,000,000.
     *  Print out the prime numbers in the given range.
     *
     * BONUS: Figure out how to improve algorithmic efficiency
     */


    public static void main(String[] args) {
        for (int i = 2; i <= 1000000; i++) {
            if (isPrime(i)) {
                System.out.print(i);
            } }

    }
    public static boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true; }
        if (num % 2 == 0 || num % 3 == 0) {
            return false; }
        for (int i = 3; i < Math.sqrt(num); i += 2) {
            if (num % i == 0 || num % Math.sqrt(num) == 0) {
                return false; } }
        return true; }



}
