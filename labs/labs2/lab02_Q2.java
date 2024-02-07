import java.util.Scanner;

public class lab02_Q2 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
         System.out.print("Enter the cost of living for a student in Pound: ");
         double cost = input.nextDouble();

         double OnCampusAccomodation = cost*0.33; 
         double percentageOfAccomodation = (OnCampusAccomodation/cost)*100;

         double Transportation = cost*0.10;
         double percentageOfTransportation = (Transportation/cost)*100;

         double Food = cost*0.25;
         double percentageOfFood = (Food/cost)*100;

         double Utility = cost*0.12;
         double percentageOfUtility = (Utility/cost)*100;

         double Entertainment = cost*0.02;
         double percentageOfEntertainment = (Entertainment/cost)*100;

         double Groceries = cost*0.10;
         double percentageOfGroceries = (Groceries/cost)*100;

         double Clothes = cost*0.08;
         double percentageOfClothes = (Clothes/cost)*100;
        
         String repetition = "*";
         int count1 = 50;
         int count2 = 5;
         int count3 = 9;

        System.out.println();
        System.out.println(repetition.repeat(count1));
        System.out.println(repetition.repeat(count2) + "Student Life Cost Distribution Table" + repetition.repeat(count3));
        System.out.println(repetition.repeat(count1));
        
        System.out.printf(" * On-Campus Accomodation %8.0f %% %11.1f %-1s\n " , percentageOfAccomodation ,  OnCampusAccomodation, "*" );
        System.out.printf("* Transportation %16.0f %% %11.1f %-1s\n  " , percentageOfTransportation , Transportation,"*" );
        System.out.printf("* Food %25.0f %% %11.1f %-1s\n " , percentageOfFood , Food,"*" );
        System.out.printf("* Utility %23.0f %% %11.1f %-1s\n " , percentageOfUtility , Utility,"*" );
        System.out.printf("* Entertainment %17.0f %% %11.1f %-1s\n " , percentageOfEntertainment , Entertainment,"*" );
        System.out.printf("* Groceries %21.0f %% %11.1f %-1s\n " , percentageOfGroceries , Groceries,"*" );
        System.out.printf("* Clothes %23.0f %% %11.1f %-1s\n " , percentageOfClothes , Clothes,"*" );
        System.out.printf("* TOTAL %39.1f %-1s\n " , cost,"*" );
        
        System.out.println(repetition.repeat(count1));

        input.close();
        
    }
}
