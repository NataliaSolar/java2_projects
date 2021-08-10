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
public class Box {
    double height;
    Rectangle base;
  
    public Box()
    {
        height = 1;
        base = new Rectangle();
    }
/**
 * Constructor that takes height as double and base as an object and creates a Box object using the data
 * @param h height of a box
 * @param b base of a box
 * @throws IllegalArgumentException 
 */
    public Box(double h, Rectangle b)throws IllegalArgumentException
    {
        if(h<0) throw new IllegalArgumentException ("Negative height "+h);
        height = h;
        base = new Rectangle(b);
    }
    
    public Box(Box obj)
    {
        height = obj.height;
        base = new Rectangle(obj.base);
    }
    
    public void setBase(Rectangle obj)
    {
        base = new Rectangle(obj);
    }
    /**
     * accessor method for field base
     * @return copy of field base
     */
    public Rectangle getBase()
    {
        return new Rectangle(base) ;
    }
    
    public String toString()
    {
        return "Height "+height+base.toString();    
    }
}
