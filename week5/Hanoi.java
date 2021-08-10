/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

/**
 *
 * @author LWTECH
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              
       writeVertical(12345);
       writeVerticalLoop(12345);
       System.out.printf("3 ^ 3 = %d\n", power(3, 3));

       hanoi(5, 1);
    }
      public static void writeVertical(int n)
    {
       if(n<10) System.out.println(n); // base case
       else // recursive step
       {
           writeVertical(n/10);
           System.out.println(n%10);
       }
    }
    public static void writeVerticalLoop(int n)
    {
       StringBuilder storage = new StringBuilder();
       while(n>=10)
       {
           storage.append(n%10);
           storage.append('\n');
           n= n/10;
           
       }
           storage.append(n);
           storage.append('\n');
           storage.reverse();
        System.out.println(storage.toString());
    
    }
     public static int power(int x, int n)
    {
        if (n<0)
        {
            System.out.println("Illigal argument");
            System.exit(0);
        }
        if(n>0)
        {
            return x*power(x,(n-1));
        }
        else return 1;
    }
    public static void hanoi(int N, int direction)
    {
        if(N==0) return;
        
        hanoi(N-1, -direction); // move N-1 disks back, to the left to free the largest disk
        shift(N, direction); //shift the disk to the right
        hanoi(N-1, -direction); // move all n-1 disks back (to the left) one peg to put them all on top of the disk that was just moved        
    }
    public static void shift(int N, int direction)
    {
       String d;
       if (direction >0) d = N+" ->";
       else d = N+ " <-";
       
       System.out.println(d);
    }
}
