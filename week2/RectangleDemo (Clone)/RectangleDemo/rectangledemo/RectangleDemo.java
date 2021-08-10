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
        // TODO code application logic here
        MyClass testObj = new MyClass();
        testObj.setA(55);
        MyClass otherObj = new MyClass(testObj); // call fro copy constructor
        if(testObj.equals(otherObj)) System.out.println("Equal");
        
       /* Rectangle n = testObj.getR();
        n.setLength(55);
        System.out.println(testObj.getRLength());
        System.out.println(n);
        Rectangle a = new Rectangle();
        */
        
        
        
 /*        Rectangle r = new Rectangle(2, 5);
        r.setLength(4.5);
       
 //       System.out.printf("Length: %.2f; Width: %.2f\n", r.getLength(), r.getWidth());
        System.out.println(r.toString());
        Rectangle [] set = new Rectangle [6];
       // set[0].setLength(77);
        for(int i = 0; i<set.length; i++)
        {
            set[i] = new Rectangle();
        }
        
        set[0].setLength(77);*/
    }
    
}
