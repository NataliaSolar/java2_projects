/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionclasswork;

/**
 *
 * @author Natalia
 */
public class RecursionClasswork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //classwork
            writeChar(1);
            System.out.println("");
            writeChar(2);
            System.out.println("");
            writeChar(3);
            System.out.println("");
            writeChar(4);
            System.out.println("");
            writeChar(5);
            System.out.println("");
            writeChar(6);
            System.out.println("");
            

            printPattern(8);
            System.out.println("");
            
            printSequence(5);
            System.out.println("");
            
            double r=  pow(2, 2);
            System.out.println(r);
            
            
            printSquares(3);
            
            
    }
    //from quiz prep
    public static void writeChar(int k ){
            
        if(k<=0) throw new IllegalArgumentException("Value must be positive");
        if(k==1)System.out.print("*"); //base case
        else if(k==2)System.out.print("**");
        
        else{
            System.out.print("<");
            writeChar(k-2);
            System.out.print(">");
        }
        
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
    }
    
    
    
    
    //printPattern(1) = 1; printPattern(2) = 212; printPattern(3) = 32123
    public static void printPattern(int k ){
            
        if(k<=0) throw new IllegalArgumentException("Value must be positive");
        if(k==1)System.out.print("1"); //base case        
        
        else{
            System.out.print(k);
            printPattern(k-1);
            System.out.print(k);
        }
    }
    
    public static String buildPattern(int k ){
            
        if(k<=0) throw new IllegalArgumentException("Value must be positive");
        if(k==1)return "1"; //base case        
        
        else{
            return k+ buildPattern(k-1)+k;
        }
    }
    
    //printPattern(3) = 313; printPattern(4) = 42124; printPattern(5) = 53135
    
    //printSequence(5) prints  1 2 3 4 5 4 3 2 1
    public static void printSequence(int k){
        printSequenceTmp(1,k);
    }
    public static void printSequenceTmp(int k, int limit){
        
        if(k == limit) System.out.print(k);
        else{
            System.out.print(k);
            printSequenceTmp(k+1, limit);
            System.out.print(k);
        }
        
    }
    
    public static double pow(int base, int exp){
       
        if (exp == 0) return 1;
        else{
            return base*pow(base, exp-1);
        }        
    }
    
    public static void printSquares(int n){
        if (n==0 ) return;
        else{
            printSquares(n-1);
            System.out.print(n*n + " ");
        }
    }
    
    /**
     * Recursive method that accepts two integers as parameters and returns the 
     * number of digits that match between them. Two digits match if they are equal 
     * and have the same position relative to the end of the number.
     * @param n1 first integer to be compared
     * @param n2 second integer to be compared
     * @param i integer that represents the length of the first integer
     * @param j integer that represents the length of the second integer
     * @return the number of digits that match
     */
    public static int countDigitMatchesTmp(String str1, String str2,int i, int j){
        //convert inegers into strings
        //String str1 = Integer.toString(n1);
        //String str2 = Integer.toString(n2);
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
        String str1 = Integer.toString(n1);
        String str2 = Integer.toString(n2);
        return countDigitMatchesTmp(str1, str2, str1.length(), str2.length());
    }
}
