import java.util.ArrayList;
/**
 * Customer
 */
public class Customer 
{
    //Instance data members
    private int ID;
    private String firstName;
    private String lastName;
    private String country;
    private String passportNumber;
    private ArrayList <Account_revision> accounts = new ArrayList<>();

    //Constructor
    public Customer(String firstName, String lastName, String country, String passportNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.passportNumber = passportNumber;
        this.ID = 1;

    }
    //Calls the Account constructor to open an account on the user
    public void openAccount(String accountType, String creationDate)
    {
        Account_revision account = new Account_revision(accountType, firstName + " " + lastName , creationDate);
        account.setOwner(this);
        accounts.add(account);
        System.out.println("Opened a new account (" + (Account_revision.getNoOfAccounts()-1) + ") for customer " +  firstName + " " + lastName );
    }
    //Reaches the accounts created
    public ArrayList<Account_revision> getAccounts()
    {
        return accounts;
    }


    public static void main(String[] args) 
    {
        Customer customer = new Customer("John", "Wick", "Turkey", "TR412");
        customer.openAccount("Personal","08-12-2019");   
        customer.openAccount("Investment","10-05-2023");

        customer.getAccounts().get(0).cashDeposit(2000);
        customer.getAccounts().get(1).cashDeposit(1400);
        customer.getAccounts().get(1).deActivate();

        System.out.println(customer);
    }

    //This method converts object to the String format and prints it accordingly
    public String toString()
    {
        String stars = "";
        for(int i=0; i<50; i++)
        {
            stars += "*"; 
        }   

        String userAccounts = "";
        for(int i=0; i<accounts.size(); i++)
        {
            userAccounts += "Account ID: " + accounts.get(i).getID() + " Type: " + accounts.get(i).getAccountType() + " Status: " + accounts.get(i).isActive() + "\n" ;
        }

        return  stars + "\n" +
        "Customer Information: \n" + "Customer ID: " + ID + "\n" + "Name: " +  firstName + " " + lastName + "\n" + "Country:" + country + "\n" + "Passport Number: " + passportNumber + "\n" + "Accounts: \n" + 
        userAccounts + stars + "\n";
    }


}