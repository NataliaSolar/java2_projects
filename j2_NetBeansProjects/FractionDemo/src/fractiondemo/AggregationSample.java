/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractiondemo;

/**
 *
 * @author Natalia Solar
 */
public class AggregationSample {
    
    private Fraction fractionField;
    private int[] arrayField;
    private double doubleField;
    
    /**
     * Non-argument constructor
     */
    public AggregationSample(){
        
        fractionField = new Fraction();
        arrayField = new int[3];
        for (int i=0; i<arrayField.length; i++){
            arrayField[i] = 0;
        }
        doubleField = 0;
    }
    
    /**
     * Constructor that takes a fraction (as an object), 
     * an array, and a double as parameters and sets all 3 fields to the given values.
     * @param obj a fraction object to be set as a field value
     * @param array an array to be set as a field value
     * @param x a double to be set as a field value
     */
    public AggregationSample(Fraction obj, int[] array, double x){
        
        fractionField = new Fraction(obj);
        int[] copy = new int[array.length];
        for (int i=0; i<array.length; i++){
            copy[i] = array[i];
        }
        arrayField = copy;
        //for (int i=0; i<array.length; i++){
        //    arrayField[i] = array[i];
        //}
        doubleField = x;   
    }
    
    /**
     * Copy Constructor 
     * @param obj object to be copied from
     */
    public AggregationSample (AggregationSample obj){
        
        fractionField =  new Fraction(obj.fractionField);
        for (int i=0; i<obj.arrayField.length; i++){
            arrayField[i] = obj.arrayField[i];
        }
        doubleField = obj.doubleField;
    }
    
    /**
     * Accessor for the fractionField
     * @return fractionField value
     */
    public Fraction getFraction(){
        return new Fraction(fractionField);
    }
    
    /**
     * Accessor for the arrayField
     * @return arrayField copy
     */
    public int[] getArray(){
        int[] copy = new int[arrayField.length];
        for (int i=0; i<arrayField.length; i++){
            copy[i] = arrayField[i];
        }
        return copy;
    }
    
    /**
     * Accessor for the doubleField
     * @return doubleField value
     */
    public double getDouble(){
        return doubleField;
    }
    
    /**
     * Mutator for fractionField
     * @param obj fraction to be set
     */
    public void setFraction(Fraction obj){
        fractionField = new Fraction(obj);
    }
    
    /**
     * Mutator for arrayField
     * @param array array to be set
     */
    public void setArray(int [] array){
        int[] copy = new int[array.length];//allocate memory for the new array
        for (int i=0; i<array.length; i++){
            copy[i] = array[i];
        }
        arrayField = copy;
    }
    
    /**
     * Mutator for doubleField
     * @param x double to be set
     */
    public void setDouble(double x){
        doubleField = x;
    }
    
    /**
     * method that creates and returns a string containing all 3 fields in text format
     * @return all 3 fields in text format
     */
    @Override public String toString(){
        
        String fr_string = "Fraction: " + fractionField.toString();
        //convert array into a string
        String arr_string ="";
        for (int i = 0; i<arrayField.length;i++)
        {
            if (i!=arrayField.length-1) {           
                String element = Integer.toString(arrayField[i]) + ",";
                arr_string += element;
                
            } else{
                arr_string = arr_string + Integer.toString(arrayField[i]);
            }
        }        
        arr_string = "Array: " + "[" + arr_string +"]";
        //convert double into a string
        String doubl_string = "Double: " + Double.toString(doubleField);
        String text = fr_string + "; " + arr_string + "; " + doubl_string;
        return text;
    }

}
