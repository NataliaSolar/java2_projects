
package empiricalstudy;
import java.util.Random;    // to generate random nubmers
/**
 * CS 143 - 9655, Assignment 5
 * @author Natalia Solar
 * Quick sort on 1000000 array - 0 seconds
 * Selection sort on 1000000 array - 14 minutes and 26 seconds
 * Bubble sort on 1000000 array - 43 minutes and 55 seconds
 * Quick sort on 100000000 array - 19 second
 */
public class EmpiricalStudy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random randomNumber = new Random();//set up an object to generate random nubmers
        //create 3 arrays
        int[] arrayQuick = new int[1000000];
        for (int i=0; i<arrayQuick.length; i++){            
            arrayQuick[i] = randomNumber.nextInt(1000000) + 1; // generate random number
        }
        int[] arraySelect = arrayQuick.clone();
        int[] arrayBubbl = arrayQuick.clone();
        
        // Variables used to determine time for a function call
        long currentTime = System.currentTimeMillis();
        long previousTime;
        long elapsedTime = 0;

        System.out.println("Sorting with quick sort.");
        // Record time before function call
        previousTime = currentTime;       
        // Sort the array with quickSort
        quickSort(arrayQuick);
        // Record time after function call
        currentTime = System.currentTimeMillis();
       
        // Compute and print elapsed time in seconds
        elapsedTime = (currentTime - previousTime)/1000;
        //convert into min and sec
        if (elapsedTime>=60){
           long min = elapsedTime/60;
           long sec = elapsedTime - min*60;
           System.out.println("Sorted in " + min + " minutes and "+ sec + " seconds.");
        }
        else System.out.println("Sorted in " + elapsedTime + " seconds.");       
        System.out.println();                              

        //create an array of 100000000 elements
        int[] arrayQuick2 = new int[100000000];
        for (int i=0; i<arrayQuick2.length; i++){            
            arrayQuick2[i] = randomNumber.nextInt(1000000) + 1; // generate random number
        }
        System.out.println("Sorting an array of 100000000 integers with quick sort.");
        // Record time before function call
        previousTime = currentTime;       
        // Sort the array with quickSort
        quickSort(arrayQuick2);
        // Record time after function call
        currentTime = System.currentTimeMillis();

        // Compute and print elapsed time in seconds
        elapsedTime = (currentTime - previousTime)/1000;
        //convert into min and sec
        if (elapsedTime>=60){
           long min = elapsedTime/60;
           long sec = elapsedTime - min*60;
           System.out.println("Sorted in " + min + " minutes and "+ sec + " seconds.");
        }
        else System.out.println("Sorted in " + elapsedTime + " seconds.");       
        System.out.println();
       

        
        System.out.println("Sorting with selection sort.");
        // Record time before function call
        previousTime = currentTime;        
        // Sort the array with selectionSort
        selectionSort(arraySelect);
        // Record time after function call
        currentTime = System.currentTimeMillis();

        // Compute and print elapsed time in seconds
        elapsedTime = (currentTime - previousTime)/1000;
        //convert into min and sec
        if (elapsedTime>=60){
            long min = elapsedTime/60;
            long sec = elapsedTime - min*60;
            System.out.println("Sorted in " + min + " minutes and "+ sec + " seconds.");
        }
        else System.out.println("Sorted in " + elapsedTime + " seconds.");
        System.out.println();

        
        System.out.println("Sorting with bubble sort.");
        // Record time before function call
        previousTime = currentTime;        
        // Sort the array with bubbleSort
        bubbleSort(arrayBubbl);
        // Record time after function call
        currentTime = System.currentTimeMillis();

        // Compute and print elapsed time in seconds
        elapsedTime = (currentTime - previousTime)/1000;
        //convert into min and sec
        if (elapsedTime>=60){
            long min = elapsedTime/60;
            long sec = elapsedTime - min*60;
            System.out.println("Sorted in " + min + " minutes and "+ sec + " seconds.");
        }
        else System.out.println("Sorted in " + elapsedTime + " seconds.");
        System.out.println();
    }
    
    /**
      The quickSort method calls the doQuickSort method
      to sort an int array.
      @param array The array to sort.
   */
   
   public static void quickSort(int array[])
   {
      doQuickSort(array, 0, array.length - 1);
   }

   /**
      The doQuickSort method uses the QuickSort algorithm
      to sort an int array.
      @param array The array to sort.
      @param start The starting subscript of the list to sort
      @param end The ending subscript of the list to sort
   */
   
   private static void doQuickSort(int array[], int start, int end)
   {
      int pivotPoint;
      
      if (start < end)
      {
         // Get the pivot point.
         pivotPoint = partition(array, start, end);
         
         // Sort the first sub list.
         doQuickSort(array, start, pivotPoint - 1);
         
         // Sort the second sub list.
         doQuickSort(array, pivotPoint + 1, end);
      }
   }

   /**
      The partiton method selects a pivot value in an array
      and arranges the array into two sub lists. All the
      values less than the pivot will be stored in the left
      sub list and all the values greater than or equal to
      the pivot will be stored in the right sub list.
      @param array The array to partition.
      @param start The starting subscript of the area to partition.
      @param end The ending subscript of the area to partition.
      @return The subscript of the pivot value.
   */
   
   private static int partition(int array[], int start, int end)
   {
      int pivotValue;    // To hold the pivot value
      int endOfLeftList; // Last element in the left sub list.
      int mid;           // To hold the mid-point subscript

      // Find the subscript of the middle element.
      // This will be our pivot value.
      mid = (start + end) / 2;

      // Swap the middle element with the first element.
      // This moves the pivot value to the start of 
      // the list.
      swap(array, start, mid);

      // Save the pivot value for comparisons.
      pivotValue = array[start];
      
      // For now, the end of the left sub list is
      // the first element.
      endOfLeftList = start;
      
      // Scan the entire list and move any values that
      // are less than the pivot value to the left
      // sub list.
      for (int scan = start + 1; scan <= end; scan++)
      {
         if (array[scan] < pivotValue)
         {
            endOfLeftList++;
            swap(array, endOfLeftList, scan);
         }
      }
      
      // Move the pivot value to end of the
      // left sub list.
      swap(array, start, endOfLeftList);
      
      // Return the subscript of the pivot value.
      return endOfLeftList;
   }

   /**
      The swap method swaps the contents of two elements
      in an int array.
      @param The array containing the two elements.
      @param a The subscript of the first element.
      @param b The subscript of the second element.
   */
   
   private static void swap(int[] array, int a, int b)
   {
      int temp;
      
      temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   
   
   /**
      The bubbleSort method uses the bubble sort algorithm
      to sort an int array.
      @param array The array to sort.
   */
   
   public static void bubbleSort(int[] array)
   {
      int lastPos;     // Position of last element to compare
      int index;       // Index of an element to compare
      int temp;        // Used to swap to elements
      
      // The outer loop positions lastPos at the last element
      // to compare during each pass through the array. Initially
      // lastPos is the index of the last element in the array.
      // During each iteration, it is decreased by one.
      for (lastPos = array.length - 1; lastPos >= 0; lastPos--)
      {
         // The inner loop steps through the array, comparing
         // each element with its neighbor. All of the elements
         // from index 0 thrugh lastPos are involved in the
         // comparison. If two elements are out of order, they
         // are swapped.
         for (index = 0; index <= lastPos - 1; index++)
         {
            // Compare an element with its neighbor.
            if (array[index] > array[index + 1])
            {
               // Swap the two elements.
               temp = array[index];
               array[index] = array[index + 1];
               array[index + 1] = temp;
            }
         }
      }
   }
   
   
   /**
      The selectionSort method performs a selection sort on an
      int array. The array is sorted in ascending order.
      @param array The array to sort.
   */

   public static void selectionSort(int[] array)
   {
      int startScan;   // Starting position of the scan
      int index;       // To hold a subscript value
      int minIndex;    // Element with smallest value in the scan
      int minValue;    // The smallest value found in the scan

      // The outer loop iterates once for each element in the
      // array. The startScan variable marks the position where
      // the scan should begin.
      for (startScan = 0; startScan < (array.length-1); startScan++)
      {
         // Assume the first element in the scannable area
         // is the smallest value.
         minIndex = startScan;
         minValue = array[startScan];
         
         // Scan the array, starting at the 2nd element in
         // the scannable area. We are looking for the smallest
         // value in the scannable area. 
         for(index = startScan + 1; index < array.length; index++)
         {
            if (array[index] < minValue)
            {
               minValue = array[index];
               minIndex = index;
            }
         }

         // Swap the element with the smallest value 
         // with the first element in the scannable area.
         array[minIndex] = array[startScan];
         array[startScan] = minValue;
      }
   }
    
}
