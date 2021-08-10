/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import java.util.ArrayList;

/**
 *
 * @author Natalia Solar
 */
public class CustomerData extends PersonData implements Cloneable{
    
    private int customerNumber; //to hold a unique integer for each customer.
    private boolean mailingList;//true if the customer wishes to be on a mailing list, false if the customer does not wish
    private ArrayList<Long> transactions;//represents the list of all transactions done with the customer for the last 5 years.
    
    /**
     * Non-argument constructor that sets all variables (including inherited ones)
        to empty strings and transactions to an empty ArrayList
     */
    public CustomerData(){
        super();
        customerNumber = 0;
        mailingList = false;
        transactions = new ArrayList<Long>();
    }
    
    /**
     * constructor that takes all the data about customer as parameters and initializes member variables.
     * @param lastname customer's last name
     * @param firstname customer's first name
     * @param address customer's address
     * @param phone customer's phone
     * @param custNumber a unique integer for customer
     * @param mailList wish to be in the  mailing list (true or false)
     * @param trans the list of transactions
     */
    public CustomerData(String lastname, String firstname, String address, 
            String phone, int custNumber, boolean mailList, ArrayList<Long> trans){
        
        super(lastname, firstname, address, phone);
        customerNumber = custNumber;
        mailingList = mailList;
        transactions = new ArrayList<Long>(trans);
    }
    
    /**
     * Accessor for the customerNumber field
     * @return the value of customerNumber
     */
    public int getCustomerNumber(){
        return customerNumber;
    }
    
    /**
     * Accessor for the mailingList field
     * @return the value of mailingList
     */
    public boolean getMailingList(){
        return mailingList;
    }
    
    /**
     * Accessor for the transactions field
     * @return the list of transactions
     */
    public ArrayList<Long> getTransactions(){
        return new ArrayList<>(transactions);
    }
    
    /**
     * Mutator for the customerNumber field
     * @param custNum value to be set
     */
    public void setCustomerNumber(int custNum){
        customerNumber = custNum;
    }
    
    /**
     * Mutator for the mailingList field
     * @param mailList value to be set
     */
    public void setMailingList(boolean mailList){
        mailingList = mailList;
    }
    
    /**
     * Mutator for the transactions field
     * @param trans list to be set
     * @throws IllegalArgumentException when a null was passed as parameter
     */
    public void setTransactions(ArrayList<Long> trans) throws IllegalArgumentException{
        if (trans == null) throw new IllegalArgumentException("A null was passed as parameter.");
        transactions = new ArrayList<>(trans);
    }
    
    /**
     * Method that adds a transaction to the list.
     * @param t transaction to be added to the list 
     * @throws IllegalArgumentException when t is not positive and less than 16 digits long
     */
    public void addTransaction(long t)throws IllegalArgumentException{
        if (t<=0) throw new IllegalArgumentException("Transaction must be positive.");
        //check if length of t is more than 15 (convert t to string and get the length of the string)
        if (Long.toString(t).length()<=15) throw new IllegalArgumentException("Transaction must be more than 15 digits long.");
        transactions.add(t);
        
    }
    
    /**
     * Method that creates and returns a string containing information about the customer
     * @return a text containing information about the customer
     */
    @Override public String toString(){
        return super.toString() + "Customer number: " + customerNumber +"\n"+ "Mailing list: " + mailingList + "\n"+ "Transactions: " + transactions.toString();
    }
    
    /**
     * Method that compares two CustomerData objects
     * @param otherObj object to be compared with
     * @return true if objects are equal
     */
    @Override public boolean equals(Object otherObj)
   {
       if(otherObj == null) return false;
       if (this.getClass()!= otherObj.getClass()) return false;
       CustomerData a = (CustomerData)otherObj;
       if (super.equals(a)) return true;
       if (customerNumber == a.customerNumber && mailingList == a.mailingList && transactions.equals(a.transactions)) return true;
       return false;
   }
    
    /**
     * Method that makes a copy of an object
     * @return the copy of a CustomerData object
     */
    @Override public CustomerData clone()
    {
        
        CustomerData objCopy = (CustomerData)super.clone();
        objCopy.customerNumber = customerNumber;
        objCopy.mailingList = mailingList;
        objCopy.transactions = new ArrayList<>(transactions);
        return objCopy;  
    }
}
