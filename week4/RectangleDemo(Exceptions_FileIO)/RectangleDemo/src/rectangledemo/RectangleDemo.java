/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledemo;
import java.io.*;

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
        
        try{
            Rectangle[] array = new Rectangle[5];
            for(int i = 0; i<array.length; i++)
            {
               // if(i%2==0) 
                    array[i] = new Rectangle(i, i);
              //  else 
                 //   array[i] = new ColoredBox();
            }
/*
            for(int i = 0; i<array.length; i++)
            {
                System.out.println(array[i].toString());
            }
            
       */
            ///////////////////////////////
            
            FileOutputStream outStream = 
                new FileOutputStream("Objects.dat");
      ObjectOutputStream objectOutputFile = 
                new ObjectOutputStream(outStream);
      
      // Write the serialized objects to the file.
      for (int i = 0; i < array.length; i++)
      {
         objectOutputFile.writeObject(array[i]);
      }
      
      // Close the file.
      objectOutputFile.close();
      
      System.out.println("The serialized objects " +
            "were written to the Objects.dat file.");
        //////////////////////////////////////////
      FileInputStream inStream = 
                 new FileInputStream("Objects.dat");
      ObjectInputStream objectInputFile = 
                 new ObjectInputStream(inStream);
      boolean endOfFile = false;
      Rectangle obj; 
      while (!endOfFile)
      {
         try
         {
            obj = (Rectangle)objectInputFile.readObject();
            System.out.println(obj.toString() + " ");
         }
 
         catch (EOFException e)
         {
            endOfFile = true;
         }
      }
      objectInputFile.close();
      
        }
         catch(ClassNotFoundException e)
         {
            System.out.println("Class not found! "+e.getMessage());  
         }
        catch(IOException e)
        {
            System.out.println("IO Exception!! "+e.getMessage()); 
        }
        catch(NegativeMeasurementException e)
        {
            System.out.println(e.getMessage());
        }
        
     /*   int a = 55;
        int b = 99;
      //  try{
            Rectangle r1 = new Rectangle(a, b);
        Box box = new Box(70, r1);
        System.out.println(box.toString());
        r1.setLength(1);
        System.out.println(box.toString());
     */
     /*
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
     
     Rectangle r = (Rectangle) new ColoredBox();
 //    double h1 = r.getHeight();
     System.out.println(r.toString());
     ColoredBox cb = (ColoredBox)new Rectangle(r);
     double h = cb.getHeight();
     */
    }
    
}
