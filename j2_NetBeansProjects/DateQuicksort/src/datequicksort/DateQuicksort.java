/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datequicksort;

import java.util.Random;

/**
 *
 * @author Natalia Solar
 */
public class DateQuicksort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int day;
        int month;
        Date[] array = new Date[100];
        for(int i = 0; i<array.length; i++){
            Random randomNumber = new Random();//set up an object to generate random nubmers
            day = randomNumber.nextInt(31) + 1; // generate random number
            month = randomNumber.nextInt(12) + 1; // generate random number
            array[i] = new Date(month, day, 2018);
        }
        
        Date[] test = {new Date(12, 5, 2018), new Date(4, 1, 2018),new Date(1, 2, 2018), new Date(5, 22, 2018)};
        System.out.println("\nGiven array:\n");
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i].toString());
        }
        
        quickSort(array);
        
        System.out.println("\n____________________________________\nSorted array:\n");
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i].toString());
        }
        
        
        
        
        
    }
    
    
    /**
      The quickSort method calls the doQuickSort method to sort an array of elements of type T
      @param array The array to sort.
   */   
   public static <T extends Comparable<T>> void quickSort(T[] array)
   {
      doQuickSort(array, 0, array.length - 1);
   }

   /**
      The doQuickSort method uses the QuickSort algorithm
      to sort an array.
      @param array The array to sort.
      @param start The starting subscript of the list to sort
      @param end The ending subscript of the list to sort
   */   
    private static <T extends Comparable<T>> void doQuickSort(T array[], int start, int end)
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
    private static <T extends Comparable<T>> int partition(T[] array, int start, int end)
    {
       T pivotValue;    // To hold the pivot value
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
          if (array[scan].compareTo(pivotValue) == -1)
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
      The swap method swaps the contents of two elements in an array.
      @param The array containing the two elements.
      @param a The subscript of the first element.
      @param b The subscript of the second element.
   */   
    private static <T> void swap(T[] array, int a, int b)
    {
       T temp;

       temp = array[a];
       array[a] = array[b];
       array[b] = temp;
    }
    
}
