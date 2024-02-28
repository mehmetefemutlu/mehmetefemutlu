import java.util.Scanner;

/**
 * This program is to check whether a person is eligible to take loan from the bank by considering certain criteria
 * Student Name: Mehmet Efe Mutlu
 * Student ID: 22303326
 */
public class lab03_Q2 
{
 public static void main(String[] args) 
 {
    //We must take inputs from the applicant
    Scanner in = new Scanner(System.in);

    System.out.print("Enter your debt: ");
    double debt = in.nextDouble();

    System.out.print("Enter annual salary: ");
    double annualSalary = in.nextDouble();

    System.out.print("Enter employment history in years: ");
    int employmentHistory = in.nextInt();

    System.out.print("Enter number of late payments: ");
    int latePayments = in.nextInt();

    System.out.print("Enter your balance: ");
    double balance = in.nextDouble();

    //We must define constants which the bank decided
    final double EACH_FIVE_POİNTS_FOR_THE_BALANCE_RATE = 1000.0;
    final double EACH_FIVE_POİNTS_FOR_THE_ANNUAL_SALARY =5000.0;

    //We have to add an upper limit for the credit score
    if(annualSalary>50000.0)
    {
        annualSalary = 50000.0;
    }
    if(balance>10000.0)
    {
         balance = 10000.0;
    }

    //We now have to calculate credit score of the applicant
    double creditScore = 700.0;
    creditScore = creditScore+(10*employmentHistory);
    creditScore = creditScore+(5*(balance/EACH_FIVE_POİNTS_FOR_THE_BALANCE_RATE));
    creditScore = creditScore+(5*(annualSalary/EACH_FIVE_POİNTS_FOR_THE_ANNUAL_SALARY));
    creditScore = creditScore-(20*latePayments);

    //We print applicant's credit score
    System.out.println("Your credit score: "+(int)creditScore);

    //Now we can decide if the applicant gets bank loan or not
    if(creditScore<650.0)
    {
        System.out.printf("Loan application denied. Reason:\n-Low credit score. It must be at least 650\n ");
    }
    if(debt>50000.0)
    {
        System.out.printf("Loan application denied. Reason:\n-Total debt exceeds the limit of 50.000\n ");
    }
    if(annualSalary<30000.0)
    {
        System.out.printf("Loan application denied. Reason:\n-Annual salary is too low. It must be at least 30.000\n ");
    }
    if(balance<5000.0)
    {
        System.out.printf("Loan application denied . Reason:\n-Balance is too low. It must be at least 5000\n ");
    }
    if(!(balance<5000.0 || annualSalary<30000.0 || debt>50000.0 || creditScore<650.0))
    {
        System.out.println("Congratulations! You are eligible for a bank loan ");
    }

    in.close();   
 }   
}
