/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledemo;
/**
 *
 * @author alexandra.vaschillo
 */
public class Rectangle {
    private double length;
    private double width;
    /**
     * No-argument constructor
     */
    public Rectangle()
    {
        length=1;
        width=1;
    }
     public Rectangle(double l, double w) throws IllegalArgumentException
     {
         if(l<0) throw new IllegalArgumentException ("Negative length");
         if(w<0) throw new IllegalArgumentException ("Negative width");
         length = l;
         width= w;
     }
     public Rectangle(Rectangle length)
     {
         this.length = length.length;
         width = length.width;
     }
    /**
     * Acessor method returns length field
     * @return returns length field 
     */
    public double getLength()
    {
        return length;
    }
    public double getWidth()
    {
        return width;
    }
    /**
     * Mutator for length field
     * @param l  takes length value as a parameter
     */
    public void setLength(double l)throws IllegalArgumentException 
    {
        if(l<0) throw new IllegalArgumentException ("Negative length");
        length = l;
    }
    public void setWidth(double w)
    {
        if(w<0) throw new IllegalArgumentException ("Negative width");
        width = w;
    }
    public String toString()
    {
        String s = "Width: "+width+" Length: "+length;
        return s;
    }
}
