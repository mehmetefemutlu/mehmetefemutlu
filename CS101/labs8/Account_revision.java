/**
 * Mehmet Efe Mutlu
 * 22303326
 * This program runs a simple bank account
 */
public class Account_revision
{
    public static void main(String[] args) 
    {
        //We create account objects with its properties
        Account_revision account1 = new Account_revision("Personal","John Goodman","01-01-2023");
        Account_revision account2 = new Account_revision("Investment","Kaan Goodman","08-04-2017");
        Account_revision account3 = new Account_revision("Student","Rose Goodwoman","11-02-2022");

        //This operations has done according to the sample run
        account1.cashDeposit(1000);
        account1.cashWithdrawal(500);
        account1.deActivate();

        account2.cashDeposit(2400);
        account2.cashWithdrawal(2500);

        boolean status = account1.isActive();

        System.out.println("Account 1 status: " + status);
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());

        account3.cashDeposit(2400);
        account1.transaction(account2, 1200);

        account1.activate();
        account1.cashDeposit(500);
        account1.transaction(account3, 1200);

        double hasDebt = account1.getDebt();

        System.out.println("Account 1 debt amount: " + hasDebt);
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
        System.out.println("Account 3 balance: " + account3.getBalance());

        System.out.println();
        System.out.println(account1);
        System.out.println();
        System.out.println(account2);
        System.out.println();
        System.out.println(account3);

