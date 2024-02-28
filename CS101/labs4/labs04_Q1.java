/*
 *Student Name: Mehmet Efe Mutlu
 *Student ID: 22303326
 * This program is for calculating number of prime numbers which user typed
 */
import java.util.Scanner;

public class labs04_Q1
{
    public static void main(String[] args) 
    {
        //We take inputs from the user by calling Scanner class
        Scanner in = new Scanner(System.in);
        System.out.print("Enter input n: ");

        boolean isEnd = false;
        while(!isEnd)
        {
            //We ensure that user enters an integer
            while(!in.hasNextInt())
            {
                System.out.println("You have not entered an integer!");
                System.out.print("Enter an integer: ");
                in.nextLine();
            }

            int n = in.nextInt();

            //When user enters a positive integer we let the process begin
            if(n>0)
            {
                //We define and initialize variables to help us decide whether number is prime or not
                int value =2;
                int checker =2;
                int counter =1;

                //We first print initial value
                System.out.print(value);
                value++;

                //We make sure that counter is still less than entered number
                while(counter<n)
                {
                    //First we check if the value can be divided to two  
                    boolean done = true;
                    while(value%checker!=0 && done)
                    {
                        checker++;
                        //When checker is equal to value this means entered number is prime
                        if(checker==value)
                        {
                            counter++;
                            done = false;
                            checker =2;
                            System.out.print(",");
                            System.out.print(value);
                        }
                    }
                    //Before iterating the loop again we increment the value
                    value++;
                }
                //When we reach our goal we terminate the program with exiting the loop
                isEnd = true;
            }    

            //If user enters a negative value we prompt user to enter a positive integer
            else
            {
                System.out.println("You have entered a negative integer");
                System.out.print("Enter a positive integer: ");
                in.nextLine();
            }
            
        }    
        in.close();

    }
}

