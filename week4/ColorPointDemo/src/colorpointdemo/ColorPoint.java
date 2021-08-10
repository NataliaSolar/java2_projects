/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorpointdemo;

import java.io.Serializable;

/**
 *
 * @author Natalia Solar
 */
public class ColorPoint  implements Serializable{
    
    private int x; //x coordinate on a plane
    private int y;// y coordinate on a plane
    private int colorR;// red color component
    private int colorG;// green color component
    private int colorB;// blue color component
    
    /**
     * Non-argument constructor that sets all variables to 0.
     */
    public ColorPoint(){
       
        x = 0;
        y = 0;
        colorR = 0;
        colorG = 0;
        colorB = 0;
    }
    
    /**
     * Constructor that takes all the data about the point position 
     * and color as parameters (5 parameters) and initializes fields.
     * @param x x coordinate on a plane
     * @param y y coordinate on a plane
     * @param colorR red color component
     * @param colorG green color component
     * @param colorB  blue color component
     * @throws colorpointdemo.InvalidRgbException if the value for red, green, or blue is out of correct range
     */
    public ColorPoint(int x,int y, int colorR, int colorG, int colorB)throws InvalidRgbException{
        
        if (colorR<0 || colorR>255) throw new InvalidRgbException("colorR", colorR);
        if (colorG<0 || colorG>255) throw new InvalidRgbException("colorG", colorG);
        if (colorB<0 || colorB>255) throw new InvalidRgbException("colorB", colorB);
        this.x = x;
        this.y = y;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }
    
    /**
     * Accressor for x field
     * @return value of x
     */
    public int getX(){
        return x;
    }
    
    /**
     * Accressor for y field
     * @return value of y
     */
    public int getY(){
        return y;
    }
    
    /**
     * Accressor for colorR field
     * @return value of colorR
     */
    public int getR(){
        return colorR;
    }
    
    /**
     * Accressor for colorG field
     * @return value of colorG
     */
    public int getG(){
        return colorG;
    }
    
    /**
     * Accressor for colorB field
     * @return value of colorB
     */
    public int getB(){
        return colorB;
    }

    /**
     * Mutator for x and y fields
     * @param x x coordinate on a plane to be set
     * @param y y coordinate on a plane to be set
     */
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Mutator for colorR, colorG, colorB fields
     * @param r red color component to be set
     * @param g green color component to be set
     * @param b blue color component to be set
     * @throws colorpointdemo.InvalidRgbException
     */
     public void setRGB(int r, int g, int b) throws InvalidRgbException{
         
        if (r<0 || r>255) throw new InvalidRgbException("colorR", r);
        if (g<0 || g>255) throw new InvalidRgbException("colorG", g);
        if (b<0 || b>255) throw new InvalidRgbException("colorB", b);
         colorR = r;
         colorG = g;
         colorB = b;
     }
     
     /**
     * Method that creates and returns a string containing information about ColorPoint object
     * @return a text containing information about ColorPoint object
     */
    @Override public String toString(){
        return "x coordinate on a plane: " + x +"\n"+ "y coordinate on a plane: " + y + "\n"+ 
                "RGB color components:("+colorR+", "+colorG+", "+colorB+")";
    }
    
    /**
     * Method that compares two ColorPoint objects
     * @param otherObj object to be compared with
     * @return true if objects are equal
     */
    @Override public boolean equals(Object otherObj)
   {
       if(otherObj == null) return false;
       if (this.getClass()!= otherObj.getClass()) return false;
       ColorPoint a = (ColorPoint)otherObj;
       if (super.equals(a)) return true;
       if (x == a.x && y == a.y && colorR==a.colorR && colorG==a.colorG && colorB==a.colorB) return true;
       return false;
   }
    
}
