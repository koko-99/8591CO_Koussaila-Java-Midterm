package math_problems;

public class FindMissingNumber {

    /** INSTRUCTIONS
     * Write a method to find the missing number from the array.
     */

    public static void main(String[] args) {
        int[] array = new int[] {10, 2, 1, 4, 5, 3, 7, 8, 6};

        int missingNumber = findMissingNumber(array);

        System.out.println(missingNumber);
    }
    public static int findMissingNumber(int array[]){
        int i;
        int n=10;
        int totalSum= n*(n+1)/2;
        int arraySum=0;
        for(i=0;i<array.length;i++){
            arraySum=arraySum +array[i];
        }
        int missingNumber= totalSum-arraySum;
        return missingNumber;
    }
}
