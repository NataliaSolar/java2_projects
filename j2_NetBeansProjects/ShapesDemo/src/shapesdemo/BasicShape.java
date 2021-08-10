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
public abstract class BasicShape implements Relatable {
    
    protected int[] color = new int[3];//an array of 3 integers that are representing Red, Green, and Blue components in the color
    
    /**
     * Accessor for color field
     * @return copy of the field array
     */
    public int[] getColor(){
        //create a deep copy of the color field
        int[] arrayCopy = new int[3];
        for (int i=0;i<3;i++){
            arrayCopy[i]=color[i];
        }
        return arrayCopy;
    }
    
    /**
     * Mutator method for color field
     * @param array the array to be set
     * @throws IllegalArgumentException when array is not 3 elements long or array elements are not in the range [0;255]
     */
    public void setColor (int[] array ) throws IllegalArgumentException{
        if (array.length!=3) throw new IllegalArgumentException("The array should be 3 elements long.");
        //check if all the elements are in the needed range
        for(int i=0; i<array.length; i++){
            if(array[i]<0 || array[i]>255) throw new IllegalArgumentException("All values in the array must be in the range 0 – 255 as they represent colors.");
        }
    }
    
    /**
     * Abstract method that calculates area
     * @return area of a shape
     */
    public abstract double calcArea();
    
    /**
     * Method that compares the calling object to the argument object for equality
     * @param s object to be compared with
     * @return true if the calling object's area is equal to the argument's area
     */
    public boolean equals(BasicShape s){
       if (calcArea()==s.calcArea()) return true;
       return false;
    }
    
    /**
     * Method that determines whether the calling object is greater than the argument object
     * @param s object to be compared with
     * @return true if the calling object's area is greater than the argument's area
     */
    public boolean isGreater(BasicShape s){
       if(calcArea()>s.calcArea()) return true;
       return false;
    }
    
    /**
     * Method that determines whether the calling object is less than the argument object
     * @param s object to be compared with
     * @return true if the calling object's area is greater than the argument's area 
     */
    public boolean isLess(BasicShape s){
        if(calcArea()<s.calcArea()) return true;
        return false;
    }
    
}
