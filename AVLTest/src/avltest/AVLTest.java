/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltest;

/**
 *
 * @author Natalia
 */
public class AVLTest {
	public static void main(String[] args) {
		AVLTree avl = new AVLTree();

//		 avl.Insert( 50);
//		 avl.Insert(25);
//		 avl.Insert(75);
//		 avl.Insert(5);	
//		 avl.Insert(35);
//		 avl.Insert( 15);
//		 avl.Insert( 65);
//		 avl.Insert( 85);
//		 //THE REMOVE DOES NOT REMOVE ANYTHING ??!!
//		 avl.removeKey(25);
//		 avl.removeKey(75);
//		 avl.removeKey(50);
//		 avl.removeKey(65);
		 
		 //CRASHES at rlBalance(Node node){
		 avl.Insert(41);
		 avl.Insert(42);
		 avl.Insert(43);
		 
		 //CRASHES at lrBalance(Node node){
		 avl.Insert(49);
		 avl.Insert(48);
		 avl.Insert(47);
		 

			
	    //   System.out.print("These are the node at this level:  " );
            int hiegth = avl.getHeight();
            for(int n = 0; n<hiegth+1; n++){
	       int[] intArray = avl.getNodesAtLevel( n );
		   for (int i=0; i < intArray.length; i++) {
			   System.out.print(intArray[i]+" ");
		   }
                System.out.println();  
            }
            
            System.out.println();
            avl.removeKey(47);
            
            hiegth = avl.getHeight();
            for(int n = 0; n<hiegth+1; n++){
	       int[] intArray = avl.getNodesAtLevel( n );
		   for (int i=0; i < intArray.length; i++) {
			   System.out.print(intArray[i]+" ");
		   }
                System.out.println();  
            }
	}
        
        
	
	   //private void print(int level){}
}