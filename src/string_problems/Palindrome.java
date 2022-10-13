package string_problems;

public class Palindrome {

    /** INSTRUCTIONS
     * A palindrome is a word that can be reversed, and still remain the same.
     *
     * Example: MOM, DAD, MADAM, RACECAR
     *
     * Create a method to check if any given String is a palindrome or not.
     */

    public static void main(String[] args) {
        String original = "";
        String reverse = "";
        original= original.replace(" ", "");

        for (int i = original.length() - 1; i >= 0; i--) {
            reverse += original.charAt(i);


        }

        boolean palindrome = true;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != reverse.charAt(i)) {
                palindrome = false;
            }
        }
        if (palindrome) {
            System.out.println("Palindrome");

        } else
            System.out.println("Not a Palindrome");
    }


}
