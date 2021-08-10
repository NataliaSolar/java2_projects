/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listdemo;

/**
 *
 * @author LWTECH
 */
public class ListDemo {

    /**
     * @param args the command line arguments
     */
     public static void main(String [] args)
    {
        List myList = new List();
        myList.add(1);
        myList.add(2);
        myList.add(0, 3);
        myList.add(2, 4);
        myList.add(4, 5);
        System.out.println("The members of the list are:");
        System.out.print(myList);
        myList.reverseList();
        System.out.println("After reversal:");
        System.out.print(myList);
    }
    
}
