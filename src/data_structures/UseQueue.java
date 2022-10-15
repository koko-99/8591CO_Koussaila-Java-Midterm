package data_structures;

import databases.SharedStepsDatabase;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

    /** INSTRUCTIONS
     *
     * Demonstrate how to use Queue that includes add, peek, remove & poll methods.
     * Use For-Each loop and While-Loop with Iterator to retrieve data.
     *
     * Store and retrieve data from/to a database table.
     */




    public static void main(String[] args)
    {
        //create a queue
        Queue<Integer> q = new LinkedList<>();

        // Adds elements {0, 1, 2, 3, 4} to
        // the queue
        int i=0;
        while(i<7){
            q.add(i);
            i++;
        }

        /*// Display contents of the queue using foreach loop
        System.out.println("Elements of queue : ");
        for(int num:q)
            System.out.print(num+" ");

        System.out.print("");*/

        // Demonstrate peek
        int head = q.peek();
        System.out.println("peek of queue: "+ head);

        // To remove the head of queue.
        int first = q.remove();
        System.out.println("removed element: "+first);


        // Display contents of the queue using while loop with iterator
        System.out.println("Elements of queue: "+ q);
        Iterator it=q.iterator();
        while (it.hasNext())
            System.out.print(it.next());
        System.out.println(" "+" are the elements of the queue");
        //poll element
        int pollelement=q.poll();
        System.out.println(" Queue's head: " + pollelement);

    }
}
