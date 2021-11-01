
package listdemo;

/**
 *
 * @author Natalia Solar
 * Assignment 6, CS 143
 */
public class List {
      
    private class Node
    {
        int value;   
        Node next;      
        
        /**
           Constructor.            
           @param val The element to store in the node.
           @param n The reference to the successor node.
        */
        
        Node(int val, Node n)
        {
            value = val;
            next = n;
        } 
        
        /**
           Constructor. 
           @param val The element to store in the node.
        */
        
        Node(int val)
        {
           // Call the other (sister) constructor.
           this(val, null);            
        }
    }	
	 
    private Node first;  // list head
	     
    /**
       Constructor.
    */
    
    public List()
    {
        first = null;  
    }
    
    /**
     * Copy constructor
     * @param objToCopy linked list to copy from
     */
    public List(List objToCopy){
        
        if (objToCopy.isEmpty()){//if list is empty --throw exception?
            System.out.println("The list is empty.");
            return;
        }
        first = new Node(objToCopy.first.value);
        Node cur = first;
        Node cur_obj = objToCopy.first;
        for(int i = 1; i<objToCopy.size();i++){
            cur.next = new Node(cur_obj.next.value, cur_obj.next.next);
            cur = cur.next; // move step foward
            cur_obj = cur_obj.next;
        }
    }
    
    /**
       The isEmpty method checks to see if the list is empty.
        @return true if list is empty, false otherwise.
    */
    
    public boolean isEmpty()
    {        
        return first == null;       
    }
    
    /**
       The size method returns the length of the list.
       @return The number of elements in the list.
    */
    
    public int size()
    {
       int count = 0;
       Node p = first;     
       while (p != null)
       {
           // There is an element at p
           count ++;
           p = p.next;
       }
       return count;
    }
    
    /**
       The add method adds an element to
		 the end of the list.
       @param e The value to add to the
		 end of the list.       
    */
    
    public void add(int e)
    {
      if (isEmpty()) 
      {
          first = new Node(e);
      }
      else
      {
          // Add to end of existing list
          Node current = first;
          // moving current reference to the ent of the list
          while(current.next!=null) current = current.next;
          
          current.next = new Node(e);
          
      }      
    }
    
    /**
       The add method adds an element at a position.
       @param e The element to add to the list.
       @param index The position at which to add 
		 the element.
       @exception IndexOutOfBoundsException When 
		 index is out of bounds.  
    */
    
    public void add(int index, int e)
    {
         if (index < 0  || index > size()) 
         {
             String message = String.valueOf(index);
             throw new IndexOutOfBoundsException(message);
         }
         
         // Index is at least 0
         if (index == 0)
         {
             // New element goes at beginning
             first = new Node(e, first);
      
             return;
         }
         
         // Set a reference pred to point to the node that
         // will be the predecessor of the new node
         Node pred = first;        
         for (int k = 1; k <= index - 1; k++)        
         {
            pred = pred.next;           
         }
         
         // Splice in a node containing the new element
         pred.next = new Node(e, pred.next);  
         
          
    }
    
    /**
       The toString method computes the string
       representation of the list.
       @return The string form of the list.
    */
    
    public String toString()
    {
      StringBuilder strBuilder = new StringBuilder();
      
      // Use p to walk down the linked list
      Node p = first;
      while (p != null)
      {
         strBuilder.append(p.value + "\n"); 
         p = p.next;
      }      
      return strBuilder.toString(); 
    }
    
    /**
       The remove method removes the element at an index.
       @param index The index of the element to remove. 
       @return The element removed.  
       @exception IndexOutOfBoundsException When index is 
                  out of bounds.     
    */
    
    public int remove(int index)
    {
       if (index < 0 || index >= size())
       {  
           String message = String.valueOf(index);
           throw new IndexOutOfBoundsException(message);
       }
       
       int element;  // The element to return     
       if (index == 0)
       {
          // Removal of first item in the list
          element = first.value;    
          first = first.next;           
       }
       else
       {
          // To remove an element other than the first,
          // find the predecessor of the element to
          // be removed.
          Node pred = first;
          
          // Move pred forward index - 1 times
          for (int k = 1; k <= index -1; k++)
              pred = pred.next;
          
          // Store the value to return
          element = pred.next.value;
          
          // Route link around the node to be removed
          pred.next = pred.next.next;  
          
                   
       }
       return element;        
    }  


    
    /**
     * The method that reverse the linked list data structure.
     */
    public void reverseList(){
        if(isEmpty()) System.out.println("The list is empty.");//check if the list is empty
        Node prev = null;//pointer for the previous node
        Node curr = first;// pointer for the corrent node
        Node after = null;// pointer for the node after the current
        while(curr!=null){
            after = curr.next;//before changing the current node store the node after the current (next node)
            curr.next = prev;//change the next of current (make it point to the prev), here the reversing happens
            prev = curr;//move previous and corrent nodes step foward
            curr = after;
        }
        first = prev;//change the first node after the loop is executed
    }
        
    /**
     * method that creates a string that holds all the integers in the list in reverse order
     * @return string of integers from the linked list in reverse order
     */
    public String reverseToString(){
        StringBuilder strBuilder = new StringBuilder();
      
      // Use p to walk down the linked list
      Node p = first;
      while (p != null)
      {
         strBuilder.append(p.value + "\n"); 
         p = p.next;
      }      
      return strBuilder.reverse().toString();
    }
  
    /**
     * private method that creates a string that holds all the integers in the list in reverse order
     * @param curr linked list node
     * @return string that holds all the integers in the list in reverse order
     */
    private String privateRecReverseToString(Node curr){
        if (curr==null) return "";//base case        
        return privateRecReverseToString(curr.next)+ curr.value + "\n";
        
    }
    
    /**
     * method that calls on private privateRecReverseToString method
     * @return string that holds all the integers from the linked list in reverse order
     */
    public String recReverseToString(){
        return privateRecReverseToString(first);
        
    }
    
    /**
     * method that moves the node with the smallest integer in the list to become the first node.
     */
    public void smallestFirst(){
        if(isEmpty()) System.out.println("The list is empty.");//check if the list is empty
        Node prev = null;//pointer for the previous node
        Node curr = first;// pointer for the corrent node
        Node after = null;// pointer for the node after the current
        Node smallest = first; //to hold smallest node
        Node small_prev = null; //to hold the node before the smallest
        Node small_after = null;//to hold the node after the smallest
        while(curr!=null){
            after = curr.next;//before changing the current node store the node after the current (next node)
            if(curr.value<smallest.value){
                smallest = curr;
                small_prev = prev;
                small_after = after;
            } 
            prev = curr;//move previous and corrent nodes step foward
            curr = after;
        }
        small_prev.next = small_after;//rewire nodes
        smallest.next = first;        
        first = smallest;
    }
    
    /**
     * method that moves the node with the smallest integer in the list to become the first node.
     */
    public void smallestFirst2(){
        int smallest = first.value;//to hold smallest value
        int index = 0;//to hold index of the smallest value
        Node current = first.next;
        int size = size();
        
        
        //find the smallest element and its index
        for(int i = 1; i<size;i++){
            if(smallest > current.value){
                smallest = current.value;
                index = i;
            }            
            current = current.next;
        }
        //remove that element
        int removed = remove(index);
        //add that element to the head of the list
        add(0, removed);        
    }           
}
