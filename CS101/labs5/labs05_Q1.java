/*
 * Student Name: Mehmet Efe Mutlu
 * Student ID: 22303326
 * This program is to output a pyramid consist of letters
 */

import java.util.Scanner;

public class labs05_Q1 
{
    public static void main(String[] args) 
    {
        //We take input from the user by using Scanner class
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a number: ");

        int n = 0;
        
        //We define a flag that will continue the iteration until it is sure that input is valid
        boolean found = false;
        do
        {
            //This condition checks for valid inputs
            for(;!(in.hasNextInt());)
            {
                System.out.println("You have entered an invalid input");
                System.out.print("Please enter a number: ");
                in.next();
            }

            n = in.nextInt();

            //This condition checks for valid integers
            if(n<=0 || n>60)
            {
                System.out.println("You have entered a invalid integer");
                System.out.print("Please enter a valid integer: ");
            }

            //If this condition is applied we exit the loop immediately
            else
            {
                found = true;
            }
        }
        while(!found);

        //At the beginning of the iteration we define i so we could track lines according to n
        for(int i=1; i<=n; i++)
        {
            //We first print spaces and number of spaces is decreasing in an systematical order
            for(int j=n-i; j>=1; j--) 
            {
                System.out.print(" ");
            }

            //After printing the spaces, we print letters so that at each line there are line number times letters
            for(int m=0; m<=i-1; m++)
            {
                char ch = (char)('A'+ m);
                System.out.print(" ");
                System.out.print(ch);
            }

            //When each line is done correctly we move into the next line
            System.out.println();
        }

    in.close();    
    }
}