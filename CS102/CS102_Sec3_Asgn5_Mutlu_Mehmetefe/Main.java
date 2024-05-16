/**
 * Main
 */
public class Main  {
    public static void main(String[] args) {
        //Creating Recursion objects
        Recursion rec1 = new Recursion();
        rec1.pattern1();
        rec1.print();
        System.out.println();

        Recursion rec2 = new Recursion();
        rec2.pattern2(5, 3);
        rec2.print();
        System.out.println();

        Recursion rec3 = new Recursion();
        rec3.pattern3();
        rec3.print();
        System.out.println();

        System.out.println(rec3.findMaxRowSum());
    }
}
