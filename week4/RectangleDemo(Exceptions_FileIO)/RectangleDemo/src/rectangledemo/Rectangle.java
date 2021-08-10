/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledemo;
import java.util.*;
import java.io.*;
/**
 *
 * @author alexandra.vaschillo
 */
public class Rectangle implements Cloneable, Serializable {
    protected double length;
    protected double width;
    private int label;
    /**
     * No-argument constructor
     */
    public Rectangle()
    {
        System.out.println("Calling non-arg Rectangle constructor");
        Random r = new Random();
        label = r.nextInt(100)+1;
        length=1;
        width=1;
    }
     public Rectangle(double l, double w) throws NegativeMeasurementException
     {
         System.out.println("Calling Rectangle constructor");
         Random r = new Random();
         label = r.nextInt(100)+1;
         if(l<0) throw new IllegalArgumentException ("Negative length");
         if(w<0) throw new IllegalArgumentException ("Negative width");
         length = l;
         width= w;
     }
     public Rectangle(Rectangle obj)
     {
         this.length = obj.length;
         width = obj.width;
         this.label = obj.label;
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
    public void setWidth(double w)throws IllegalArgumentException 
    {
        if(w<0) throw new IllegalArgumentException ("Negative width");
        width = w;
    }
    @Override public String toString()
    {
        String s = "Width: "+width+" Length: "+length;
        return s;
    }
    @Override public Rectangle clone()
    {
        try{
        return (Rectangle)super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
    @Override public boolean equals(Object obj)
     {
         if(obj == null) return false;
         else if(this.getClass()!= obj.getClass()) return false;
         else
         {
            Rectangle obj2 = (Rectangle)obj;
            return this.length==obj2.length && this.width==obj2.width ; 
         }
         
     }
}
