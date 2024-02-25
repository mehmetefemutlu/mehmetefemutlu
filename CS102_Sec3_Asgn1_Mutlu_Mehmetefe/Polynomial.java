import java.util.ArrayList;

/**
 * Polynomial
 */
public class Polynomial {

    //Instance variable
    private double [] coefficients;

    //Constructor with no parameters
    public Polynomial(){
        coefficients = new double[1];
    }

    //Constructor with coefficient and degree parameter
    public Polynomial(int d, double c){
        coefficients = new double[d+1]; 
        coefficients[d] = c;  
    }

    //Constructor with coefficients parameter
    public Polynomial(double [] factors){
        coefficients = new double[factors.length];
        coefficients = factors;
    }

    //Takes a degree and returns the coefficient of that degree
    public double getCoefficient(int d){
        if(d<coefficients.length){
            double result = coefficients[d];
            return result;
        }
        return 0.0;
    }

    //Returns the highest coefficient's degree
    public int getDegree(){
        double max = coefficients[0];
        int position = 0;
        //Iterates through coefficients to find the biggest
        for(int i=1; i<coefficients.length; i++){
            if(coefficients[i]>max){
                max = coefficients[i];
                position = i;
            }
        }
        return position;
    }

    //Returns the evaluation of the polynomial at x 
    public double eval(double x){
        double result = 0;
        for(int i=0; i<coefficients.length; i++){
            result += Math.pow(x,i)*coefficients[i];
        }
        return result;
    }

    //Returns the evaluation of polynomial at x with Horner's method
    public double eval2(double x){
        double result = 0;
        if(coefficients.length>1){
            for(int i=coefficients.length-1; i>=0; i--){
                result = result*x + coefficients[i];
            }
        }
        return result;
    }

    //Adds the two Polynomial and returns the result as new Polynomial
    public Polynomial add(Polynomial p2){
        //Defines the new array with the length of the longer one
        int max = Math.max(coefficients.length,p2.coefficients.length);
        double [] add = new double[max];

        //Adds the coefficients of the ith degrees to the new coefficients array
        for(int i=0; i<max; i++){
            add[i] = this.getCoefficient(i) + p2.getCoefficient(i);
        }
        return new Polynomial(add);
    }

    //Substracts the two Polynomial and returns the result as new Polynomial
    public Polynomial sub(Polynomial p2){
        //Takes additive inverse of p2 adds it to the given Polyomial
        Polynomial p = new Polynomial(0,-1);
        p2 = p2.mul(p);
        return p2.add(this);
    }

    //Multiplies the two Polynomial and returns the result as new Polynomial
    public Polynomial mul(Polynomial p2){
        //Assigns the lengths of the Polynomials
        int max = Math.max(coefficients.length,p2.coefficients.length);
        int min = Math.min(coefficients.length,p2.coefficients.length);
        double [] mul = new double[coefficients.length + p2.coefficients.length -1];

        //Fills the array accordingly
        for(int i=0; i<max; i++){
            for(int j=0; j<min; j++){
                mul[i+j] += coefficients[i]*p2.coefficients[j];  
            }
        }
        return new Polynomial(mul);
    }

    //Composes the two Polynomial and returns the result as new Polynomial
    public Polynomial compose(Polynomial p2){
        //Creates a new Polynomial and adds the first term to it
        Polynomial p0 = new Polynomial();
        p0.coefficients[0] = this.coefficients[0];
        
        //Iterates over the length of Polynomial
        for(int i=1; i<coefficients.length; i++){
            //Creates a temporary Polynomial and assigns it to the Polynomial to be composed
            Polynomial p = new Polynomial();
            p = p.add(p2);
            //Assigns the i to a temporary position and multiplies p with itself i-1 many times
            int pos = i;
            while(i>1){
                p = p.mul(p2);
                i--;
            }
            i = pos;
            //Multiplies with the coefficient
            Polynomial p1 = new Polynomial(0,coefficients[i]);
            p = p.mul(p1);
            //Adds the p to the p0(result Polynomial)
            p0 = p0.add(p);       
        }
        return p0;       
    }

    public Polynomial div(Polynomial p2){
        return null;
    }

    //Searches and finds the range the common values x that makes this Polynomial equal to p2.
    public int [] findEqual(Polynomial p2){
        //Creates a zero Polynomial and assigns it to a the difference of this and p2
        Polynomial p3 = new Polynomial();
        p3 = p3.add(this.sub(p2));
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        //Searches in the range of [1,200] to find common x values
        for(int i=1; i<=200; i++){
            if(p3.eval(i)==0){
                arrList.add(i);
            }
        }

        //Assigns the values in the ArrayList to the Array
        int [] values = new int[arrList.size()];
        for(int i=0; i<arrList.size(); i++){
            values[i] = arrList.get(i);
        }
        return values;
    }

    //Returns the String representation of polynomial (Overriding)
    public String toString(){
        String result = "P(x) =";

        //Returns 0 when it is zero polynomial
        if(coefficients.length<=1){
            result += " " + coefficients[0];
            return result;
        }
        //Iterates through polynomial
        for(int i=0; i<coefficients.length; i++){
            //Skips the terms with zero coefficient
            if(coefficients[i]!=0){
                //Adds + when coefficient is positive
                if(coefficients[i]>0){
                    result += "+";
                }
                result += coefficients[i];
                //Skips the term with zero degree
                if(i!=0){
                    result += "x^" + i + " ";
                }
            }
        }
        return result;   
    }
}


