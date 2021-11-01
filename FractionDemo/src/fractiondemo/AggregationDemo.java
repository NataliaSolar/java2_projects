/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractiondemo;

/**
 *
 * @author AV
 */
public class AggregationDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       AggregationSample first = new AggregationSample();
       if(first.toString().equals("Fraction: 0; Array: [0,0,0]; Double: 0.0"))
       {
           System.out.println("Test 1 passed");
           System.out.println(first.toString()); // Output "Fraction: 0; Array: [0,0,0]; Double: 0.0"
       }
       else System.out.println("Test 1 failed");
       int[] a = {1, 2, 3, 4};
       Fraction f = new Fraction(1, 2);
       AggregationSample second = new AggregationSample(f, a, 5.6);
       if(second.toString().equals("Fraction: 1/2; Array: [1,2,3,4]; Double: 5.6")) 
       {       
           System.out.println("Test 2 passed");
           System.out.println(second.toString()); // Output "Fraction: 1/2; Array: [1,2,3,4]; Double: 5.6"       
       }
       else System.out.println("Test 2 failed");
       // these changes to original objects must not change the "second" object
       a[0] = 100;
       f.setNum(5);
       if(second.toString().equals("Fraction: 1/2; Array: [1,2,3,4]; Double: 5.6")) 
       {       
           System.out.println("Test 3 passed");
           System.out.println(second.toString()); // Output "Fraction: 1/2; Array: [1,2,3,4]; Double: 5.6"       
       }
       else System.out.println("Test 3 failed");
       int[] b = second.getArray();      
       b[0] = 300;// change the array to make sure the copy of the field was returned
       Fraction f2 = second.getFraction();
       f2.setNum(3); // change the fraction to make sure the copy of the field was returned
       double k = second.getDouble();
       if(second.toString().equals("Fraction: 1/2; Array: [1,2,3,4]; Double: 5.6"))
       {
           System.out.println("Test 4 passed");
           System.out.println(second.toString());// Output must be as before "Fraction: 1/2; Array: [1,2,3,4]; Double: 5.6"
       }
       else System.out.println("Test 4 failed");
       
       first.setArray(b);
       b[0] = 0; // change the original array to make sure the deep copy was made
       first.setFraction(f2);
       f2.setNum(7); // change original fraction to make sure the deep copy was made
       first.setDouble(33.3);
       if(first.toString().equals("Fraction: 1 and 1/2; Array: [300,2,3,4]; Double: 33.3"))
       {
           System.out.println("Test 5 passed");
           System.out.println(first.toString());// Output must be as before "Fraction: 1/2; Array: [1,2,3,4]; Double: 5.6"
       }
       else System.out.println("Test 5 failed");      
    }
    
}

