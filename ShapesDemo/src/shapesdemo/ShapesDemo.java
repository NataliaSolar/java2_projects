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
public class ShapesDemo {

    /**
     * Method that prints out three shapes ordered by the size of the area from smallest to largest.
     * @param one first BasicShape object
     * @param two second BasicShape object
     * @param three third BasicShape object
     */
    public static void orderShapes (BasicShape one, BasicShape two, BasicShape three){
        
        BasicShape smallest = null; //to hold a reference to a smallest shape
        BasicShape midsized = null; //to hold a reference to a midsized shape
        BasicShape largest = null; //to hold a reference to a largest shape

       
        //find the smallest, largest and midsized shapes
        if (one.isLess(two)){ 
            smallest = one;
            if(two.isLess(three)){
               midsized = two; largest = three;
            } else {
                if(one.isLess(three)){
                    midsized = three; largest = two; 
                }else{
                    smallest = three; midsized = one; largest = two;
                }
            }
        }else{//one.isGreater(two)
            smallest = two;
            if(two.isLess(three)){
                if(one.isLess(three)){
                    midsized = one; largest = three;
                }else{
                    midsized = three; largest = one;
                }
            }else{
                smallest = three; midsized = two; largest = one;
            }
        }    
        //print out three shapes ordered by the size of the area from smallest to largest
        if(midsized.equals(smallest)) System.out.println("--The smallest shape\n" + smallest.toString() + "--The midsized shape (has same area as the smallest)\n"  + midsized.toString() +
                "--The largest shape\n"  + largest.toString());
        else if(midsized.equals(largest)) System.out.println("--The smallest shape\n" + smallest.toString() + "--The midsized shape (has same area as the largest)\n"  + midsized.toString() +
                "--The largest shape\n"  + largest.toString());
        else System.out.println("--The smallest shape\n" + smallest.toString() + "--The midsized shape\n"  + midsized.toString() +
                "--The largest shape\n"  + largest.toString());
          
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            int[] colorArray = {2,3,4}; //set an array that represents shapes color
            //create Circle and Rectangle objects
            BasicShape circle_1 = new Circle(1, 2, 5, colorArray);
            BasicShape circle_2 = new Circle(1, 2, 2, colorArray);
            BasicShape rectangle_1 = new Rectangle(1, 4, colorArray);
            BasicShape rectangle_2 = new Rectangle(1, 4, colorArray);

            orderShapes(circle_1,circle_2,rectangle_1);

            System.out.println("______________");

            orderShapes(circle_1,rectangle_1,rectangle_2);

            System.out.println("______________");

            //testing constructors
            System.out.println("Testing constructors:");

            //create a Circle object calling on non-argument constructor
            Circle test_circle =  new Circle();
            System.out.println(test_circle.toString());

            //create a Circle object producing exceptions
            //Circle test_circleEx =  new Circle(1, 1, -1, colorArray );
            /*
            int[] colorArrayEx = {2,3,4,5};
            Circle test_circleEx =  new Circle(1, 1, 1, colorArrayEx );
            */
            /*
            int[] colorArrayEx = {-1,256,4};
            Circle test_circleEx =  new Circle(1, 1, 1, colorArrayEx );
            */

            //create a Rectangle object calling on non-argument constructor
            Rectangle test_rectangle =  new Rectangle();
            System.out.println(test_rectangle.toString());
            
            //create a Rectangle object producing exceptions
            //Rectangle test_rectangleEx =  new Rectangle(-3, 1, colorArray);

            System.out.println("Testing mutator and accessor methods:");
            //testing mutator methods
            test_circle.setColor(colorArray);
            test_circle.setCenterX(5);
            test_circle.setCenterY(10);
            test_circle.setRadius(7);

            test_rectangle.setCornerX(3);
            test_rectangle.setCornerY(3);
            test_rectangle.setWidth(5);
            test_rectangle.setLength(5);

            //get color for test_circle and test_rectangle objects 
            int[] getColor_cir = test_circle.getColor();
            int[] getColor_rect = test_rectangle.getColor();

            //check if recieved data matches 
            if (("Circle's area: " + test_circle.calcArea()+ "\n"+ "RGB color components:("+getColor_cir[0]+", "+getColor_cir[1]+", "+getColor_cir[2]+")\n" + 
                    "X coordinate of the circle’s center: " + test_circle.getCenterX() +"\n"+ 
                    "Y coordinate of the circle’s center: " + test_circle.getCenterY() + "\n"+
                    "Radius: " + test_circle.getRadius()+ "\n").equals(test_circle.toString())){
                System.out.println("Test for Circle object passed");
                System.out.println("Changed Circle object:\n" + test_circle.toString()+"\n");
            } else System.out.println("Test failed.");

            if (("Rectangle's area: " + test_rectangle.calcArea()+ "\n"+ "RGB color components:("+getColor_rect[0]+", "+getColor_rect[1]+", "+getColor_rect[2]+")\n" + 
                    "X coordinate of the rectangle’s left upper corner: " + test_rectangle.getCornerX() +"\n"+ 
                    "X coordinate of the rectangle’s left upper corner: " + test_rectangle.getCornerY() + "\n"+ 
                    "Width: " + test_rectangle.getWidth() + "\n"+ "Length: " + test_rectangle.getLength()+ "\n").equals(test_rectangle.toString())){
                System.out.println("Test passed for Rectangle passed");
                System.out.println("Changed Rectangle object:\n" + test_rectangle.toString()+"\n");
            } else System.out.println("Test failed.");


            //testing clone methods
            System.out.println("Testing clone methods:");
            //create a copy of test_circle
            Circle test_circleCopy =  test_circle.clone();
            System.out.println("\nCopy of the test_circle Circle object created:\n" + test_circleCopy.toString()+"\n");
            //create a copy of test_rectangle
            Rectangle test_rectangleCopy =  test_rectangle.clone();
            System.out.println("\nCopy of the test_rectangle Rectangle object created:\n" + test_rectangleCopy.toString()+"\n");

            //testing equals method.
            if(test_circle.equals(test_circleCopy)){
                System.out.println("Testing equals method for Circle objects.\n" + "Objects are equal: " + test_circle.equals(test_circleCopy));
                System.out.println("Test Passed.");
            }else System.out.println("Testing equals method. Test failed.");
            System.out.println();
            if(test_rectangle.equals(test_rectangleCopy)){
                System.out.println("Testing equals method for Rectangle objects.\n" + "Objects are equal: " + test_rectangle.equals(test_rectangleCopy));
                System.out.println("Test Passed.");
            }else System.out.println("Testing equals method. Test failed.");
        }catch (IllegalArgumentException e){
            System.out.println("Exception caught! " + e.getMessage());
        }
    }
    
}
