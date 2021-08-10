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
public class ColoredRectangle extends Rectangle{
    int[] color;
    
    public ColoredRectangle()
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
    public ColoredRectangle(double len, double wid, int[] c)
    {
        super(len, wid);
        System.out.println("Calling  COLOREDRectangle constructor");
        if(c.length!=3)throw new IllegalArgumentException("Invalid RGB array");
        for(int i = 0; i<c.length; i++) 
        {
            if(c[i]<0||c[i]>255)throw new IllegalArgumentException("Invalid RGB array");
        }
        color = new int[3];
        for(int i = 0; i<c.length; i++) 
        {
            color[i]=c[i];
        }
    }
    
    
}
