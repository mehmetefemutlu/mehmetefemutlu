import java.util.Scanner;
/**
 * labs06
 */
public class labs06 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a non-negative integer: ");

        //We define flag so that when user enters valid input loop is ended
        boolean isFound = false;
        do
        {
            //We prompt user to enter an integer
            while(!in.hasNextInt())
            {
                System.out.println("You have entered invalid input: ");
                System.out.print("Enter a non-negative integer: ");
                in.nextLine();    
            }
            int n = in.nextInt();

            //If user enters an integer we check that if it's positive
            if(n<=0)
            {
                System.out.println("You have entered negative integer");
                System.out.print("Enter a non-negative integer: ");
                in.nextLine();
            }
            //If input is valid we call the method
            else
            {   
                displayFactorial(n,calculateFactorial(n));
                isFound = true;
            }
        }    
        while(!isFound);

        System.out.println(); 
        System.out.print("Enter a positive integer: ");

        boolean isEnd = false;
        do
        {
            //We prompt user to enter an integer
            while(!in.hasNextInt())
            {
                System.out.println("You have entered invalid input: ");
                System.out.print("Enter positive integer: ");
                in.nextLine();    
            }
            int n = in.nextInt();
            //If user enters an integer we check that if it's positive
            if(n<=0)
            {
                System.out.println("You have entered negative integer");
                System.out.print("Enter a positive integer: ");
                in.nextLine();
            }
            //If input is valid we call the methods
            else
            {   if(isPerfect(n))
                {
                    System.out.println(n + " is a perfect number");
                }
                else
                {
                    System.out.println(n + " is NOT a perfect number");
                }
                isEnd = true;
            }
        }    
        while(!isEnd);

        System.out.println();

        System.out.print("Enter the first natural number: ");
        int n1 = in.nextInt();

        System.out.print("Enter the second natural number: ");
        int n2 = in.nextInt();

        System.out.println("The binary representation of the first number " + intToBinary(n1));
        System.out.println("The binary representation of the second number " + intToBinary(n2));
        System.out.println("The bitwise NOR operation result " + binaryNOR(n1, n2));
        System.out.println("The bitwise NOT operation result on both numbers,respectively " + binaryNOT(n1) + " and " + binaryNOT(n2));
        System.out.println();

        labs06_Q2.main(args);

        in.close();
    }
    /**This method calculates the given the number's factorial
     * @param n 
     * @return 
     */
    public static long calculateFactorial(int n)
    {
        long value = 1;
        for(int i=1; i<=n; i++)
        {
            value *= i;
        }
        return value;
    }
    /**This method displays the calculated value
     * @param n 
     * @param factorial 
     */
    public static void displayFactorial(int n, long factorial)
    {
        System.out.println("The factorial of " + n + " is: " + factorial);
    } 
    /**
     * This method finds the given number's proper divisors
     * @param number
     * @return
     */
    public static String getProperDivisors(int number)
    {
        String divisors = "";
        for(int i=1; i<number; i++)
        {
            if(number%i==0)
            {
                divisors += i + " ";
            }
        }
        return divisors;
    }
    /**
     * This method takes the string and parse the integers in it and calculates their sum
     * @param number
     * @return
     */
    public static boolean isPerfect(int number)
    {
        int m = 0;
        int value = 0;
        for(int i=0; i<getProperDivisors(number).length();i++)
        {
            if(getProperDivisors(number).charAt(i)==' ')
            {
                String everyDivisor = getProperDivisors(number).substring(m,i);
                m = i+1;
                value += Integer.parseInt(everyDivisor);
            }
        }
        //If sum is equal to given number it returns true if not it returns false
        if(value==number)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * This method returns the given integer to binary form
     * @param n
     * @return
     */
    public static long intToBinary(int n)
    {  
        if(n<2)
        {
            return n;
        }
        else
        {
            long value = 0;
            int power = 0;
            while(n>0)
            {
                if(n%2!=0)
                {
                    value += Math.pow(10, power);
                }
                power++;
                n = n/2;
            }
            return value;
        }
    }
    /**
     * This method compares two integers binary bitwises and return nor operation
     * @param n1
     * @param n2
     * @return
     */
    public static long binaryNOR(int n1, int n2)
    {
        String one = "" + intToBinary(n1);
        String two = "" + intToBinary(n2);
        String norOperator = "";
        for(int i=0; i<Math.min(one.length(),two.length()); i++)
        {
            if(one.charAt(i)=='0' && two.charAt(i)=='0')
            {
                norOperator += 1;
            }
            else
            {
                norOperator += 0;
            }
        }
        return Long.parseLong(norOperator);
    }
    /**
     * This method returns the given binary code reverse 
     * @param n
     * @return
     */
    public static long binaryNOT(int n)
    {
        String reversed = "" + intToBinary(n);
        
        reversed = reversed.replace('1','*');
        reversed = reversed.replace('0','+');
        reversed = reversed.replace('+','1');
        reversed = reversed.replace('*','0');
  
        return Long.parseLong(reversed);
    }
    /**
     * labs06_Q2
     */
    public class labs06_Q2 
    {
        public static void main(String[] args) 
        {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the geometric shape(rectangle or circle): ");

            //We define flag that when user enters valid input it terminates the loop
            boolean isFound = false;
            while(!isFound)
            {
                String input = in.next();

                //If user enters rectangle we call rectangle methods
                if(input.equals("rectangle"))
                {
                    System.out.print("Enter the width of the rectangle: ");
                    double width = in.nextDouble();

                    System.out.print("Enter the height of the rectangle: ");
                    double height = in.nextDouble();

                    System.out.println("Rectangle Area: " + roundToTwoDecimalPlaces(calculateRectangleArea(width, height)));
                    System.out.println("Rectangle Perimeter: " + roundToTwoDecimalPlaces(calculateRectanglePerimeter(width, height)));

                    isFound = true;
                    
                }
                //If user enters circle we call circle methods
                else if(input.equals("circle"))
                {
                    System.out.print("Enter the radius of the circle: ");
                    double radius = in.nextDouble();

                    System.out.println("Circle Area " + roundToTwoDecimalPlaces(calculateCircleArea(radius)));
                    System.out.println("Circle Perimeter: " + roundToTwoDecimalPlaces(calculateCirclePerimeter(radius)));

                    isFound = true;
                }
                //If user enters invalid input we ask it again
                else
                {
                    System.out.println("You've supposed to enter a spesific shape ");
                    System.out.print("Enter the geometric shape(rectangle or circle): ");
                    in.nextLine();
                }
            }
            in.close(); 
            return;
        }
        /**
         * This method calculates rectangle's area 
         * @param width
         * @param height
         * @return
         */
        public static double calculateRectangleArea(double width, double height)
        {
            return width*height;
        }
        /**
         * This method calculates rectangle's perimeter
         * @param width
         * @param height
         * @return
         */
        public static double calculateRectanglePerimeter(double width, double height)
        {
            return (width+height)*2;
        }
        /**
         * This method calculates circle's area
         * @param radius
         * @return
         */
        public static double calculateCircleArea(double radius)
        {
            return Math.pow(radius,2)*Math.PI;
        }
        /**
         * This method calculates circle's perimeter
         * @param radius
         * @return
         */
        public static double calculateCirclePerimeter(double radius)
        {
            return 2*Math.PI*radius;
        }
        /**
         * This method rounds areas and perimeter to two decimal places
         * @param value
         * @return
         */
        public static double roundToTwoDecimalPlaces(double value)
        {
            int twoDecimal = (int)(value*100);
            int rounded = (int)(value*1000);
            if(rounded%10>=5)
            {
                twoDecimal ++;
            }
            return twoDecimal/100.0;
        }
    }        
}




