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
public class ColoredBox extends Rectangle implements Cloneable{
       int[] color;
       double height;
    
    public ColoredBox()
    {
        super();
      //  Rectangle r = new Rectangle();
        System.out.println("Calling non-arg COLOREDRectangle constructor");
        color = new int[3];
        color[0] = 0;
        color[1] = 0;
        color[2] = 0; 
        //this.length = 88;
    }
    public ColoredBox(double len, double wid, double ht, int[] c)throws NegativeMeasurementException, IllegalArgumentException
    {
        super(len, wid);
       // System.out.println("Calling  COLOREDRectangle constructor");
       if(ht<0)throw new NegativeMeasurementException(ht);
        
        if(c.length!=3)throw new IllegalArgumentException("Invalid RGB array");
        for(int i = 0; i<c.length; i++) 
        {
            if(c[i]<0||c[i]>255)throw new IllegalArgumentException("Invalid RGB array");
        }
        height = ht;  
        color = new int[3];
        for(int i = 0; i<c.length; i++) 
        {
            color[i]=c[i];
        }
    }
    public double getHeight()
    { return height;}
    
    // useless copy constructor
    /*
    public ColoredBox(ColoredBox obj)
    {
        //super(obj.length, obj.width);
        this.length = obj.length;
        this.width = obj.width;
        this.height = obj.height;
        // deep copy of array
        color = new int[3];
        for(int i = 0; i<obj.color.length; i++) 
        {
            color[i]=obj.color[i];
        }
        
    }
*/
    public void setColor(int r, int g, int b) throws IllegalArgumentException
    {
        if(r<0||r>255)throw new IllegalArgumentException("Invalid red value");
        if(g<0||g>255)throw new IllegalArgumentException("Invalid green value");
        if(b<0||b>255)throw new IllegalArgumentException("Invalid blue value");
        color[0] = r;
        color[1] = g;
        color[2] = b;
       
    }
    @Override public ColoredBox clone()
    {
        ColoredBox objCopy = (ColoredBox)super.clone(); //????
        objCopy.height = this.height;
        objCopy.color = this.color.clone(); // Works only because the arry is of primitive type (shallow copy of the elements)
        return objCopy;  
    }
    
    public double boxVolume()
    {
        return length*width*height; 
    }
    
    @Override public String toString()
    {
       return super.toString()+ " Height: "+height+" RGB("+color[0]+", "+color[1]+", "+color[2]+")";
    }
   
}
