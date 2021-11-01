/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixedmulticatch;

import java.io.*;    // For File class and FileNotFoundException
import java.util.*;  // For Scanner and InputMismatchException

/**
 *
 * @author Natalia Solar
 */
public class FixedMultiCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int number;    // To hold a number from the file
        try{
            // Open the file.
            File file = new File("Numbers.txt");
            Scanner inputFile = new Scanner(file);

            // Process the contents of the file.
            while (inputFile.hasNext())
            {
                try{   
                    // Get a number from the file.
                    number = inputFile.nextInt();

                    // Display the number.
                    System.out.println(number);
                }catch(InputMismatchException ex){
                    //System.out.println("Skip");
                    inputFile.next();
                }
            }

            // Close the file.
            inputFile.close();
        }
        catch(FileNotFoundException ex)
        {
            // Display an error message.
            System.out.println("Error processing the file.");
        }
    }    
}
