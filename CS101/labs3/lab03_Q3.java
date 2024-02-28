import java.util.Random;
import java.util.Scanner;
/**
 * This class is used for creating a simple social media platform 
 * Student Number: Mehmet Efe Mutlu
 * Student ID: 22303326
 */
public class lab03_Q3 
{
    public static void main(String[] args) 
    { 
        //This is for taking inputs from the user
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = in.next();
        String correctUsername = "cupcake";

        //We ask user to enter his/her username and password
        if(!(username.equals(correctUsername)))
        {
            System.out.println("Username not found! Bye ");
        }
        else
        {
            System.out.print("Enter your passsword: ");
            String password = in.next();
            String correctPassword ="pancake";
        
            if(!(password.equals(correctPassword)))
            {
                System.out.println("Wrong password! Bye ");
            }
            else
            {
                //We must display the operation console
                String addFriend = "1- Add friend";
                System.out.println(addFriend);

                String deleteFriend = "2- Delete friend";
                System.out.println(deleteFriend);

                String addPost = "3- Add post";
                System.out.println(addPost);

                String deletePost = "4- Delete post";
                System.out.println(deletePost);

                String logout = "5- Logout";
                System.out.println(logout);

                //These are the previous friends of the user
                String userFriend1 = "lindaSmith";
                String userFriend2 = "johnJones";   
                String userFriend3 = "danielMartin";

                //These are post IDs of the previous contents 
                int postID1 = 199;
                int postID2 = 164;

                //These are contents of the previous posts                  
                String posts = "Today is a great day. Post199: I like Java.";

                System.out.print("Select an operation: "); 
                int operator = in.nextInt();           

                if(operator == 1)
                {    
                    //We check here whether the selected person is in the friend list of the user
                    System.out.println("-- Add Friend --");
                    System.out.print("Enter the username of your friend: ");
                    String addFriendName = in.next();

                    if(addFriendName.equals(userFriend1) || addFriendName.equals(userFriend2) || addFriendName.equals(userFriend3))
                    {
                        System.out.println("This user is already your friend! ");
                        System.out.println( "Your friends: ( " + userFriend1 + "," + userFriend2 + "," + userFriend3 + ")");
                    }
                    else
                    {
                        System.out.println("New friend " + addFriendName + " is added " );
                        System.out.println( "Your friends: ( " + userFriend1 + "," + userFriend2  + "," + userFriend3 + "," + addFriendName + ")");         
                    }  
                }   
                else if(operator == 2)
                {
                    //We check here whether the selected person is in the friend list of the user
                    System.out.println("-- Delete Friend --");
                    System.out.print("Enter the username which you want to delete: ");
                    String deleteFriendName = in.next();

                    if(deleteFriendName.equals(userFriend1))
                    {
                        System.out.println(deleteFriendName + " deleted succesfully from your friends! ");
                        System.out.println("Your friends: ( " + userFriend2 + "," + userFriend3 + ")");
                    }
                    else if(deleteFriendName.equals(userFriend2))
                    {
                        System.out.println("Your friends: ( " + "," + userFriend1 + "," + userFriend3 + ")");
                    }
                    else if(deleteFriendName.equals(userFriend3))
                    {
                        System.out.println("Your friends: ( " + userFriend1 + "," + userFriend2 + ")");
                    }
                    else
                    {
                        System.out.println("You don't have any friends whose username is " +deleteFriendName);
                        System.out.println("Your friends: ( " + userFriend1 + "," + userFriend2 + "," + userFriend3 + ")");
                    }
                }
                else if(operator == 3)
                {
                    //We check here whether post ID of the new content overlaps the postIDs of the previous content
                    System.out.println("-- Add Post --");
                    System.out.print("Enter post content: ");
                    in.nextLine();
                    String addNewPost = in.nextLine();

                    //New postID is a random number which is going to be generated by the program
                    Random postID = new Random();
                    int newPostID = 100 + postID.nextInt(999);

                    if(newPostID == postID1)
                     {
                        System.out.println("There is a post with the id " + postID1 + " you cannot add a new post with the same id! ");
                        System.out.println("Your posts: " + posts);
                     }
                    else if(newPostID == postID2)
                     {
                        System.out.println("There is a post with the id " + postID2 + " you cannot add a new post with the same id! ");
                        System.out.println("Your posts: " + posts);
                     }
                    else
                     {
                        System.out.println("New post with the id " + newPostID + " is added ");
                        System.out.print("Your posts: Post164: " + posts + " Post" + newPostID + ": " + addNewPost);
                     }
                }
                else if(operator == 4)
                {
                   //We check here whether the ID which user chose exists
                   System.out.println("-- Delete Post --");
                   System.out.print("Enter postID which you want to delete: ");
                   int deleteOldPost = in.nextInt();

                   if(deleteOldPost == postID1)
                   {
                       System.out.println("The post with the " + postID1 + " is deleted succesfully");
                       System.out.println("Your posts: " +posts.replace("Post199: I like Java.",""));
                   }
                   else if(deleteOldPost == postID2)
                   {
                       System.out.println("The post with the " + postID2 + " is deleted succesfully");
                       System.out.println("Your posts: " + posts);
                   }
                   else 
                   {
                       System.out.println("You don't have any post with the id " +deleteOldPost);
                       System.out.println("Your posts: " +posts.replace("Post164: Today is a great day.",""));
                   }  
                }
                else if(operator == 5)
                {
                       //To display that user logged out succesfully
                       System.out.println("Logged out succesfully "); 
                }                                   
            }
        }
        
        in.close();
    }  
}
