/**
 * Polynomial Tester
 */
public class PolynomialTester {
    public static void main(String[] args) {

        //Coefficients 
        double [] factors = {3,12,-7,9};
        double [] factors2 = {2,5,2};
        double [] factors3 = {1,1};
        

        //Creates polynomial objects
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial(1, 2);
        Polynomial p3 = new Polynomial(factors2);
        Polynomial p4 = new Polynomial(factors3);

        //Tests the zero polynomial
        System.out.println(p1);
        System.out.println(p1.getTerm(0));        
        System.out.println(p1.getDegree());
        System.out.println(p1.eval(2));
        System.out.println(p1.eval2(2));
        System.out.println();

        //Tests the one-term polynomial
        System.out.println(p2);
        System.out.println(p2.getTerm(1));        
        System.out.println(p2.getDegree());
        System.out.println(p2.eval(2));
        System.out.println(p2.eval2(2));
        System.out.println();
        
        //Tests the poli-term polynomial
        System.out.println(p3);
        System.out.println(p3.getTerm(0));        
        System.out.println(p3.getDegree());
        System.out.println(p3.eval(4));
        System.out.println(p3.eval2(4));
        System.out.println();

        //Tests the addittion,substraction and multiplication methods
        System.out.println(p3.add(p4));
        System.out.println(p3.sub(p4));
        System.out.println(p3.mul(p4));

        //Tests the composition and division methods
        System.out.println(p3.compose(p4));


       
    }
}
