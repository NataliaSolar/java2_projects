/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapesdemo;
//import java.lang.Math;
/**
 *
 * @author Natalia Solar
 */
public class Circle extends BasicShape implements Cloneable{
    
    private int centerX; //to hold x coordinate of the circle’s center.
    private int centerY; //to hold y coordinate of the circle’s center.
    private int radius; //to hold the radius of the circle.
    
    /**
     * Non-argument constructor that sets all variables to 1 and color to black
     */
    public Circle(){
        super();
        centerX = 1;
        centerY =1; 
        radius =1;
        for (int i=0;i<3;i++){
            color[i]=0;
        }
    }
    
    /**
     * Constructor – accepts values for centerX, centerY, radius, and color as an array of 3 integers
     * @param centerX x coordinate of the circle’s center
     * @param centerY y coordinate of the circle’s center
     * @param radius the radius of the circle
     * @param array an array of 3 integers that are representing Red, Green, and Blue components in the color
     * @throws IllegalArgumentException when radius is not a positive number or the array must is not exactly 3 
     * elements long or not all values in the array must be in the range 0 – 255
     */
    public Circle(int centerX, int centerY, int radius, int[] array)throws IllegalArgumentException{
        
        if(radius<=0) throw new IllegalArgumentException("Radius must be positive.");
        if(array.length!=3) throw new IllegalArgumentException("The array should be 3 elements long.");
        for(int i=0; i<array.length; i++){
            if(array[i]<0 || array[i]>255) throw new IllegalArgumentException("All values in the array must be in the range 0 – 255 as they represent colors.");
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        for(int i=0; i<array.length; i++){
            color[i] = array[i];
        }
    }
    
    /**
     * Accessor for centerX field
     * @return the value of centerX field
     */
    public int getCenterX(){
        return centerX;
    }
    
    /**
     * Accessor for centerY field
     * @return the value of centerY field
     */
    public int getCenterY(){
        return centerY;
    }
    
    /**
     * Accessor for radius field
     * @return the value of radius field
     */
    public int getRadius(){
        return radius;
    }
    
    /**
     * Mutator for centerX field
     * @param centerX the value to be set
     */
    public void setCenterX(int centerX){
        this.centerX = centerX;
    }
    
    /**
     * Mutator for centerY field
     * @param centerY the value to be set
     */
    public void setCenterY(int centerY){
        this.centerY = centerY;
    }
    
    /**
     * Mutator for radius field
     * @param radius the value to be set
     */
    public void setRadius(int radius){
        this.radius = radius;
    }
    
    /**
     * Method that calculates and returns the area of the circle
     * @return the area of the circle
     */
    public double calcArea(){
        return Math.PI*radius*radius;
    }
    
    /**
     * Method that creates and returns a string containing information about the circle
     * @return a text containing information about the circle
     */
    @Override public String toString(){
        return "Circle's area: " + calcArea()+ "\n"+ "RGB color components:("+color[0]+", "+color[1]+", "+color[2]+")\n" + 
                "X coordinate of the circle’s center: " + centerX +"\n"+ 
                "Y coordinate of the circle’s center: " + centerY + "\n"+ "Radius: " + radius+ "\n";
    }
    
    /**
     * Method that makes a copy of an object
     * @return the copy of a Circle object
     */
    @Override public Circle clone()
    {
        try{
        Circle objCopy = (Circle)super.clone();
        centerX = objCopy.centerX;
        centerY = objCopy.centerY;
        radius = objCopy.radius;
        return objCopy; 
        }catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
    
}
