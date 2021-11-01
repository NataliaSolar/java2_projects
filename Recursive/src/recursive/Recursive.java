/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursive;

import java.util.Random;

/**
 *
 * @author Natalia Solar
 */
public class Recursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            //Testing productOfEvens(n) method
            System.out.println("Testing productOfEvens(n) method:");
            int temp = 1;
            //create test cases, no exception expected
            for(int n=1; n<5; n++){
                //call on the method
                int test_1 = productOfEvens(n);
                System.out.println("n = " + n + "; " + "productOfEvens = " + test_1);
                //check if the result is correct by culculating without recursion and comparing the results
                temp = temp * 2*n;  
                //System.out.println(temp);
                if(test_1 == temp) System.out.println("passed");
                else System.out.println("failed");
            }

            //create test case that produses an exception
            /*
            int test_ex = productOfEvens(0);
            System.out.println("n = " + 0 + "; " + "productOfEvens = " + test_ex);
            */
            
            
            //Testing recArraySum(int[] nums, int i) method
            System.out.println("\nTesting recArraySum(int[] nums, int i) method:");
            //create an array of integers
            int[] test_arr = new int[10];
            System.out.print("Given array: {");
            for (int i=0; i<10; i++){
                test_arr[i] = i+1;
                System.out.print(test_arr[i] + " ");
            }
            System.out.print("}\n");
            //create test cases
            for(int t=3; t<=6; t++){
                //call on the method
                int test_2 = recArraySum(test_arr, t);
                System.out.println("index = "+ t +"; recArraySum = " + test_2);
                //check the result by calculating the sum without recursion
                temp = 0;
                for (int i = 0; i<=t; i++){
                    temp = temp + test_arr[i];
                }
                if(test_2 == temp) System.out.println("passed");
                    else System.out.println("failed");
            }
            
            
            //Testing recSelectionSort(int[] nums) method
            System.out.println("\nTesting recSelectionSort(int[] nums) method:");
            //create an array
            System.out.print("Given array: {");
            int[] sort_test = new int[10];
            for (int i=0; i<10; i++){
                Random randomNumber = new Random();//set up an object to generate random nubmers
                sort_test[i] = randomNumber.nextInt(16); // generate random numbers
                System.out.print(sort_test[i] + " ");
            }
            System.out.print("}\n");
            //call on method
            recSelectionSort(sort_test);
            System.out.print("Sorted array: {");           
            for (int i=0; i<sort_test.length; i++){
                System.out.print(sort_test[i] + " ");
            }
            System.out.print("}\n");
            
            //testing if method works with one element array
            sort_test = new int[1];
            sort_test[0]=1;
            System.out.println("\nGiven array: {" + sort_test[0] + "}");
            recSelectionSort(sort_test);
            System.out.println("Sorted array: {"+ sort_test[0]+ "}" );
            
            //testing if method works with an array of 2 elements
            sort_test = new int[2];
            sort_test[0]=8;
            sort_test[1]=7;
            System.out.println("\nGiven array: {" + sort_test[0]+", " +sort_test[1] + "}");
            recSelectionSort(sort_test);
            System.out.println("Sorted array: {"+ sort_test[0]+ ", " +sort_test[1]+"}" );
            
            //testing if method works with an array of 2 elements
            sort_test = new int[3];
            sort_test[0]=9;
            sort_test[1]=7;
            sort_test[2]=1;
            System.out.println("\nGiven array: {" + sort_test[0]+", " +sort_test[1] + ", " +sort_test[2] +"}");
            recSelectionSort(sort_test);
            System.out.println("Sorted array: {"+ sort_test[0]+ ", " +sort_test[1]+ ", " +sort_test[2] +"}" );
            
            
            //Testing countDigitMatches(int n1, int n2) method
            System.out.println("\nTesting countDigitMatches(int n1, int n2) method:");
            int n1 =  41357975;
            int n2 = 542352945;
            //call on method, expected output: 5
            int count  = countDigitMatches(n1,n2);
            if (count == 5) System.out.println("\nn1 =  41357975;\nn2 = 542352945;\nThe number of digits that match = " +count);
            else System.out.println("test failed");
            
            n1 = 1072503891;
            n2 =   62530841;
            //expected output: 4
            count  = countDigitMatches(n1,n2);
            if (count == 4) System.out.println("\nn1 = 1072503891;\nn2 =   62530841;\nThe number of digits that match = " +count);
            else System.out.println("test failed");
            
            n1 = 2;
            n2 = 2;
            //expected output: 1
            count  = countDigitMatches(n1,n2);
            if (count ==1) System.out.println("\nn1 = 2;\nn2 = 2;\nThe number of digits that match = " +count);
            else System.out.println("test failed");
            
            n1 = 234567;
            n2 = 765432;
            //expected output: 0
            count  = countDigitMatches(n1,n2);
            if (count ==0) System.out.println("\nn1 = 234567;\nn2 = 765432;\nThe number of digits that match = " +count);
            else System.out.println("test failed");
            
            /*
            n1 = -234567;
            n2 = 765432;
            //expected output: Exception
            count  = countDigitMatches(n1,n2);
            if (count ==0) System.out.println("\nn1 = 234567;\nn2 = 765432;\nThe number of digits that match = " +count);
            else System.out.println("test failed");
            */
            
            //Testing generatePattern(int n) method
            System.out.println("\nTesting generatePattern(int n) method:");
            for (int i=1; i<=10; i++){
                System.out.println("generatePattern(" +i+") = "+generatePattern(i));
            }
            
            //Exception
            //System.out.println("generatePattern(0) = "+generatePattern(0));

        }catch(IllegalArgumentException e){
            System.out.println("Exception caugth! " + e.getMessage());
        }
        
    }
    
    /**
     * Recursive method that returns the product of the first n even integers
     * @param n first n even integers
     * @return the product of the first n even integers
     * @throws IllegalArgumentException if the value of argument passed to it is less than or equal to 0
     */
    public static int productOfEvens(int n) throws IllegalArgumentException{
        
        if(n<=0) throw new IllegalArgumentException("Argument passed to the method must not be less than or equal to 0");
        if (n == 1)
            return 2;   // Base case
        else
            return 2*n * productOfEvens(n - 1);
    }
    
    /**
     * Recursive method that accepts an array of integers and an index i and 
     * returns the sum of all elements of that array up to and including element with the index i
     * @param nums an array of integers
     * @param i the index of the element
     * @return the sum of all elements of that array up to and including element with the index i
     */
    public static int recArraySum(int[] nums, int i){
        
        if (i == 0)
            return nums[i];   // Base case
        else
            return nums[i] + recArraySum(nums, (i - 1));
        
    }
    
    /**
     * Recursive method that sorts an array in ascending order
     * @param nums an array of integers that going to be sorted
     * @param i starting index number
     */
    public static void recSelectionSortTmp(int[] nums, int i){
                
        if (i+1 == nums.length) return;//base case
        else{
            // Find index of smallest remaining element
            int indexSmallest = i;
            for (int j = i + 1; j < nums.length; ++j) {
    
                if (nums[j] < nums[indexSmallest]) {
                    indexSmallest = j;
                }
            }    
            // Swap numbers[i] and numbers[indexSmallest]
            int temp = nums[i];
            nums[i] = nums[indexSmallest];
            nums[indexSmallest] = temp;
            
            recSelectionSortTmp(nums, i+1);
            }                
    }
    
    /**
     * Method that calls recSelectionSortTmp method
     * @param nums an array of integers
     */
    public static void recSelectionSort(int[] nums){
        recSelectionSortTmp(nums, 0);
    }
    
    /**
     * Recursive method that accepts two strings as parameters and returns the 
     * number of digits that match between them. Two digits match if they are equal 
     * and have the same position relative to the end of the number.
     * @param str1 first integer to be compared converted to a string
     * @param str2 second integer to be compared converted to a string
     * @param i integer that represents the length of the first integer
     * @param j integer that represents the length of the second integer
     * @return the number of digits that match
     */
    public static int countDigitMatchesTmp(String str1, String str2,int i, int j){

        if (i-1<0 || j-1<0) return 0;//base case
        else{
            //compare characters
            if (str1.charAt(i-1)== str2.charAt(j-1))return 1 + countDigitMatchesTmp(str1,str2, i-1, j-1);
            else return countDigitMatchesTmp(str1,str2, i-1, j-1);
        }
    }
    
    /**
     * Method that accepts two non-negative integers as parameters and call on countDigitMatchesTmp method
     * @param n1 first integer to be compared
     * @param n2 second integer to be compared
     * @return the call on countDigitMatchesTmp method
     * @throws IllegalArgumentException when passed arguments are negative
     */
    public static int countDigitMatches(int n1, int n2) throws IllegalArgumentException{
        if (n1<=0 || n2<=0) throw new IllegalArgumentException("Parameters must not be negative.");
        //convert numbers to strings
        String str1 = Integer.toString(n1);
        String str2 = Integer.toString(n2);
        return countDigitMatchesTmp(str1, str2, str1.length(), str2.length());
    }
    

    /**
     * Recursive method that accepts an integer n as a parameter and returns a 
     * string containing a symmetric sequence of n numbers
     * @param n number of digits in a symmetric sequence
     * @return string containing a symmetric sequence of n numbers
     * @throws IllegalArgumentException a value less than 1 is passed as an argument.
     */
    public static String generatePattern(int n) throws IllegalArgumentException{
        
        if(n<1) throw new IllegalArgumentException("Value must not be less than 1");
        if(n==1)return "1"; //base case
        else if(n==2) return "11";
        
        else{
            if(n%2==1) return (n/2 +1) + generatePattern(n-2)+(n/2 +1);
            else return (n/2) + generatePattern(n-2)+(n/2);
        }
    } 
}
