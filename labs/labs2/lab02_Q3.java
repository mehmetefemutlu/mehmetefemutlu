import java.util.Scanner;

public class lab02_Q3 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
    
        System.out.print("Enter the title:");
        String title = input.nextLine(); 
        
        String repetition = "-";
        int count = 37;  

        System.out.println(repetition.repeat(count));
        System.out.println("Number of characters:  " +title.length()); 
        System.out.println("All uppercase:  " +title.toUpperCase());
        System.out.println("Remove leadiing and trailing blank characters: " +title.substring(4, 22));              
        System.out.println("Character at inex position 8: " +title.charAt(8));
        System.out.println("Title at 5th character to 10th character: " +title.substring(5, 10));  
        System.out.println("First of occurence at character 'i': " +title.indexOf("i"));
        System.out.println("Last occurence at character 'e': " +title.lastIndexOf("e")); 

        input.close();       
    }    
}
