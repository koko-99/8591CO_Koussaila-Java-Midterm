package data_structures;

import databases.SharedStepsDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseArrayList {

    /** INSTRUCTIONS
     *
     * Demonstrate how to use an ArrayList that includes using the add, peek, remove & retrieve methods.
     * Use For-Each loop and While-loop with Iterator to retrieve the data.
     *
     * Store and retrieve the data from/to a database table.
     */

    public static void main(String[] args) {
        ArrayList<Object> listOfIntegers = new ArrayList<>();
        // to add data into ArrayList we use add()
        listOfIntegers.add(2);
        listOfIntegers.add(5);
        listOfIntegers.add(75);
        listOfIntegers.add(3);
        listOfIntegers.add(12);
        //if we want to get an element we use get() and pass the index as argument
        System.out.println(listOfIntegers.get(0));

        // to remove an element from arraylist we use method remove() and pass index as a parameter
        listOfIntegers.remove(4);
        System.out.println(listOfIntegers);
        System.out.println("************");

        // to iterate over the liste we can use for each loop or an iterator

        // for each loop
        for (Object num : listOfIntegers
        ) {
            System.out.println(num);
        }

        System.out.println("***********");
        // using an iterator along with while loop
        Iterator it = listOfIntegers.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        // connecting to db
        SharedStepsDatabase sql = new SharedStepsDatabase();

        // storing data to db
        String table = "Array_list";
        sql.insertList(table, "Marks", listOfIntegers);


        // retrieving data from DB

        try {
            List dataFromDB = sql.executeQueryReadAll("select * from " + table);

            Iterator  itr = dataFromDB.iterator();
            while (itr.hasNext()){
                System.out.println(itr.next());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        sql.closeResources();

    }

}