        System.out.println();
        

       
    }
    //Static data members
    private static int noOfAccounts = 1;

    //Instance data members
    private int ID;
    private int numberOfLoans;
    private String accountType;
    private String accountOwner;
    private String creationDate;
    private double maxLoanlimit;
    private double maxDebtLimit;
    private double balance;
    private double loanAmount;
    private double debt;
    private boolean isActive;
    private Customer customer;

    //Constructor
    public Account_revision(String accountType, String accountOwner, String creationDate)
    {
        //We initialize the prior variables
        this.ID = noOfAccounts++;
        this.accountType = accountType;
        this.accountOwner = accountOwner;
        this.creationDate = creationDate.replace("-","/");

        this.loanAmount = 0;
        this.numberOfLoans = 0;
        this.balance = 0;
    
        //We initialize the maximum loan limit according to the account type
        if(this.accountType.equals("Student"))
        {
            this.maxLoanlimit = 4000.0;
        }
        else if(this.accountType.equals("Personal"))
        {
            this.maxLoanlimit = 2000.0;
        }
        else if(this.accountType.equals("Business"))
        {
            this.maxLoanlimit = 100000.0;
        }
        else if(this.accountType.equals("Investment"))
        {
            this.maxLoanlimit = 10000.0;
        }

        this.maxDebtLimit = this.maxLoanlimit/2;
        this.isActive = true;
    }

    //Setters

    //This method activates the account
    public void activate()
    {
        isActive = true;
        System.out.println("Account " + ID + " has been activated.");
    }
    //This method deactivates the account
    public void deActivate()
    {
        isActive = false;
        System.out.println("Account " + ID + " has been deactivated.");
    }
    //This method withdraws a certain amount of cash according to the needs
    public void cashWithdrawal(int amount)
    {
        if(isActive)
        {
            if(debt<maxDebtLimit)
            {
                if(amount<= balance)
                {
                    balance -= amount;
                }
                else
                {
                    debt += (amount-balance);
                    balance = 0;
                }
                System.out.println("Cash withdrawal of $ " + amount + " into account " + ID);

            }
            else
            {
                System.out.println("Withdraw failed. You have exceeded maximum debt limit for account " + ID);
            }
        }
        else
        {
            System.out.println("Withdraw failed. Account " + ID + " is inactive");
        }
    }
    //This method deposits a certain amount of cash according to the needs
    public void cashDeposit(int amount)
    {
        if(isActive)
        {
            if(hasDebt())
            {
                if(amount>=debt)
                {
                    balance += (amount-debt);
                    debt = 0;
                }
                else 
                {
                    debt -= amount;
                }
            }
            else 
            {
                balance += amount;
            }
            System.out.println("Cash deposit of $ " + amount + " into account " + ID);
        }
        else
        {
            System.out.println("Deposit failed. Account" + ID + "is inactive");
        }

    }

    //Service Methods

    //This method checkes whether the account has debt or not
    public boolean hasDebt()
    {
        return debt > 0;
    }
    //This method takes a loan offer and approves it if it does not exceeds the maximum loan limit
    public void requestLoan(double loanAmount)
    {
        if(isActive)
        {
            if(loanAmount<=maxLoanlimit)
            {
                this.loanAmount += loanAmount;
                numberOfLoans++;
                System.out.println("The loan of $ " + loanAmount + " approved for account " + ID);
            }
            else 
            {
                System.out.println("Loan failed. You have exceeded maximum loan limit for account " + ID);
            }
        }
        else
        {
            System.out.println("Loan failed. Account " + ID + " is inactive");
        }
    }

    //This method transacts a certain amount of money from one account to another
    public void transaction(Account_revision destAccount, int amount)
    {
        if(isActive && destAccount.isActive)
        {
            if(amount>=balance)
            {
                if(debt<=maxDebtLimit && (maxDebtLimit+balance)>=amount)
                {
                    debt += (amount-balance);
                    balance = 0;
                    if(destAccount.debt!=0)
                    {
                        destAccount.balance = (amount-destAccount.debt);
                        destAccount.debt = 0;
                    }
                    else 
                    {
                        destAccount.balance += amount;
                    }
                    System.out.println("Transferred $ " + amount + " (debt) from account " + ID + " to account " + destAccount.ID);            
                }
                else 
                {
                    System.out.println("Transaction failed. You have exceeded maximum debt limit for account " + ID);
                }
            }
            else
            {   
                balance -= amount;
                destAccount.balance+= amount; 
                System.out.println("Transferred $ " + amount + " from account " + ID + " to account " + destAccount.ID);
            }
        }
        else
        {
            System.out.println("Transaction failed. One or both accounts are inactive.");
        }
    }
    //Sets the owner to the customer
    public void setOwner(Customer customer)
    {
        this.customer = customer;
    }



    //This method converts object to the String format and prints it accordingly
    public String toString()
    {
        String stars = "";
        for(int i=0; i<50; i++)
        {
            stars += "*";
        }
        
        String status = "";
        if(isActive)
        {
            status = "Active";
        }
        else 
        {
            status = "Inactive";
        }
        return stars + "\n" +
         "Account Information: \n" + "ID: " +  ID + "\n" + "Type: " + accountType + "\n" + "Owner:" + accountOwner + "\n" + "Balance: " + balance + "\n" +
         "Max Loan Limit: " + maxLoanlimit + "\n" + "Max Debt Limit: " + maxDebtLimit + "\n" + "Creation Date : " + creationDate + "\n" +
         "Loan Amount: " + loanAmount + "\n" + "Number of Loans: " + numberOfLoans + "\n" + "Debt: " + debt + "\n" + "Status: " + status + "\n" +
         stars + "\n";
    }   
        //Getters
        public int getID()
        {
            return ID;
        }
        public String getAccountType()
        {
            return accountType;
        }
        public String getCreationDate()
        {
            return creationDate;
        }
        public int getNumberOfLoans()
        {
            return numberOfLoans;
        }
        public double getBalance()
        {
            return balance;
        }
        public double getDebt()
        {
            return debt;
        }
        public double getMaxDebtLimit()
        {
            return maxDebtLimit;
        }
        public double getMaxLoanLimit()
        {
            return maxLoanlimit;
        }
        public double getLoanAmount()
        {
            return loanAmount;
        }
        public boolean isActive()
        {
            return isActive;
        }
        public static int getNoOfAccounts()
        {
            return noOfAccounts;
        }
}