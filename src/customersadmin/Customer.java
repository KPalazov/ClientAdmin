/**
* Java2 Project
* Date: 2022-08-13
* 
*/

package customersadmin;

public class Customer
{
    private static int lastUsedCustomerId = 1000;
    
    private int customerId;
    String name;
    private String phone;
    private String email;
    
    /**
    *
    * @author Kaloyan Palazov
    */
    
    public Customer() throws Exception
    {
        this ("", "", ""); // Call Constructor
    }
    
        public Customer(int customerId, String name, String phone, String email) throws Exception
    {
        if (name.length() == 0)
            throw new Exception ("Error: Name cannot be blank.");
        else if (phone.length() == 0)
            throw new Exception ("Error: Phone cannot be blank.");
        else if (email.length() == 0)
            throw new Exception ( "Error: Email cannot be blank.");
        else if (email.contains("@") == false)
            throw new Exception ("Error: Email not valid.");
        else if (customerId < 0)
            throw new Exception ("Error: customerID cannot be less than zero.");
            
        if (customerId > lastUsedCustomerId)
            lastUsedCustomerId = customerId + 1;
        
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;      
    }
    
    public Customer(String name, String phone, String email) throws Exception
    {
        this (lastUsedCustomerId, name, phone, email);
        
        lastUsedCustomerId++;      
    }
    
    public int getCustomerId()
    {
    return customerId;
    }
    
    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }
    
    public void setName(String name)
    {
       this.name = name;
    }

    public void setPhone(String phone)
    {
       this.phone = phone;
    }

    public void setEmail(String email)
    {
       this.email = email;
    }
    
    public String toStringWithLineBreak()
    {
        return customerId + "\n" + name + "\n" + phone + "\n" + email  + "\n";
    }
    
    @Override
    public String toString()
    {
        return  String.format ("%8d", customerId)  + "  " +
                String.format ("%-20s", name)  +
                String.format ("%-20s", phone) +
                String.format ("%-20s", email);
    }

}