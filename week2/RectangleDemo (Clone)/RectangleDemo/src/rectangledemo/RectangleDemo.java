/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledemo;
import java.util.Arrays;

/**
 *
 * @author alexandra.vaschillo
 */
public class RectangleDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     /*   int a = 55;
        int b = 99;
      //  try{
            Rectangle r1 = new Rectangle(a, b);
        Box box = new Box(70, r1);
        System.out.println(box.toString());
        r1.setLength(1);
        System.out.println(box.toString());
     */
     int[] a = {1, 2, 3};
     //int[] c = a;
     // default clone() method
     int[] b = a.clone();
     a[0]=55;
     ColoredBox b1 = new ColoredBox(5, 8, 9, a);
     ColoredBox b2 = new ColoredBox(15, 18, 19, b);
     ColoredBox b3 = b1.clone();
     b1.setColor(8, 8, 8);
     System.out.println(Arrays.toString(a));
     System.out.println(Arrays.toString(b));
     
     System.out.println(b1.toString());
     System.out.println(b2.toString());
     System.out.println(b3.toString());
     // 04/10/19
     Rectangle n =  new ColoredBox();//this is the polymorfism
     Rectangle[] m = new Rectangle[5];
     for (int i=0; i<5; i++){
         if(i%2==0) m[i] = new Rectangle();
         else m[i] = new ColoredBox();
     }
     
     
    // for(int i=0; i<5; i++){
    //     if(m[i] instanceof ColoredBox) ColoredBox c= (ColoredBox) m[i];
    // }
     for (int i=0; i<5; i++){
         
         System.out.println("Object # " + (i+1)+ " " + m[i].toString());
     }
     
     Rectangle r = (Rectangle) new ColoredBox();
     System.out.println(r.toString());
     //ColoredBox cb = (ColoredBox)new Rectangle(r);
     //double h = cb.getHeight();
        /*
        int[] numbers = {4,2,5,2,6,10,3,7,6};
        int numbersSize = numbers.length;
        //print unsorted array
        System.out.print("Unsorted array: ");
        for (int i =0; i < numbersSize; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        //sorting
        for (int i = 1; i < numbersSize; ++i) {
        int j = i;
            // Insert numbers[i] into sorted part 
            // stopping once numbers[i] in correct position
            while (j > 0 && numbers[j] < numbers[j - 1]) {

               // Swap numbers[j] and numbers[j - 1]
               int temp = numbers[j];
               numbers[j] = numbers[j - 1];
               numbers[j - 1] = temp;
               --j;               
            }
            //print the array
            for (int k =0; k < numbersSize; k++){
                    System.out.print(numbers[k] + " ");
                }
               System.out.println();     
        }*/
        
        int[] numbers = {9,8,7,6,5,4,3,2,1};
        int numbersSize = numbers.length;
        //print unsorted array
        System.out.print("Unsorted array: ");
        for (int i =0; i < numbersSize; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        int[] gapValues = {7,3,1};
        ShellSort( numbers, numbersSize, gapValues);
        //print sorted array
        System.out.print("Sorted array: ");
        for (int k =0; k < numbersSize; k++){
                System.out.print(numbers[k] + " ");
            }
    }
    public static void InsertionSortInterleaved(int[] numbers, int numbersSize, int startIndex, int gap) {
        int i = 0;
        int j = 0;
        int temp = 0;  // Temporary variable for swap

        for (i = startIndex + gap; i < numbersSize; i = i + gap) {
           j = i;
           while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) {
                temp = numbers[j];
                numbers[j] = numbers[j - gap];
                numbers[j - gap] = temp;
                j = j - gap;
           }
           for (int k =0; k < numbersSize; k++){
                System.out.print(numbers[k] + " ");
            }
           System.out.println();
        }
    }
    
    public static void ShellSort(int[] numbers, int numbersSize, int[] gapValues) {
        for (int gapValue : gapValues) {
           for (int i = 0; i < gapValue; i++) {
                InsertionSortInterleaved(numbers, numbersSize, i, gapValue);
           }
        }
    }
    
}
