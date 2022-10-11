package string_problems;

import java.util.Arrays;

public class Anagram {

    /** INSTRUCTIONS
     * Write a Java Program, `isAnagram`, to check if any two strings are anagrams
     *
     *  An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all of the
     *  original letters exactly once.
     *
     *         Ex: "CAT" & "ACT",
     *             "ARMY" & "MARY",
     *             "FART" & "RAFT"
     */

    // Implement Here


        /**
         Use this class to unit test all of the classes contained within this package
         */


        static boolean areAnagram(char[]str1, char[]str2){
            int n1=str1.length;
            int n2=str2.length;

            if(n1 != n2)
                return false;

            Arrays.sort(str1);
            Arrays.sort(str2);
            for(int i=0; i<n1 ; i++)
                if (str1[i] != str2[i])
                    return false;

            return true;

        }
        public static void main(String[] args) {
            char str1[]={'a','r','m','y'};
            char str2[]={'m','a','r','y'};

            if(areAnagram(str1, str2))
                System.out.println("the two Strings are anagram");
            else
                System.out.println("the two Strings are not anagram");


        }
    }


