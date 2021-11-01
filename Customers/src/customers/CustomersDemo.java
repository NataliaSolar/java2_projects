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
public class CustomersDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //use try/catch block to handle exceptions
        try{
            //declare and allocate an array of base type PersonData for 3 elements.
            PersonData[] array = new PersonData[3];
            //Populate the array with 2 objects of type CustomerData, and 1 object of type PersonData
            array[0]= new PersonData();
            array[1] = new CustomerData();
            array[2] = new CustomerData();
            
            //????????????????????????????????
            //String name  = array[1].getFirstName();
            //int number = array[1].getCustomerNumber();
            

            //print out all the object data into the screen of all 3 objects
            for (int i =0; i<array.length; i++)
            {
                System.out.println(array[i].toString() + "\n");
            }        

            //testing constructors
            System.out.println("Testing constructors:\n");
       
            //create a list of transactions
            ArrayList<Long> transac = new ArrayList<Long>();
            //long max value 9 223 372 036 854 775 807

            CustomerData cd = new CustomerData("Natalia", "Solar", "1234 123th St SW Lynnwood", "(452) 123 1234", 6325, true, transac);
            //add some elemenst to the list of transactions
            transac.add(3720368547758071L);
            transac.add(3720368547711111L);
            //create CustomerData object
            CustomerData cd2 = new CustomerData("Jhon", "Doe", "1000 100th St SW Lynnwood", "(452) 100 1000", 1000, false, transac);
            //create PersonData object
            PersonData pd = new PersonData("Jane", "Doe", "1001 101th St SE Lynnwood", "(452) 101 1001");

            //print out all the object data into the screen
            System.out.println(cd.toString() +"\n");
            System.out.println(cd2.toString()+"\n");
            System.out.println(pd.toString()+"\n");

            //Testing methods
            System.out.println("Testing methods:\n");
            //set fields
            cd.setFirstName("Jhon");
            cd.setLastName("Doe");
            cd.setAddress("1000 100th St SW Lynnwood");
            cd.setPhone("(452) 100 1000");
            cd.setCustomerNumber(1000);
            cd.setMailingList(false);
            cd.setTransactions(transac);

            //check if recieved data matches 
            if (("Last name: " + cd.getLastName() + "\n" + "First name: " + cd.getFirstName() + "\n" +
                    "Address: " + cd.getAddress() + "\n" + "Phone: " + cd.getPhone() + "\n" + "Customer number: " + 
                    cd.getCustomerNumber() +"\n"+ "Mailing list: " + cd.getMailingList() + "\n"+ "Transactions: " + cd.getTransactions().toString()).equals(cd.toString())){
                System.out.println("Test passed");
                System.out.println(cd.toString()+"\n");
            } else System.out.println("Test failed.");
            //no exceptions expected
            cd.addTransaction(123456789012343333L);
            //should cause an exception
            //cd.addTransaction(-123456789012311145L);
            //should cause an exception
            //cd.addTransaction(123456789012345L);
            
            System.out.println("New transaction added:\n" + cd.toString());
            
            //make a copy of cd CustomerData object
            CustomerData cdCopy  = cd.clone();
            System.out.println("\nCopy of the cd object created:\n" + cdCopy.toString()+"\n");
            
            //testing equals method
            if(cd.equals(cdCopy)){
                System.out.println("Testing equals method for CustomerData objects.\n" + "Objects are equal: " + cd.equals(cdCopy));
                System.out.println("Test Passed.");
            }else System.out.println("Testing equals method. Test failed.");
            
            //make a copy of array[0] PersonData object
            PersonData pdCopy  = array[0].clone();
            System.out.println("\nCopy of the array[0] PersonData object created:\n" + pdCopy.toString()+"\n");
            
            //testing equals method
            if(array[0].equals(pdCopy)){
                System.out.println("Testing equals method for PersonData objects.\n" + "Objects are equal: " + array[0].equals(pdCopy));
                System.out.println("Test Passed.");
            }else System.out.println("Testing equals method. Test failed.");
            
      
        }catch (IllegalArgumentException e){
            System.out.println("Exception caught! " + e.getMessage());
        }

        
        
        
        
        
    }
    
}
