/*
 * Student Name: Mehmet Efe Mutlu
 * Student ID: 22303326
 * This code is for reversing the input but eliminating trailing zeros
 */
import java.util.Scanner;

public class labs04_Q2 
{
    public static void main(String[] args) 
    {
        //This is for taking inputs from the user by calling Scanner class
        Scanner in = new Scanner(System.in);

        System.out.print("Please input n: ");

        //We make sure that user entered a integer value
        while(in.hasNextInt())
        {
            int n = in.nextInt();
  
            //We should eliminate trailing zeros
            while(n%10==0)
            {
                n=n/10;
            }

            //Now, we should count the number of digits by defining checker number and counter
            int checker=n;
            int counter =0;
            while(checker>0)
            {
                counter++;
                checker=checker/10;   
            }

            //Last we should print the numbers in order
            double digit =0;
            
            while(n>0)
            {
                //By doing this operation we are eliminating the zeros in the digits so we can print the number correctly
                digit = (n%10) *Math.pow(10,counter-1);
                digit = digit/(Math.pow(10,counter-1));

                //We are dividing n to 10 every time and we are decrementing counter every time
                n=n/10;
                counter--;
                System.out.print((int)digit);
                
            } 
            //After the iteration is done we ask user again to enter an input
            System.out.println();
            System.out.print("Please input n: ");
            in.nextLine();
        }
        in.close();    
    }
}
