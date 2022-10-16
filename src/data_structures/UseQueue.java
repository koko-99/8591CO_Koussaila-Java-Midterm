package data_structures;

import databases.SharedStepsDatabase;

import java.sql.SQLException;
import java.util.*;

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

        System.out.println("peek of queue: "+ q.peek());

        // To remove the head of queue.

        System.out.println("removed element: "+q.remove());


        // Display contents of the queue using while loop with iterator
        System.out.println("Elements of queue: "+ q);
        Iterator it=q.iterator();
        while (it.hasNext())
            System.out.print(it.next());
        System.out.println(" "+" are the elements of the queue");
        //poll element

        System.out.println(" Queue's head: " + q.poll());
        // copy data to Linkedlist
        List<Object> qCopy= new ArrayList<>(q);

        SharedStepsDatabase sql= new SharedStepsDatabase();
        String table="queue";
        sql.insertList(table,"Integers",qCopy);
        // retrieve data
        try {
            List l = sql.executeQueryReadAll("select * from "+ table);
            System.out.println(l);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
}
