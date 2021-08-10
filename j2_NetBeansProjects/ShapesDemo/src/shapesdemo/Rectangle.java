/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapesdemo;
/**
 *
 * @author Natalia Solar
 */
public class Rectangle extends BasicShape implements Cloneable{
        
    private int cornerX; //to hold x coordinate of the rectangle’s left upper corner.
    private int cornerY; //to hold y coordinate of the rectangle’s left upper corner.
    private int width; //to hold the width of the rectangle.
    private int length; //to hold the length of the rectangle.
    
    /**
     * Non-argument constructor that sets all variables to 1 and color to black
     */
    public Rectangle(){
        super();
        cornerX = 1;
        cornerY = 1; 
        width = 1;
        length = 1;
        for (int i=0;i<3;i++){
            color[i]=0;
        }
    }
    
    /*
    Constructor – accepts values for length, width, and color and sets fields.
o Throws IllegalArgumentException when width or length are not
positive numbers or color is null
    */
    /**
     * Constructor – accepts values for length, width, and color and sets fields.
     * @param wid width of the rectangle.
     * @param len length of the rectangle.
     * @param array array of 3 integers that are representing Red, Green, and Blue components in the color
     * @throws IllegalArgumentException 
     */
    public Rectangle(int wid, int len, int[] array) throws IllegalArgumentException {
        super();
        if (wid<=0 || len<=0) throw new IllegalArgumentException("Width and length must be positive.");
        if (array == null) throw new IllegalArgumentException("Color is null."); 
        width = wid;
        length = len;
        for (int i=0;i<3;i++){
            color[i]=array[i];
        }
    }
    
    /**
     * Accessor for cornerX field
     * @return 
     */
    public int getCornerX(){
        return cornerX;
    }
    
    /**
     * Accessor for cornerY field
     * @return 
     */
    public int getCornerY(){
        return cornerY;
    }
    
    /**
     * Accessor for width field
     * @return 
     */
    public int getWidth(){
        return width;
    }
    
    /**
     * Accessor for length field
     * @return 
     */
    public int getLength(){
        return length;
    }
    
    /**
      * Mutator for cornerX field
      * @param cornerX value to be set
      */
    public void setCornerX(int cornerX){
        this.cornerX = cornerX;
    }
    
    /**
      * Mutator for cornerY field
      * @param cornerY value to be set
      */
    public void setCornerY(int cornerY){
        this.cornerY = cornerY;
    }
    
    /**
     * Mutator for width field
     * @param width value to be set
     * @throws IllegalArgumentException when an argument passed to method is not positive
     */
    public void setWidth(int width)throws IllegalArgumentException{
        if (width<=0) throw new IllegalArgumentException("Width must be positive.");
        this.width = width;
    }
    
    /**
      * Mutator for length field
      * @param length value to be set
      * @throws IllegalArgumentException when an argument passed to method is not positive
      */
    public void setLength(int length)throws IllegalArgumentException{
        if (length<=0) throw new IllegalArgumentException("Length must be positive.");
        this.length = length;
    }
    
    /**
     * Method that calculates and returns the area of the rectangle
     * @return the area of the rectangle
     */
    public double calcArea(){
        return length*width;
    }
    
    /**
     * Method that creates and returns a string containing information about the rectangle
     * @return a text containing information about the rectangle
     */
    @Override public String toString(){
        return  "Rectangle's area: " + calcArea()+ "\n"+ "RGB color components:("+color[0]+", "+color[1]+", "+color[2]+")\n" + 
                "X coordinate of the rectangle’s left upper corner: " + cornerX +"\n"+ 
                "X coordinate of the rectangle’s left upper corner: " + cornerY + "\n"+ 
                "Width: " + width + "\n"+ "Length: " + length+ "\n";
    }
    
    /**
     * Method that makes a copy of an object
     * @return the copy of a Rectangle object
     */
    @Override public Rectangle clone()
    {
        try{
        Rectangle objCopy = (Rectangle)super.clone();
        objCopy.cornerX = cornerX;
        objCopy.cornerY = cornerY;
        objCopy.width = width;
        objCopy.length = length;
        return objCopy; 
        }catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
}
