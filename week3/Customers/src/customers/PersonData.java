/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

/**
 *
 * @author Natalia Solar
 */
public class PersonData implements Cloneable{
    
    private String lastName; // person's last name 
    private String firstName; //person's first name
    private String address; //person's address
    private String phone; //person's phone
    
    /**
     * Non-argument constructor that sets all fields to empty strings.
     */
    public PersonData(){
        lastName = "";
        firstName = "";
        address = "";
        phone = "";
    }
    
    /**
     * Constructor that takes all the data about customer as 
     * parameters (4 parameters) and initializes fields.
     * @param lastName customer's last name
     * @param firstName customer's first name
     * @param address customer's address
     * @param phone customer's phone number
     */
    public PersonData(String lastName, String firstName, String address, String phone){
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
    }
    
    /**
     * Accessor for lastName field
     * @return customer's last name
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     *  Accessor for firstName field
     * @return customer's first name
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Accessor for address field
     * @return customer's address
     */
    public String getAddress(){
        return address;
    }
    
    /**
     * Accessor for phone field
     * @return customer's phone
     */
    public String getPhone(){
        return phone;
    }
    
    /**
     * Mutator for the lastName field
     * @param lastname the last name to be set
     */
    public void setLastName(String lastname){
        this.lastName = lastname;
    }
    
    /**
     * Mutator for the firstName field
     * @param firstname the first name to be set
     */
    public void setFirstName(String firstname){
        this.firstName = firstname;
    }
    
    /**
     * Mutator for the address field
     * @param address the address to be set
     */
    public void setAddress(String address){
        this.address = address;
    }
    
    /**
     * Mutator for the phone field
     * @param phone the phone number to be set
     */
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    /**
     * Method that creates and returns a string containing information about the customer
     * @return a text containing information about the customer
     */
    @Override public String toString(){
        return "Last name: " + lastName + "\n" + "First name: " + firstName + "\n" +
                "Address: " + address + "\n" + "Phone: " + phone + "\n";
    }
    
    /**
     * Method that compares two PersonData objects
     * @param obj object to be compared with
     * @return true if objects are equal
     */
    /*public boolean equals(PersonData obj){
        
        if (lastName.equals(obj.lastName) && firstName.equals(obj.firstName) && 
                address.equals(obj.address) && phone.equals(obj.phone)) return true;
        return false;
    }*/
    
    /**
     * Method that compares two PersonData objects
     * @param otherObj object to be compared with
     * @return true if objects are equal
     */
    @Override public boolean equals(Object otherObj)
   {
       if(otherObj == null) return false;
       if (this.getClass()!= otherObj.getClass()) return false;
       PersonData pd = (PersonData)otherObj;
       if (super.equals(pd)) return true;
       if (lastName.equals(pd.lastName) && firstName.equals(pd.firstName) && 
                address.equals(pd.address) && phone.equals(pd.phone)) return true;
        return false;
   }
    /**
     * Method that makes a copy of an object
     * @return the copy of a PersonData object
     */
    @Override public PersonData clone()
    {
        try{
        return (PersonData)super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
   
}
