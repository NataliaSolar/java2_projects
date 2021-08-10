/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listdemo;

/**
 *
 * @author Natalia Solar 
 * Assignment 6, CS 143
 */
public class ListDemo {

    /**
     * @param args the command line arguments
     */
     public static void main(String [] args)
    {
        List myList = new List();//create linked list
        myList.add(1);//add nodes
        myList.add(2);
        myList.add(0, 3);
        myList.add(2, 4);
        myList.add(4, 5);
        System.out.println("The members of the list are:");//print out
        System.out.print(myList);
        myList.reverseList();//reverse the list
        System.out.println("After reversal:");
        System.out.print(myList);       
        
        System.out.println("Printed in reverse order:");//print list in reverse order
        System.out.println(myList.reverseToString());
        
        System.out.println("\nPrinted in reverse order in recursive method:");//print list in reverse order
        System.out.println(myList.recReverseToString());
        
        System.out.println("\nTest reverseList() method with an empty list:");
        List reverseTest = new List();
        reverseTest.reverseList();
        System.out.print(reverseTest);
        
        System.out.println("\nTest reverseList() method with a list of one element:");
        List reverseTest2 = new List();
        reverseTest2.add(5);
        System.out.println("Given list:");
        System.out.print(reverseTest2);
        reverseTest2.reverseList();
        System.out.println("Reversed list:");
        System.out.print(reverseTest2);
        
        System.out.println("\nCreate a copy of myList:");
        List myListCopy = new List(myList);
        System.out.println("Copy created:");
        System.out.print(myListCopy.toString());
        
        System.out.println("\nCreate a copy of an empty linked list:");
        List test = new List();
        List testCopy = new List(test);
        
        System.out.println("\nCreate a copy of a linked list with one element:");
        test.add(4);
        System.out.println("Given list:");
        System.out.println(test);
        List testCopy2 = new List(test);
        System.out.println("Copy created: "+ testCopy2.toString());
        
        System.out.println("\nTesting smallestFirst() method:\nGiven Array:");
        System.out.print(myList);
        myList.smallestFirst();
        System.out.println("Changed linked list");
        System.out.print(myList);
    }
    
}
