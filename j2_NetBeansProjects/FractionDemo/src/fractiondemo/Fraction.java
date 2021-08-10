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
public class Fraction {
    
    //the num field will hold the fraction's numerator
    private int num;
    //the den field will hold the fraction's denominator
    private int den;
    
    /**
     * Constructor that sets the numerator and the denominator, checks if denominator 
     * is not a 0 and calls on simplify() method
     * @param num fraction's numerator
     * @param den fraction's denominator
     * @throws IllegalArgumentException when denominator is 0
     */
    public Fraction (int num, int den)throws IllegalArgumentException {
        
        if (den==0) throw new IllegalArgumentException("Denominator must not be a 0.");
        this.num = num;
        this.den = den;
        simplify();
    }
    
    /**
     * Constructor that represents mixed fraction. It sets the numerator and the denominator, 
     * checks if denominator is not a 0 and calls on simplify() method
     * @param wholePart the whole part of the mixed fraction
     * @param num fraction's numerator
     * @param den fraction's denominator
     * @throws IllegalArgumentException when denominator is 0
     */
    public Fraction (int wholePart, int num, int den) throws IllegalArgumentException{
        
        if (den==0) throw new IllegalArgumentException("Denominator must not be a 0."); 
        this.num = wholePart*den + num;
        this.den = den;
        simplify();
    }
    
    /**
     * Non-argument constructor that sets fraction's numerator to 0 and denominator to 1
     */
    public Fraction (){
        
        num = 0;
        den = 1;
    }
    
    /**
     * Copy constructor
     * @param obj object to be copied
     */
    public Fraction (Fraction obj){
        
        this.num = obj.num;
        this.den = obj.den;
        
    }
    
    /**
     * Accessor for num field
     * @return the value of the numerator (num)
     */
    public int getNum(){
       return num;
    }
    
    /**
     * Accessor for den field
     * @return the value of the denominator (den)
     */
    public int getDen(){
        return den;
    }
    
    /**
     * Mutator for the num field
     * @param num num value to be set
     */
    public void setNum(int num){
        this.num = num;
        simplify();
    }
    
    /**
     * Mutator for the den field
     * @param den den value to be set
     * @throws IllegalArgumentException when den is 0
     */
    public void setDen(int den) throws IllegalArgumentException{
        
        if (den==0) throw new IllegalArgumentException("Denominator must not be a 0.");
        else this.den = den;
        simplify();        
    }
    
    /**
     * This method implements Euclid's algorithm of calculation
     * of the greatest common divider (GCD) of two integers.
     * @param x first integer
     * @param y second integer
     * @return greatest common divider 
     */
    private int gcd(int x, int y)
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
        
    
    /**
     * Addition method
     * @param obj fraction to be added
     * @return a Fraction object that is the sum of two fractions
     */
    public Fraction add(Fraction obj){
        
        // finding the greatest common divider of the denominators of the two fractions
        int common = this.den > obj.den ? gcd(this.den, obj.den) : gcd(obj.den, this.den);
	int mult_this = obj.den / common; // finding the multiple for the first fraction
	int mult_obj = this.den / common; // finding the multiple for the second fraction
        
        // the two fractions are being added now
	int num_sum = this.num*mult_this + obj.num*mult_obj; 
	int den_sum = this.den * mult_this;
        Fraction sum = new Fraction(num_sum,den_sum);
        sum.simplify();
        
        return sum;
        
    }
    

    /**
     * Subtraction method.
     * @param obj fraction to be subtracted
     * @return a Fraction object that is the difference of two fractions
     */
    public Fraction subtract(Fraction obj){
        
        // finding the greatest common divider of the denominators of the two fractions
        int common = this.den > obj.den ? gcd(this.den, obj.den) : gcd(obj.den, this.den);
	int mult_this = obj.den / common; // finding the multiple for the first fraction
	int mult_obj = this.den / common; // finding the multiple for the second fraction
        
        // the two fractions are being subtracted now
	int num_diff = this.num*mult_this - obj.num*mult_obj; 
	int den_diff = this.den * mult_this;
        Fraction difference = new Fraction(num_diff,den_diff);
        difference.simplify();
        
        return difference;
    }
    
    /**
     * Method that simplifies the fraction as much as possible.
     */
    private void simplify(){
        
        // Finding GCD of the numerator and denominator
        int common = gcd(this.den, this.num);
        this.den = this.den/common;
        this.num = this.num/common;
    }
    
    /**
     * Multiplies two fractions then simplifies the result
     * @param obj fraction to be divided with
     * @return the result of multiplication
     */
    public Fraction multiply(Fraction obj){
       
        int mult_num = this.num*obj.num;
        int mult_den = this.den*obj.den;
        Fraction result = new Fraction(mult_num,mult_den);
        result.simplify();
       
        return result;
    }
    
    /**
     * Divides two fractions then simplifies the result
     * @param obj fraction to be divided with
     * @return the result of division
     */
    public Fraction divide(Fraction obj){
        
        int div_num = this.num*obj.den;
        int div_den = this.den*obj.num;
        Fraction result = new Fraction(div_num,div_den);
        result.simplify();
       
        return result;
    }
    
    /**
     * method that converts the fraction into a string.
     * @return fraction represented as a string
     */
    @Override public String toString(){
        
        if (this.num>this.den){
            int wholePart = (num - (num%den))/den;
            int mix_num = num%den;
            return wholePart + " and " + mix_num + "/" + den;
        } else if (this.num==this.den){
            return "1";
        }else if (this.num ==0){
            return "0";
        }else{
            return num + "/" + den;
        }
    }
    
    /**
     * Method that checks if the calling fraction object is smaller than the parameter object
     * @param obj fraction to be compared with
     * @return true if the calling fraction object is smaller than the parameter object
     */
    public boolean less(Fraction obj){
        
        // finding the greatest common divider of the denominators of the two fractions
        int common = this.den > obj.den ? gcd(this.den, obj.den) : gcd(obj.den, this.den);
	int mult_this = obj.den / common; // finding the multiple for the first fraction
	int mult_obj = this.den / common; // finding the multiple for the second fraction

        if (this.num*mult_this<obj.num*mult_obj)return true;
        return false;
    }
    
    /**
     * Method that checks if the calling fraction object is bigger than the parameter object
     * @param obj fraction to be compared with
     * @return true if the calling fraction object is bigger than the parameter object 
     */
    public boolean more(Fraction obj){
        
        // finding the greatest common divider of the denominators of the two fractions
        int common = this.den > obj.den ? gcd(this.den, obj.den) : gcd(obj.den, this.den);
	int mult_this = obj.den / common; // finding the multiple for the first fraction
	int mult_obj = this.den / common; // finding the multiple for the second fraction

        if (this.num*mult_this>obj.num*mult_obj)return true;
        return false;
    }
    
    /**
     * Method that checks if the calling fraction object is equal to the parameter object
     * @param obj fraction to be compared with
     * @return true if the calling fraction object is equal to the parameter object
     */
    public boolean equals(Fraction obj){
        
        // finding the greatest common divider of the denominators of the two fractions
        int common = this.den > obj.den ? gcd(this.den, obj.den) : gcd(obj.den, this.den);
	int mult_this = obj.den / common; // finding the multiple for the first fraction
	int mult_obj = this.den / common; // finding the multiple for the second fraction
        
        if (this.num*mult_this==obj.num*mult_obj)return true;
        return false;
    }
}
