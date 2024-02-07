/*
 * lab07_Q3
 */
import java.util.ArrayList;
import java.util.Scanner;

public class lab07_Q3 
{
    public static void main(String[] args) 
    {
        //We take inputs from user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numbers(enter no to stop): ");

        //We create an array list to hold the inputs
        ArrayList<Integer> list = new ArrayList<>();  
        do
        { 
            int n = in.nextInt();
            //When user enters an integer we add it to the list
            if(n>=0 && n<=100)
            {
                System.out.print("Enter numbers(enter no to stop): ");
                list.add(n);
            }
            //If entered integer is out of range we ask it again
            else
            {
                System.out.println("Enter numbers(enter no to stop):Invalid number. Please enter a number between 0 and 100.");
                in.nextLine();
            }
        }
        while(in.hasNextInt());

        //We define variables to check the last index of most iterated bin
        int maxCount = 0;
        int count = 0;
        int position = 0;
        int lastPosition = 0;

        //We check the inputs one by one print stars for each range
        for(int n=0; n<=90; n +=10)
        {
            System.out.print(n + "-" + (n+10) + ": " );
            for(int m: list)
            {
                lastPosition++;
                if(m>=n && m<n+10)
                {
                    System.out.print("*");

                    //We check the most iterated bins last occurence
                    count++;
                    if(count>maxCount)
                    {
                        maxCount = count;
                        position = lastPosition-1;
                    }
                }
            }
            lastPosition = 0;
            count = 0;
            System.out.println();
        }
        //We find which bin is the most iterated bin
        int result = list.get(position)/10;
        System.out.print((result*10) + "-" + ((result*10)+10) + ": " );

        //Last, we find the numbers in the bin
        String most = "";
        for(int value : list)
        {
            if(value/10 == result)
            {
                most += "," + value;
            }
        }
        most = most.replaceFirst(",","");
        System.out.println(most);

    in.close();
    }  
}