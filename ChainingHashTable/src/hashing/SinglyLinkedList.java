package hashing;
import java.util.Iterator;
/**
 * @author Roman Sobolenko
 * CSD335 Section: H21
 * Chapter 4 - programming assignment
 * This class contains the singly-linked list. It is the super class of LinkedStack and LinkedQueue.
 */
class SinglyLinkedList<T> implements Iterable<T>{
	//implements Iterable<T> 
	
    /**
     * A node used for building the singly linked list
     */
    protected class Node<T> {
        T value;
        Node next;
        
        
        /**
         * Constructor of the node
         * @param val String containing the node value
         * @param n Node containing the link
         */
        Node(T val, Node n) {
            value = val;
            next = n;
        }

        /**
         * Constructor of the node
         * @param val String containing the node value
         */
        Node(T val) {
            this(val, null);
        }
    }
    

    protected Node head;  	// head element in the list
    protected Node tail;   	// tail element in list
    
    //QUEUE = remove from the head, and add to the tail
    //STACK = add to the head, and remove from the head

    
    

    //Constructor
    /**
     * Constructor of a singly list list class
     * Sets head to null and tail to null because when we first instatiate the sll, there is nothing
     * in the list - the initial list is empty
     */
    public SinglyLinkedList() {
        head = null;
        tail = null;
    }


    /** isEmpty method that checks to see if the list is empty.
     * @return head Returns true if the list is empty returns false if the list is not empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    
    /** A method that goes through the list and returns the length of the list.
     * @return count Returns the number of elements in the queue
     */
    public int size() {
        int count = 0;
        Node p = head;
        while (p != null) {		//While loop to goes through the list and determine size.
            // There is an element at p
            count++;
            p = p.next;
        }
        return count;
    }

    
    /** A void method that adds an element to the end of the list.
     * Specifically, it adds elements at the end of the singly linked list. 
     * @param e String passed in to be added to the list
     */
    public void add(T e) {
        if (isEmpty()) {
            head = new Node(e);
            tail = head;
        } else {
            // Add to end of existing list
            tail.next = new Node(e);
            tail = tail.next;
        }
    }

     // The add method adds 
    /**
     * This methods adds an element at a specific position.
     * @param index Integer of the position where to add
     * @param e String passed in to be added to the list
     */
    public void add(int index, T e) {
        if (index < 0 || index > size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        
        // Index is at least 0
        if (index == 0) {
            // New element goes at beginning
            head = new Node(e, head);
            if (tail == null) {
                tail = head;
            }
            return;
        }

        // Set a reference pred to point to the node that will be the predecessor of the new node
        Node pred = head;
        for (int k = 1; k <= index - 1; k++) {
            pred = pred.next;
        }

        // Splice in a node containing the new element
        pred.next = new Node(e, pred.next);

        // Is there a new tail element ?
        if (pred.next.next == null) {
            tail = pred.next;
        }
    }

    

    /**
     * Method that removes the elements at specified index
     * @param index Integer of index at which we want to remove
     * @return element Returns string value of the head
     */
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        T element;  // The element to return     
        if (index == 0) {
            // Removal of head item in the list
            element = (T) head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            // To remove an element other than the head,
            // find the predecessor of the element to
            // be removed.
            Node pred = head;

            // Move pred forward index - 1 times
            for (int k = 1; k <= index - 1; k++) {
                pred = pred.next;
            }

            // Store the value to return
            element = (T) pred.next.value;

            // Route link around the node to be removed
            pred.next = pred.next.next;

            // Check if pred is now tail
            if (pred.next == null) {
                tail = pred;
            }
        }
        return element;
    }


    /**
     * A method that searches the list for an element, and if its found
     * removes the element and returns true. Otherwise, return false.
     * @param element Passing in the element to be removed
     * @return Returns true if the element is found and removed, otherwise returns false
     */
    public boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }

        // if the element is the head in the list, 
        // handle it as a special case.
        if (element.equals(head.value)) {
            // Removal of head item in the list
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return true;
        }

        // Find the predecessor of the element to remove
        Node pred = head;
        while (pred.next != null
                && !pred.next.value.equals(element)) {
            pred = pred.next;
        }

        // pred.next == null OR pred.next.value is element
        if (pred.next == null) {
            return false;
        }

        // pred.next.value  is element
        pred.next = pred.next.next;

        // Check if pred is now tail
        if (pred.next == null) {
            tail = pred;
        }

        return true;
    }

 
    /**
     * A method that searches for an element, and if its found, return it's numeric position in the list 
     * (head element in the list is 0)
     * @param element Passing in the element to be located
     * @return
     */
    public int search(T element) {
    	if (isEmpty()) return -1;
    	
        // if the element is the head in the list, handle it as a special case.
        if (element.equals(head.value)) return 0;
        

        // Find the predecessor of the element to remove
        Node pred = head;
        int counter = 0;
        while (pred.next != null
                && !pred.next.value.equals(element)) {
            counter++;
        }

        // pred.next == null OR pred.next.value is element
        if (pred.next == null) {
            return counter;
        }
    	return counter;
    }
    
    
    public Iterator<T> iterator() {
        return new ListIterator<T>(head);
    }
    
    
	/**
	 * A toString method that returns a string representation of the list
	 * @return strBuilder.toString() Returns a string with elements in the list
	 */
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        // Use p to walk down the linked list
        Node p = head;
        while (p != null) {
            strBuilder.append(p.value + "\n");
            p = p.next;
        }
        return strBuilder.toString();
    }
}