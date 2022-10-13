package string_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateWord {

    /** INSTRUCTIONS
     * Write a java program to find duplicate words and the number of occurrences of those words in the given string.
     * Also, find the average length of all the words
     */

    public static void main(String[] args) {
        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        // Implement here
        String wordWithoutDot= st.replace(".", "");
        String[] words = wordWithoutDot.split(" ");
        Map<String,Integer> wordCount= new HashMap<>();
        for (String word: words) {
        Integer count= wordCount.get(word);
        if (count==null){
            count=0;
        }
        wordCount.put(word, count + 1);
        }
        Set<Map.Entry<String, Integer>> entrySet= wordCount.entrySet();
        for (Map.Entry<String, Integer> entry: entrySet){
            if (entry.getValue()>1){
            System.out.println(entry.getKey() +":" + entry.getValue());
        }}

        calculateLength(st);


    }
   static void calculateLength(String words ){
       String wordWithoutDot= words.replace(".", "");
       String wordWithoutDotAndSpace= words.replace(" ", "");
       String[] arrayOfWords = wordWithoutDot.split(" ");

       int numOfWords= arrayOfWords.length;
       int numOfChar= wordWithoutDotAndSpace.length();

       int average= numOfChar/numOfWords;

       System.out.println("Length of all the words is: "+ average);




       }

   }