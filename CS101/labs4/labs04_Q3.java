/*
 * Student Name: Mehmet Efe Mutlu
 * Student ID: 22303326
 * This program is for calculating the given number's Collatz sequence
 */


import java.util.Scanner;

public class labs04_Q3 
{
    public static void main(String[] args) 
    {
        //We take inputs from the user by calling Scanner class
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a positive number for the Collatz sequence: ");
        int n =in.nextInt();

        //We initialize the value to n so we can use n at the print statement without changing it
        int value =n;
        System.out.print("Collatz sequence for " +n + ": " +value);

        //We keep this process until the sequence reaches one
        while(value>1)
        {
            //If the value is even ve halve it
            while(value%2==0)
            {
            value/=2;
            System.out.print(", ");
            System.out.print(value);
            
            }
            //If the value is odd we multiply it with three and add one
            while(value%2!=0 && value>1)
            {
            value = value*3+1;
            System.out.print(", ");
            System.out.print(value);
            
            }
        }
       System.out.println();
       System.out.println();
       System.out.println("Program finished.");
   

     in.close();
    }
    
}
