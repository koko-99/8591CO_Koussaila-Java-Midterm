package math_problems;

import java.util.Scanner;

public class Factorial {

    /** INSTRUCTIONS
     *
     * Write a method to return the Factorial of any given number using Recursion, and also another way, using iteration
     * I have not taught you recursion. Your job is to look it up, learn about it, and use it to find a solution.
     *
     * HINT: Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */

    public static void main(String[] args) {

        System.out.println("factorial of the number entered using recursion is "+ factorialRecursion(5));

        System.out.println("factorial of the number entered using Iteration is " + factorialIteration(6));




    }
    public static int factorialRecursion(int n) {
        if (n == 1) {
            return 1;
        } else {

            int Y=n * factorialRecursion(n - 1);

            return Y;
        }

    }

    public static int factorialIteration(int x){
        int FI=1;
        for(int i=x; i>1;i--){
            FI=FI*i;
        }
        return FI;
    }

}
