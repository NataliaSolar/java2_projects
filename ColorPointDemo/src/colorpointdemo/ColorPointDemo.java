/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorpointdemo;

import java.io.*;           // Needed for File I/O classes
import java.util.ArrayList; //to use arrayLists
import java.util.Random;    // to generate random nubmers

/**
 *
 * @author Natalia Solar
 */
public class ColorPointDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //use try/catch block to handle exceptions
        try{
            //testing constructors
            System.out.println("Testing non-argument constructor:\n");

            //call on non-argument constructor
            ColorPoint testPoint_1 = new ColorPoint();
            if (testPoint_1.getR()==0 && testPoint_1.getG()==0 && testPoint_1.getB()==0 &&
                    testPoint_1.getX()==0 && testPoint_1.getY()==0){
                System.out.println("Test passed.");
                System.out.println(testPoint_1.toString());
            }else System.out.println("Test failed.\n");
            
            System.out.println("\nTesting constructor that accepts parameters:\n");
            //call on constructor that accepts parameters, no exceptions expected
            //set parameters:
            int x = 3;
            int y = 4;
            int color_1 = 100;
            int color_2 = 35;
            ColorPoint testPoint_2 = new ColorPoint(x, y, color_1, color_1, color_2);
            if (testPoint_2.getR()==color_1 && testPoint_2.getG()==color_1 && testPoint_2.getB()==color_2 &&
                    testPoint_2.getX()==x && testPoint_2.getY()==y){
                System.out.println("Test passed.");
                System.out.println( testPoint_2.toString());
            }else System.out.println("Test failed.");
            
            //call on constructor that accepts parameters, exceptions expected
            //set parameters:
            /*
            x = 10;
            y = 30;
            color_1 = -1;
            color_2 = 256;
            ColorPoint testPointExcep = new ColorPoint(x, y, color_1, color_1, color_2);
            if (testPointExcep.getR()==color_1 && testPointExcep.getG()==color_1 && testPointExcep.getB()==color_2 &&
                    testPointExcep.getX()==x && testPointExcep.getY()==y){
                System.out.println("Test passed.");
                System.out.println(testPointExcep.toString());
            }else System.out.println("Test failed.");
            */
            
            //testing mutators
            System.out.println("\nTesting mutator methods:\n");
            
            //set values:
            x = 50;
            y = 15;
            color_1 = 77;
            color_2 = 145;
            //call on setXY(int x, int y), no exceptions expected
            testPoint_1.setXY(x, y);
            if (testPoint_1.getX()==x && testPoint_1.getY()==y){
                System.out.println("setXY(int x, int y) method test passed.");
                System.out.println( "New values are set:\n"+ testPoint_1.toString());
            }else System.out.println("Test failed.");
            
            //call on setRGB(int r, int g, int b), no exceptions expected
            testPoint_1.setRGB(color_1, color_2 ,color_2);
            if (testPoint_1.getR()==color_1 && testPoint_1.getG()==color_2 && testPoint_1.getB()==color_2){
                System.out.println("\nsetRGB(int r, int g, int b)method test passed.");
                System.out.println( "New values are set:\n"+ testPoint_1.toString());
            }else System.out.println("Test failed.");
            
            //call on setRGB(int r, int g, int b), exceptions expected
            //set new values to RGB
            /*
            color_1 = 145;
            color_2 = 256;
            testPoint_1.setRGB(color_1, color_2 ,color_2);
            if (testPoint_1.getR()==color_1 && testPoint_1.getG()==color_2 && testPoint_1.getB()==color_2){
                System.out.println("setRGB(int r, int g, int b)method test passed.");
                System.out.println( "New values are set:\n"+testPoint_1.toString());
            }else System.out.println("Test failed.");
            */
            
            //testing equals method
            System.out.println("\nTesting equals method:");
            
            //create manually a copy of testPoint_1 
            ColorPoint copy = new ColorPoint(50, 15, 77, 145, 145);
            
            //call on equals() method
            if(copy.equals(testPoint_1)){
                System.out.println("Test passed.");
                System.out.println("testPoint_1 object and copy object are equal: " +copy.equals(testPoint_1) );
            }else System.out.println("Test failed.");
            
            
            System.out.println("\n______________________________\nColorPoint Class and Binary File I/O\n_____________________________\n");
            
            //create an array of ColorPoint objects of size 10
            ColorPoint[] points = new ColorPoint[10];
            int rRandom = 0;    //to hold random value for red component of RGB
            int gRandom = 0;    //to hold random value for green component of RGB
            int bRandom = 0;    //to hold random value for blue component of RGB
            int xRandom = 0;    //to hold random value for x coordinate
            int yRandom = 0;    //to hold random value for y coordinate
            
            for (int i =0; i<points.length; i++){
                Random randomNumber = new Random();//set up an object to generate random nubmers
                rRandom = randomNumber.nextInt(256); // generate random numbers
                gRandom = randomNumber.nextInt(256);
                bRandom = randomNumber.nextInt(256);
                yRandom = randomNumber.nextInt(10);
                xRandom = randomNumber.nextInt(10);
                points[i] = new ColorPoint();       //populate the array with the ColorPoint object
                points[i].setRGB(rRandom, gRandom, bRandom); //set RGB
                points[i].setXY(xRandom, yRandom); //set x and z
            }
            //call on writeColorPointArray method
            writeColorPointArray("colorPoints.dat", points);
            //call on readColorPointArray method
            ColorPoint[] readArray = readColorPointArray("colorPoints.dat");
            //display read data into the screen
            System.out.println("Data from the file:");
            for (int i =0; i<readArray.length; i++){
                System.out.println((i+1) + ". Object\n" + readArray[i].toString());
            }
            
        }catch (InvalidRgbException e){
            System.out.println("Exception caught! " + e.getMessage());
        
        }
        catch (IOException e){
            System.out.println("Exception caught! " + e.getMessage());
        }
    }
    
    /**
     *Method that reads the contents of a binary file and places it into an array of objects of type ColorPoint.
     * @param fileName the name of the file to read from
     * @return an array of objects of type ColorPoint read from the file
     * @throws IOException when method fails to read the file
     */
    public static ColorPoint[] readColorPointArray(String fileName) throws IOException{
        
        ArrayList<ColorPoint> points = null; //ArrayList to store data from the file
        try{
            // Create the stream objects.
            FileInputStream inStream = new FileInputStream(fileName);
            ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
            System.out.println("\nReading from the " + fileName);
            try{
                
                // Allocate a new empty arrayList of type ColorPoint
                points = new ArrayList<>();
                while(true){
                        // Read the serialized objects from the file and store in the array list                    
                        points.add((ColorPoint)objectInputFile.readObject());      
                }
                
            }catch(EOFException e)
            {
                System.out.println("No more numbers in the file."); 
            }
            // Close the file.
            objectInputFile.close();
            //convert arrayLiist into an array and return it
            return points.toArray((new ColorPoint[points.size()]));             
        }catch (ClassNotFoundException e){
            System.out.println("Exception caught! " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Method that writes the contents of the given array into the given binary file.
     * @param fileName the name of the given binary file
     * @param points an array that needs to be written to the file
     * @throws IOException when method fails to write the file
     */
    public static void writeColorPointArray(String fileName, ColorPoint[] points)throws IOException{
        
       // Create the stream objects.
      FileOutputStream outStream = 
                new FileOutputStream(fileName);
      ObjectOutputStream objectOutputFile = 
                new ObjectOutputStream(outStream);
      
      System.out.println("Writing to the " +fileName+ " file.");
      // Write the serialized objects to the file.
      for (int i = 0; i < points.length; i++)
      {
         objectOutputFile.writeObject(points[i]);
      }
      
      // Close the file.
      objectOutputFile.close();
      
      System.out.println("The serialized objects were written to the file.");   
    }
    
}
