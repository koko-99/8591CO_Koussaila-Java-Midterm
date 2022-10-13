package math_problems;

import java.util.*;

public class FindLowestDifference {

    /** INSTRUCTIONS
     * Write a method to return the lowest number, that is not shared between the 2 arrays below
     * HINT: The lowest number that isn't shared between these arrays is 1
     */

    public static void main(String[] args) {


        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1, -15};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19, -15};

        Set<Integer> Sarray1 = new HashSet<Integer>();
        Set<Integer> Sarray2 = new HashSet<Integer>();
        for(int i=0;i<9;i++)
        {
            Sarray1.add(array1[i]);

        }
        for(int i=0;i<9;i++)
        {
            Sarray2.add(array2[i]);
        }
        int lowestNumber=array1[0];

        for(int i=0;i<9;i++)
        {
            if(Sarray2.contains(array1[i])==false)
            {
                lowestNumber=array1[i]>lowestNumber?lowestNumber:array1[i];}}
        for(int i=0;i<9;i++) {
            if(Sarray1.contains(array2[i])==false) {
                lowestNumber=array2[i]>lowestNumber?lowestNumber:array2[i];
            } }
        System.out.println(lowestNumber);
        } }








