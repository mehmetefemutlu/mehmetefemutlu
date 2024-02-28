import java.util.Scanner;

public class lab02_Q1 
{
  public static void main(String[] args)
  {
     Scanner input = new Scanner(System.in);
          
     System.out.print("Enter length of the radius of the cone : " );
     double radius = input.nextDouble();
   
     System.out.print("Enter length of the height of the cone : " );
     double height = input.nextDouble();
      
     System.out.println();

     double volume = (Math.PI/3)*(radius*radius*height);
     System.out.printf("The volume of the cone is ~ :  %.3f\n " ,volume);

     double SurfaceArea = Math.PI*radius*(radius + Math.sqrt((height*height) + (radius*radius)));
     System.out.printf("The surface area of the cone is ~ : %.3f " ,SurfaceArea);
      
     input.close(); 
  } 
} 