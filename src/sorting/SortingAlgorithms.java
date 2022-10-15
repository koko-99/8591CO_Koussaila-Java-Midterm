package sorting;

public class SortingAlgorithms {


    /** INSTRUCTIONS
     * You must implement all of the sorting algorithms below. Feel free to add any helper methods that you may need,
     * but make sure they are private, as to not be accessed outside of this class.
     *
     * You must also store the sorted arrays into their own individual database tables (Selection Sort should be stored
     *  in table `selection_sort`, Insertion Sort should be stored in table `insertion_sort`)
     */

    long executionTime = 0;

    public static void printSortedArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();


        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min])
                    min = j;
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }

        final long endTime = System.currentTimeMillis();
        //this.executionTime = endTime - startTime;

        return array;
    }

    public static int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        // IMPLEMENT HERE

        for (int i=1; i<array.length-1;i++) {
            int curr = array[i];
            while (i > 0 && curr < array[i - 1]) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = curr;
        }


        final long endTime = System.currentTimeMillis();
        final long executionTime= endTime- startTime;
        //this.executionTime = endTime - startTime;

        return array;
    }

    public int[] bubbleSort(int[] array) {
        // IMPLEMENT HERE

        int n = array.length;
        int temp = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<(n-1); j++){
                if(array[j-1]>array[j]){
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }


        return array;
    }

    public int[] mergeSort(int[] array) {
        // IMPLEMENT HERE

        if (array ==null){
        }
        if(array.length>1){
            int mid = array.length/2;
            // Split left part
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++)
            {
                left[i] = array[i];
            }

            // Split right part
            int[] right = new int[array.length - mid];
            for(int i = mid; i < array.length; i++)
            {
                right[i - mid] = array[i];
            }
            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while(i < left.length && j < right.length)
            {
                if(left[i] < right[j])
                {
                    array[k] = left[i];
                    i++;
                }
                else
                {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while(i < left.length)
            {
                array[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length)
            {
                array[k] = right[j];
                j++;
                k++;
            }
        }


        return array;
    }


    // supportive partition function for quicksort
    static int partition(int array[], int low, int high)
    {
        // highest value
        int pivot = array[high];

        // index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot) {
                i++;

                // swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
    public static int[] quickSort(int[] array) {
        // IMPLEMENT HERE
        int [] list = array;
        //implement here
        // fetching length, lower limit and upper limit of index
        int n = list.length;
        int h = n-1;
        int l = 0;
        // Create an auxiliary stack
        int[] stack = new int[h - l + 1];

        // initialize top of stack
        int top = -1;

        // push initial values of l and h to stack
        stack[++top] = l;
        stack[++top] = h;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];

            // Set pivot element at its correct position
            // in sorted array
            int p = partition(list, l, h);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }


        return array;
    }
    // supportive function for heapSort, buildMaxHeap
    // generate max heap from array
    static void buildMaxHeap(int array[])
    {
        // fetching length from list
        int n = array.length;
        for (int i = 1; i < n; i++)
        {
            // if child is bigger than parent
            if (array[i] > array[(i - 1) / 2])
            {
                int j = i;

                // swap child and parent until
                // parent is smaller
                while (array[j] > array[(j - 1) / 2])
                {
                    int temp = array[j];
                    array[j]=array[(j - 1) / 2];
                    array[(j - 1) / 2] = temp;

                    j = (j - 1) / 2;
                }
            }
        }
    }
    public static int [] heapSort(int[] array){


        //implement here
        buildMaxHeap(array);
        // fetching length of list
        int n = array.length;
        int temp;

        for (int i = n - 1; i > 0; i--)
        {
            // swap value of first indexed
            // with last indexed
            temp = array[0];
            array[0]=array[i];
            array[i] = temp;


            // maintaining heap property
            // after each swapping
            int j = 0, index;

            do
            {
                index = (2 * j + 1);

                // if left child is smaller than
                // right child point index variable
                // to right child
                if (index < (i - 1) && array[index] < array[index + 1])
                    index++;

                // if parent is smaller than child
                // then swapping parent with child
                // having higher value
                if (index < i && array[j] < array[index]){
                    temp = array[j];
                    array[j]=array[index];
                    array[index] = temp;
                }

                j = index;

            } while (index < i);
        }


        return array;
    }

    public static int[] bucketSort(int[] array /*, int maximum_value*/) {
        final long startTime = System.currentTimeMillis();
        //implement here
       /* //creating an empty array called newbucket which is considered as bucket array

        int[] newbucket = new int[maximum_value + 1];
//creating another empty array called sorted_array to store the result array
        int[] sorted_array = new int[array.length];
//traversing through the input array to add each element to the bucket array
        for (int a= 0; a <array.length; a++)
            newbucket[array[a]]++;
//sorting each element in the bucket array and adding each sorted element in order to the original input array
        int position = 0;
        for (int b = 0; b < newbucket.length; b++)
            for (int c = 0; c < newbucket[b]; c++)
                sorted_array[position++] = b;

        final long endTime = System.currentTimeMillis();
        //this.executionTime = endTime - startTime;
        return sorted_array;
    }
    //helper Method for bucket sort
    private int maximumValue(int[] array)
    {
        int maximum_value = 0;
        for (int d = 0; d < array.length; d++)
            if (array[d] > maximum_value)
                maximum_value = array[d];*/
        /*return maximum_value;*/
        return array;
    }


    public static int[] shellSort(int[] array ) {
        final long startTime = System.currentTimeMillis();


        //implement here
        /*for(int gap= array.length/2; gap >=1; gap/=2){
            for(int j=gap; j<array.length;j++){
                *//*int temp=array[i];*//*
                *//*int j;*//*
                //while (j>=gap && array[j].compareTo(array[j-gap])>0){

                for(int i=j-gap;i>=0 ; i=i-gap){
                *//*array[j]=array[j-gap];*//*
                *//*array[j]=temp;}*//*
                    int a[]=new int[i];

                    if(a[i + gap]>a[i]){
                        break;
                    }
                    swap(a[i+gap],a[i]);
                }
            }
        }*/

        /*for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    array[j] = array[j - interval];
                }
                array[j] = temp;
            }
        }*/

        final long endTime = System.currentTimeMillis();
       // this.executionTime = endTime - startTime;
        return array;
    }

    /*private static void swap(int i, int i1) {
    }*/

    public static void main(String args[])
    {
        int arr[] = {56, 5,45, 17, 2, 8};
        /*int n = arr.length;*/


        System.out.print("input array \n");
        printSortedArray(arr);


        //insertionSort(arr);
        //selectionSort(arr);
        //heapSort(arr);
        /*quickSort(arr);*/
        /*shellSort(arr);??*/
        /*bucketSort(arr);*/


        System.out.print("our sorted array: \n");
        printSortedArray(arr);
    }
}