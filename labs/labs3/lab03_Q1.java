import java.util.Scanner;

/**
 * This program is for deciding whether a triangle can be formed  by the given lengths via triangle inequality theorem
 * Student Name: Mehmet Efe Mutlu
 * Student ID: 22303326
 */
public class Lab03_Q1 
{
    public static void main(String[] args) 
    {
        //Let (ABC) defined as a triangle
        //Triangle inequality theorem notation is: |AB-BC|<AC<(AB+BC),provided that AB,BC and AC are the lengths of a triangle
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the length of first side: ");
        double firstLength = in.nextDouble();

        System.out.print("Enter the length of second side:");
        double secondLength = in.nextDouble();

        System.out.print("Enter the length of third side: ");
        double thirdLength = in.nextDouble();

        //Then we use triangle inequality theorem to decide if it can be a triangle or not 
        if(Math.abs(firstLength - secondLength)> thirdLength || thirdLength>(firstLength + secondLength))
        {
            System.out.println("The given side lengths CANNOT form a triangle ");     
        }
        else
        {
            System.out.println("The given side lengths CAN form a triangle  ");
        }

        in.close();
    }    
}
