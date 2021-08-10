/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreedemo;

/**
 *
 * @author Thomas.Abbott
 */
public class BinarySearchTreeDemo {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println(bst);
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(35);
        bst.add(15);
        bst.add(65);
        bst.add(85);
        System.out.println(bst);
    }
}
