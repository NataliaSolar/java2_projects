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
public class FractionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            //test #1, no exceptions expected, expected output: "a = 1/3"
            Fraction a = new Fraction(1,3);
            System.out.println("a = " + a.toString());
            if(a.toString().equals(a.getNum() + "/" + a.getDen())){
                
                System.out.println("test #1 passed");  
            }else{
                System.out.println("test #1 failed");
            }
            
            System.out.println("____________");
            
            //test #2, IllegalArgumentException expected
            /*
            Fraction z = new Fraction(1,0);
            System.out.println("z = " + z.toString());
            if(z.toString().equals(z.getNum() + "/" + z.getDen())){
                System.out.println("test #2 passed");  
            }else{
                System.out.println("test #2 failed");
            }
            System.out.println("test #2 passed");
            System.out.println("____________");
            */
            
            //test #3, no exceptions expected, expected output: "b = 1 and 2/7"
            Fraction b = new Fraction(1,2,7);           
            System.out.println("b = " + b.toString());
            int w_part = (b.getNum() - (b.getNum()%b.getDen()))/b.getDen();//find the whole part of mixed fraction
            String st = w_part + " and " + b.getNum()%b.getDen() + "/" + b.getDen();
            //if(compare(w_part + " and " + b.getNum()%b.getDen() + "/" + b.getDen(),b.toString())){
            if(st.equals(b.toString())){
                System.out.println("test #3 passed");  
            }else{
                System.out.println("test #3 failed");
            }
            
            System.out.println("____________");
            
            //test #4, no exceptions expected, expected output: "c = 0"
            Fraction c = new Fraction();
            System.out.println("c = " + c.toString());
            if(c.toString().equals("0")){
                System.out.println("test #4 passed");  
            }else{
                System.out.println("test #4 failed");
            }
            
            System.out.println("____________");
            
            //test #5, no exceptions expected, copy constuctor testing
            Fraction d = new Fraction(a);
            System.out.println("d = " + d.toString());
            if(d.toString().equals(a.getNum() + "/" + a.getDen())){
                System.out.println("d = " + d.toString() + " = " + "a");
                System.out.println("test #5 passed");  
            }else{
                System.out.println("test #5 failed");
            }
            
            System.out.println("____________");
            
            //test #6, no exceptions expected, mutators methods testing, expected output:  "a = 5/17"
            a.setNum(10);
            a.setDen(34);
            System.out.println("a = " + a.toString());
            if(a.toString().equals(a.getNum() + "/" + a.getDen())){
                
                System.out.println("test #6 passed");  
            }else{
                System.out.println("test #6 failed");
            }            
            System.out.println("____________");
            
            //test #7, no exceptions expected, add() method testing, expected output:  "a + b = 1 and 69/119"
            System.out.println("a = " + a.toString());
            System.out.println("b = " + b.toString());
            // 5/17 + 9/7 = 188/119
            if(188/119==a.add(b).getNum()/a.add(b).getDen()){
                System.out.println("a + b = " + a.add(b).toString());
                System.out.println("test #7 passed");  
            }else{
                System.out.println("test #7 failed");
            }
            System.out.println("____________");
            
            //test #8, no exceptions expected, subtract() method testing, expected output:  "b - a = 118/119"
            System.out.println("a = " + a.toString());
            System.out.println("b = " + b.toString());
            // 9/7 - 5/17 = 118/119
            if(118/119==b.subtract(a).getNum()/b.subtract(a).getDen()){
                System.out.println("b - a = " + b.subtract(a).toString());
                System.out.println("test #8 passed");  
            }else{
                System.out.println("test #8 failed");
            }
            System.out.println("____________");
            
            //test #9, no exceptions expected, multiply() method testing, expected output:  "a * b = 45/119"
            System.out.println("a = " + a.toString());
            System.out.println("b = " + b.toString());
            // 5/17 * 9/7 = 45/119
            if(45/119==a.multiply(b).getNum()/a.multiply(b).getDen()){
                System.out.println("a * b = " + a.multiply(b).toString());
                System.out.println("test #9 passed");  
            }else{
                System.out.println("test #9 failed");
            }
            System.out.println("____________");
            
            //test #10, no exceptions expected, divide() method testing, expected output:  "a : b = 35/153"
            System.out.println("a = " + a.toString());
            System.out.println("b = " + b.toString());
            // 5/17 : 9/7 = 35/153
            if(35/153==a.divide(b).getNum()/a.divide(b).getDen()){
                System.out.println("a : b = " + a.divide(b).toString());
                System.out.println("test #10 passed");  
            }else{
                System.out.println("test #10 failed");
            }
            System.out.println("____________");
            
            //test #11, no exceptions expected, less() method testing
            System.out.println("a = " + a.toString());
            System.out.println("b = " + b.toString());
            if(a.less(b)==true){
                System.out.println("5/17 < 9/7" + "\n" + "a < b");
                System.out.println("test #11 passed");  
            }else{
                System.out.println("a > b" );
                System.out.println("test #11 failed");
            }
            System.out.println("____________");
            
            //test #12, no exceptions expected, more() method testing
            System.out.println("a = " + a.toString());
            System.out.println("b = " + b.toString());
            if(b.more(a)==true){
                System.out.println("9/7 > 5/17" + "\n" + "b > a" );
                System.out.println("test #12 passed");  
            }else{
                System.out.println("b < a" );
                System.out.println("test #12 failed");
            }
            System.out.println("____________");
            
            
            //test #13, no exceptions expected, equals() method testing
            Fraction e  = new Fraction(0,10,34);
            System.out.println("a = " + a.toString());
            System.out.println("e = " + e.toString());            
            if(a.equals(e)==true){
                System.out.println("a = e");
                System.out.println("test #13 passed");  
            }else{
                System.out.println("test #13 failed");
            }
            System.out.println("____________");
            
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
        }        
    }           
}
