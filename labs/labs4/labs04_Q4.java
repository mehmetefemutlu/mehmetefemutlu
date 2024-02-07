/*
 * Student Name: Mehmet Efe Mutlu
 * Student ID: 22303326
 * This program randomly generates simple mathematical questions and so for
 */
import java.util.Random;
import java.util.Scanner;

public class labs04_Q4 
{
    public static void main(String[] args) 
    {
        //We take inputs from the user by calling the Scanner class
        Scanner in = new Scanner(System.in);
        //We call Random class to generate random number to randomly decide which operator shall program use
        Random random = new Random();

        //These are the variables to use inside the loop iteration
        int answer;
        int numberOne;
        int numberTwo;

        //We define a boolean operator to decide whether we go into to loop or not according to the user's choice
        boolean done = true;
        while(done)
        {
            double chosen = random.nextDouble();

            if(chosen<0.33)
            {
                numberOne = (int)(1+9*Math.random());
                numberTwo = (int)(1+9*Math.random());
                System.out.println("Question: " + numberOne + " * " + numberTwo + " = ? ");
                System.out.print("Your answer: ");
                answer = in.nextInt();
                if(answer == numberOne*numberTwo)
                {
                    System.out.println("Correct! Well done!");
                }
                else
                {
                    System.out.println("Incorrect. The correct answer is: " + numberOne*numberTwo);
                }

            }
            else if(chosen>=0.33 && chosen<0.66)
            {
                numberOne = (int)(1+9*Math.random());
                numberTwo = (int)(1+9*Math.random());
                System.out.println("Question: " + numberOne + " + " + numberTwo + " = ? ");
                System.out.print("Your answer: ");
                answer = in.nextInt();
                if(answer == numberOne + numberTwo)
                {
                    System.out.println("Correct! Well done!");
                }
                else
                {
                    System.out.println("Incorrect. The correct answer is: " + (numberOne + numberTwo));
                }
            }
            else 
            {
                numberOne = (int)(1+9*Math.random());
                numberTwo = (int)(1+9*Math.random());
                System.out.println("Question: " + numberOne + " - " + numberTwo + " = ? ");
                System.out.print("Your answer: ");
                answer = in.nextInt();
                if(answer == numberOne - numberTwo)
                {
                    System.out.println("Correct! Well done!");
                }
                else
                {
                    System.out.println("Incorrect. The correct answer is: " + (numberOne - numberTwo));
                }
            }
            //After asking the math question we ask user to decide that if he/she continue the quiz
            System.out.print("Do you wanna try another question?(yes/no): ");
            String decision = in.next();
            if(decision.equals("yes"))
            {
                //If user decides to continue we do not change anything keep iterating the loop
                done = true;
            }
            else if(decision.equals("no"))
            {
                //If not we change the boolean variable and exit the loop immediately
                done = false;
                System.out.println("Goodbye!");
                System.out.println();
                System.out.println("Program finished");
            }
            else
            {
                //If user enters something different we prompt user to enter a valid answer
                System.out.println("Enter a valid answer! ");
                System.out.print("Do you wanna try another question?(yes/no): ");
                decision = in.next();
            }
          
        }  
        in.close();
    }
    
}
