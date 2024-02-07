/*
 * lab07_Q4
 */
import java.util.ArrayList;
import java.util.Scanner;

public class lab07_Q4 
{   
    public static void main(String[] args) 
    {
        //We take inputs from the user
        Scanner in = new Scanner(System.in);

        //We define a flag so that when user decides to exit loop terminates
        boolean done = false;
        //We define an array list for the cart because the size of the cart is dynamic
        ArrayList<String> cart = new ArrayList<>();
        //We define items and items prices as arrays because they are fixed
        String [] items = {"Apple","Banana","Milk","Bread"};
        double [] itemPrice = {1,0.75,2.5,1.5};
        //We define the total of our cart
        double total = 0.0;

        do
        {
            //We print the menu first and after every iteration
            System.out.println("Shopping Cart Menu: ");
            System.out.println("1.Add item to the cart: \n" + "2.Remove item from the card: \n" + "3.Print the item with the most occurences in the cart: \n" + "4.Print the total of the cart: \n" + "5.Exit" );
            System.out.print("Enter your choice: ");

            int n = in.nextInt();
            //If user enters an invalid choice we ask it again
            if(n<=0 || n>5)
            {
                System.out.println("This operation does not exist");
                System.out.println();
            }
            else 
            {
                //If user enters 1 we get to the adding operation
                if(n==1)
                {
                    System.out.println("Avaliable grocery items: ");
                    //We print the items wihch user can add
                    for(int i=0; i<items.length; i++)
                    {
                        System.out.println((i+1) + " " + items[i] + "- $" +itemPrice[i]);
                    }
                    System.out.println("Enter the number of the item add to the cart: ");
                    int m = in.nextInt();
                    //If user enters an invalid item number we ask it again
                    while(m>items.length || m<=0)
                    {
                        System.out.println("Invalid item number please try again");
                        m = in.nextInt();
                    }
                    //We add the chosen item to the cart and update our total
                    System.out.println(items[m-1] + " added to the cart");
                    total += itemPrice[m-1];
                    cart.add(items[m-1]);
                    System.out.println();
                }
                else if(n==2)
                {
                    //If the cart is empty we say there is nothing to remove
                    if(cart.size()==0)
                    {
                        System.out.println("The cart i empty nothing to remove");
                    }
                    else
                    {
                        System.out.println("Items in the cart");
                        //We print the items in the cart which user can remove
                        for(int i=0; i<cart.size(); i++)
                        {
                            System.out.println((i+1) + " " + cart.get(i));
                        }
                        System.out.println("Enter the number of item to remove from the cart: ");
                        int p = in.nextInt();
                        //If user enters an invalid item number we ask it again
                        while(p>cart.size() || p<=0)
                        {
                            System.out.println("Invalid item number please try again");
                            p = in.nextInt();
                        }
                        //We remove the chosen item from the cart and update our total
                        System.out.println(cart.get(p-1) + " removed from the cart");
                        total = total - itemPrice[p-1];
                        cart.remove(p-1);
                        System.out.println();
                    }
                }
                else if(n==3)
                {
                    //If the cart is empty we say there is nothing to count
                    if(cart.size()==0)
                    {
                        System.out.println("Cart is empty. No items to count");
                    }
                    else 
                    {
                        //To find the most common item we must count how many there are in the cart
                        int count = 0;
                        int maxCount = 0;
                        int most = 0;
                        for(int i=0; i<items.length; i++)
                        {
                            for(int j=0; j<cart.size(); j++)
                            {
                                if(cart.get(j)== items[i])
                                {
                                    count++;
                                }
                            }
                            //If our current count is bigger than max count we change the max count 
                            if(count>maxCount)
                            {
                                most = i;
                                maxCount = count;
                            }
                            count = 0;
                        }
                        System.out.println("The most common item on the cart: " + items[most]);
                    }
                }
                else if(n==4)
                {
                    //We print the total of the cart as user wished
                    System.out.println("Total price of the cart: " + total);
                    System.out.println();
                }
                else 
                {
                    //If user decides to exit we finish the loop
                    System.out.println("Exiting the program. Thank you!");
                    done = true;
                }
            }
        }
        while(!done);

        in.close();
    }
}
