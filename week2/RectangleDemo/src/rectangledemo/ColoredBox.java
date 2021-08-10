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
public class ColoredBox extends Rectangle{
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
    public ColoredBox(double len, double wid, double ht, int[] c)throws IllegalArgumentException 
    {
        super(len, wid);
       // System.out.println("Calling  COLOREDRectangle constructor");
       if(ht<0)throw new IllegalArgumentException("Negative height "+ht);
        
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
    public double boxVolume()
    {
        return length*width*height; 
    }
    
    @Override public String toString()
    {
       return super.toString()+ " Height: "+height+" RGB("+color[0]+", "+color[1]+", "+color[2]+")";
    }
   
}
