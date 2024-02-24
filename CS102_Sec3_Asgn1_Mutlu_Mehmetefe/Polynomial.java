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

    //Takes a degree and returns te term with that degree
    public String getTerm(int d){
        if(d<coefficients.length){
            String result = "" + coefficients[d];
            if(d!=0){
                result += "x^" + d;
            } 
            return result;
        }
        return null;
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
        //Assigns the lengths of the Polynomials
        int max = (list(this,p2))[0].coefficients.length;
        int min = (list(this,p2))[1].coefficients.length;

        double [] add = new double[max];
        
        //Fills the array accordingly
        for(int i=0; i<max; i++){
            if(i<min){
                add[i] = (list(this, p2))[0].coefficients[i] + (list(this, p2))[1].coefficients[i];
            }
            else{
                add[i] = (list(this, p2))[0].coefficients[i];
            }
        }   
        return new Polynomial(add);
    }

    //Substracts the two Polynomial and returns the result as new Polynomial
    public Polynomial sub(Polynomial p2){
        //Assigns the lengths of the Polynomials
        int max = (list(this,p2))[0].coefficients.length;
        int min = (list(this,p2))[1].coefficients.length;

        double [] sub = new double[max];
        
        //Fills the array accordingly
        for(int i=0; i<max; i++){
            if(i<min){
                sub[i] = (list(this, p2))[0].coefficients[i] - (list(this, p2))[1].coefficients[i];
            }
            else{
                sub[i] = (list(this, p2))[0].coefficients[i];
            }
        }   
        return new Polynomial(sub);
    }

    //Multiplies the two Polynomial and returns the result as new Polynomial
    public Polynomial mul(Polynomial p2){
        //Assigns the lengths of the Polynomials
        int max = (list(this,p2))[0].coefficients.length;
        int min = (list(this,p2))[1].coefficients.length;

        double [] mul = new double[coefficients.length + p2.coefficients.length -1];

        //Fills the array accordingly
        for(int i=0; i<max; i++){
            for(int j=0; j<min; j++){
                mul[i+j] += coefficients[i]*p2.coefficients[j];
                
            }
        }
        return new Polynomial(mul);
    }

    public Polynomial compose(Polynomial p2){

        Polynomial temp = new Polynomial(new ArrayList<>());
        

        double [] comp = new double[coefficients.length];

        for(int i=0; i<coefficients.length; i++){
           
        }
        return null;
    }

    public Polynomial div(Polynomial p2){
        return null;
    }

    public int [] findEqual(Polynomial p2){
        return null;
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
                    result += " + ";
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

    //Support method that lists the given Polynomials according to their lengths
    private Polynomial [] list(Polynomial p1, Polynomial p2){
        Polynomial [] arr = new Polynomial[2];

        if(p1.coefficients.length<=p2.coefficients.length){
            arr[0] = p2;
            arr[1]  =p1;
        }
        else{
            arr[0] = p1;
            arr[1] = p2;
        }
        return arr;
    }
}


