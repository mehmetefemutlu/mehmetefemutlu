/**
 * lab07_Q2
 */
import java.util.Arrays;
import java.util.Scanner;

public class lab07_Q2 
{
    public static void main(String[] args) 
    {
        //We take inputs from the user
        Scanner in = new Scanner(System.in);

        //We ask user to decide how many integers long will the array be
        System.out.print("Please enter the number of elements you want to sort: ");
        int n = in.nextInt();

        //We create the array1 and insert inputs into the array
        int [] arr1 = new int[n];
        for(int i=0; i<n; i++)
        {
            System.out.print("Enter the numbers: ");
            arr1[i] = in.nextInt();
        }     
        //We print out the first and sorted version of the array
        System.out.println("Before sorting: " + Arrays.toString(arr1));
        sortArray(arr1);
        System.out.println("After sorting: " + Arrays.toString(arr1));

        //We ask user to decide the array range again and we ask the last index to be sorted 
        System.out.print("Please enter the number of elements you want to sort: ");
        int m = in.nextInt();
        System.out.print("Please enter the last index you want to sort: ");
        int p = in.nextInt();

        //We create the array2 and insert inputs into the array
        int [] arr2 = new int[m];
        for(int i=0; i<m; i++)
        {
            System.out.print("Enter the numbers: ");
            arr2[i] = in.nextInt();
        } 
        //We print out the first and sorted version of the array
        System.out.println("Before sorting: " + Arrays.toString(arr2));
        sortArray(arr2, p);
        System.out.println("After sorting: " + Arrays.toString(arr2));

        in.close();
    }
    /**
     * This method sorts the array in ascending order
     * @param list is the array list we take
     */
    public static void sortArray(int[] list)
    {
        //We create two for loops nested and sort it in ascending order
        for(int i =0; i<list.length-1; i++) 
        {
            for (int j = 0; j < list.length-i-1; j++) 
            {
                if (list[j] > list[j + 1]) //If the preceeding number is less than the right after it we swap it
                {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        } 
    }
    /**
     * This method sorts the array in ascending order until a given index
     * @param list is the array list we take
     * @param n is the last index
     */
    public static void sortArray(int [] list, int n)
    {
        //We create two for loops nested and sort it in ascending order
        for(int i =0; i<n-1; i++) 
        {
            for (int j = 0; j < n-i-1; j++) 
            {
                if (list[j] > list[j + 1])//If the preceeding number is less than the right after it we swap it
                {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        } 
    }
}
