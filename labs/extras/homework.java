/**
 * Mehmet Efe Mutlu 
 * 22303326
 * This program compares two different algortihms'time intervals.
 */
public class homework 
{
    public static void main(String[] args) 
    {

        //Makes calls to calcFibA for values of 𝑛 from 0 to 50 with increments of 5 (0, 5, 10, …, 50),and measure and record the running times (in nanoseconds) 
        int n = 0;
        for(int i=0; i<=6; i++)
        {
            long startTime1 = System.nanoTime();
            calcFibA(n);
            long endTime1 = System.nanoTime();
            
            System.out.printf(i + "  a" + i + "  // ");
            System.out.println("for n=" + n + ", " + " F_" + n + " is calculated in " + (endTime1-startTime1) + " nanoseconds. ");

            n = n+5;
        }
        System.out.println();

        //Makes calls to calcFibA for values of 𝑛 from 0 to 50 with increments of 5 (0, 5, 10, …, 50),and measure and record the running times (in nanoseconds)
        int m = 0; 
        for(int i=0; i<=6; i++)
        {
            //nanotime() is a method under the System class 
            long startTime2 = System.nanoTime();
            calcFibB(m);
            long endTime2 = System.nanoTime();

            System.out.print(i + "  b" + i + "  // ");
            System.out.println("for n=" + m + ", " + " F_" + m + " is calculated in " + (endTime2-startTime2) + " nanoseconds. ");

            m = m+5;
        }
    }
    /**
     * This recursive method calculates the modified fibonacci series of nth place 
     * @param n is the nth place method will calculate
     * @return the result
     */
    public static long calcFibA(int n)
    {
        if(n < 2) 
        {
        return n;
        }
        return calcFibA(n-1) + 6 * calcFibA(n-2);
    }
    /**
     * This method calculates modified fibonacci series starting from the first number and works up until the end
     * @param n is the nth place method will calculate
     * @return the result
     */
    public static long calcFibB(int n)
    {
        if (n<2)
        { 
            return n;
        }
        long result = 0;
        long prev = 0;
        long next = 1;
        for(int i=2; i<=n; i++)
        {
            result = next + 6 * prev;
            prev = next;
            next = result;
        }
        return next;
    }
    
}
