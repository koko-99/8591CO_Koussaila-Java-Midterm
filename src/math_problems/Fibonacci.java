package math_problems;

public class Fibonacci {

    /** INSTRUCTIONS
     *
     * Write a method that will print or return at least 40 Fibonacci number
     * e.g. - 0,1,1,2,3,5,8,13
     **/

    public static void main(String[] args) {
        int n1=0;
        int n2=1;

        for(int i=2; i<=40;i++){
            int sum=n1+n2;
            System.out.println(" "+ sum);
            n1=n2;
            n2=sum;

        }

    }
}
