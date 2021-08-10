/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledemo;
//import Rectangle.java;

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
     ColoredBox cr = new ColoredBox(5, 10, 15, a);
     
     cr.setWidth(100);
     System.out.println(cr.toString());
    }
    
}
