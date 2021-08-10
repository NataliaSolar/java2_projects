/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

import java.util.Scanner;

/**
 *
 * @author LWTECH
 */
public class GCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //adding two fractions 1/42 + 1/30 = ?
       	int num_one = 1; // numerator of the first fraction (1/42)
	int denom_one = 42; // denominator of the first fraction (1/42)
	int num_two = 1; // numerator of the second fraction (1/30)
	int denom_two = 30; // denominator of the second fraction (1/30)
	int num_sum; // numerator of the sum to be calculated
	int denom_sum; // denominator of the sum to be calculated
	
        // finding the greatest common divider of the denominators of the two fractions
        // in the case of our example the GCD of 42 and 30 is 6
        int common = denom_one > denom_two ? gcd(denom_one, denom_two) : gcd(denom_two, denom_one);
	int mult_one = denom_two / common; // finding the multiple for the first fraction, it is 5
	int mult_two = denom_one / common; // finding the multiple for the second fraction, it is 7
        
        // the two fractions are being added now: 1/42 + 1/30 = 12/210
	num_sum = num_one*mult_one + num_two*mult_two; 
	denom_sum = denom_one * mult_one;
        System.out.printf("%d/%d + %d/%d = %d/%d\n", num_one,denom_one, 
                                                   num_two, denom_two,
                                                   num_sum, denom_sum);
        // Simplifying the fraction 12/210.
        // Finding GCD of the numerator and denominator
        common = gcd(denom_sum, num_sum);
        denom_sum = denom_sum/common;
        num_sum = num_sum/common;
        System.out.printf("After simplification: %d/%d + %d/%d = %d/%d\n", num_one,denom_one, 
                                                   num_two, denom_two,
                                                   num_sum, denom_sum);
        
        
    }
    /**
     * This method implements Euclid's algorithm of calculation
     * of the greatest common divider (GCD) of two integers.
     * The algorithm has recursive nature:
     * GCD of x and y  with x > y is the same as GCD of y and (x % y )
     * (x= ky + x%y)
     * 
     * @param x first integer
     * @param y second integer
     * @return greatest common divider
     */
    public static int gcd(int x, int y)
    {
	do 
	{
		int tmp;
		tmp = y;
		y = x%y;
		x = tmp;
	}
	while(y>0);
	return x;
    }
}
