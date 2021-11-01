/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberanalyzerdemo;

import java.util.Random;

/**
 *
 * @author Natalia Solar
 */
public class NumberAnalyzerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create an array of integers
        Integer[] intArray = new Integer[10];
        for(int i = 0; i<intArray.length; i++){
            Random randomNumber = new Random();//set up an object to generate random nubmers
            int num = randomNumber.nextInt(100) + 1; // generate random number
            intArray[i] = num;
        }
        //test NumberAnalyzer with Integer base type
        NumberAnalyzer<Integer> intArrayTest= new NumberAnalyzer<>(intArray);
        
        System.out.println("Given array of integers:");
        intArrayTest.printArray();
        
        System.out.println("The highest value: " + intArrayTest.findHighest());
        System.out.println("The lowest value: " + intArrayTest.findLowest());
        System.out.println("Total: " + intArrayTest.getTotal());
        System.out.println("Average: " + intArrayTest.getAverage());
        
        //create an array of integers
        Double[] doubleArray = new Double[10];
        for(int i = 0; i<doubleArray.length; i++){
            double num = Math.random()*(100)+1;
            doubleArray[i] = num;
        }
        //test NumberAnalyzer with Double base type
        NumberAnalyzer<Double> doubleArrayTest= new NumberAnalyzer<>(doubleArray);
        
        System.out.println("\nGiven array of doubles:");
        doubleArrayTest.printArray();
        
        System.out.println("The highest value: " + doubleArrayTest.findHighest());
        System.out.println("The lowest value: " + doubleArrayTest.findLowest());
        System.out.println("Total: " + doubleArrayTest.getTotal());
        System.out.println("Average: " + doubleArrayTest.getAverage());
    }
    
}
