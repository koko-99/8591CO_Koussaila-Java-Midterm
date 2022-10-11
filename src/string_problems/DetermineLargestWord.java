package string_problems;



import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {

    /** INSTRUCTIONS
     * Implement a solution to find the length of the longest word in the given sentence below
     * Your solution should return a map containing the length of the word as the key & the word itself as the value
     * "10: biological"
     */

    public static void main(String[] args) {
        String s = "Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);

        for(String word : wordNLength.values()){
            s= word.length() + ": " + word;
        }
        System.out.println(s);
            }
    public static Map<Integer, String> findTheLargestWord(String wordGiven) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";
        String array1[] = wordGiven.split(" ");
        st= array1[0];
        for(int i=1;i<array1.length; i++){
            if(array1[i].length()> st.length()){
                st=array1[i];
            }}
        map.put(st.length(), st);
        return map;
    }
}
