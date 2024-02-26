/**
 * Polynomial Tester
 */
public class PolynomialTester {
    public static void main(String[] args) {

        //Coefficients 
        double [] factors = {3,4,1,3,0,2};
        double [] factors2 = {-4,-3,1};
        double [] factors3 = {2,1};
        

        //Creates polynomial objects
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial(1, 2);
        Polynomial p3 = new Polynomial(factors);
        Polynomial p4 = new Polynomial(factors3);

        //Tests the zero polynomial
        System.out.println(p1);
        System.out.println(p1.getCoefficient(0));        
        System.out.println(p1.getDegree());
        System.out.println(p1.eval(2));
        System.out.println(p1.eval2(2));
        System.out.println();

        //Tests the one-term polynomial
        System.out.println(p2);
        System.out.println(p2.getCoefficient(1));        
        System.out.println(p2.getDegree());
        System.out.println(p2.eval(2));
        System.out.println(p2.eval2(2));
        System.out.println();
        
        //Tests the poli-term polynomial
        System.out.println(p3);
        System.out.println(p3.getCoefficient(0));        
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
        System.out.println(p3.div(p4));


        //Tests the findEqual method
        if(p3.findEqual(p4).length!=0){
            System.out.print("{" + p3.findEqual(p4)[0]);
            for(int i=1; i<p3.findEqual(p4).length; i++){
                if(p3.findEqual(p4)[i]!=0)
                System.out.print("," + p3.findEqual(p4)[i]);
            }
            System.out.println("}");
        }
       
    }
}
