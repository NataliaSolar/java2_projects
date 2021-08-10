/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberanalyzerdemo;

/**
 *
 * @author Natalia Solar
 */
public class NumberAnalyzer <T extends Number>{
    
    private T[] array;
    
    /**
     * constructor that accept an array of objects of type T and sets array field
     * @param array an array of objects of type T
     */
    public NumberAnalyzer(T[] array){
        this.array = array;
    }
    
    /**
     * methods that finds the highest value in the array
     * @return the highest value
     */
    public T findHighest(){
        T highest = array[0];
        for (int i=0;i<array.length; i++)
        {
            if (array[i].doubleValue()>highest.doubleValue())
            {
                highest = array[i];
            }                
        }
        return highest;
    }
    
    /**
     * methods that finds the lowest value in the array
     * @return the lowest value
     */
    public T findLowest(){
        T lowest = array[0];        
        for (int i=0;i<array.length; i++)
        {
            if (array[i].doubleValue()<lowest.doubleValue())
            {
                lowest = array[i];               
            }                
        }
        return lowest;
    }
    
    /**
     * method that finds total of the elements of the array
     * @return the total
     */
    public double getTotal(){
        double total = 0;
        for(int i=0;i<array.length; i++){
            total += array[i].doubleValue();
        }
        return total;
    }
    
    /**
     * method that finds average of the elements of the array
     * @return the average
     */
    public double getAverage(){
        return getTotal()/array.length;
    }
    
    /**
     * Method that prints out the array
     */
    public void printArray()
    {
        for (int i=0;i<array.length; i++)
        {
            System.out.print(array[i] + " ");            
        }
        System.out.println();
    }
}
