/*
 * File:    P1DeterminePi.java
 * Date:    Oct 27, 2016
 * Student: Devang Doshi | UCID: dbd24
 * Course:  Programming, Data Structure, and Alogrithms | Section: CS50581 
 * Desc:    The program will test rational numbers (floats) and convert them 
 *          into a fractions. It will then perform basic aritmethic operations
 *          two fractions i.e. add, subtract, multiplication, and division.
 
/**
 *
 * @author Devang
 */

 public class RationalNumbers {
     
     public static void main (String[] args) {
       
       test(new Rational(1.2), new Rational(2.4));
       test(new Rational(10.7), new Rational(5.8));
       test(new Rational(195.2), new Rational(287.4));
       test(new Rational(-5.6), new Rational(-2.1));
       
     }   
   
   public static void test(Rational one, Rational two) {
       System.out.println ("[" + one.toDouble() + ", " + two.toDouble() + "]");
       System.out.format ("%8s : %s + %s = %s = %.2f%n", "Add", one.toString(), two.toString(), one.add(two).toString(), one.add(two).toDouble());
       System.out.format ("%8s : %s - %s = %s = %.2f%n", "Subtract", one.toString(), two.toString(), one.subtract(two).toString(), one.subtract(two).toDouble());
       System.out.format ("%8s : %s x %s = %s = %.2f%n", "Multiply", one.toString(), two.toString(), one.multiply(two).toString(), one.multiply(two).toDouble());
       System.out.format ("%8s : %s / %s = %s = %.2f%n", "Divide", one.toString(), two.toString(), one.divide(two).toString(), one.divide(two).toDouble());
       System.out.println();
   }
}
 
class Rational {
    private int numerator, denominator;
    
    public Rational (double frac) {
        createFraction (frac);
    }
    
    //Public Method add
    public Rational add (Rational y) {
        Rational result = new Rational (0.0);
        result.numerator = (this.numerator * y.denominator) + (this.denominator * y.numerator);
        result.denominator = this.denominator * y.denominator;
        result.simplify ();
        return result;
    }
    
    //Public Method Subtract
    public Rational subtract (Rational y) {
        Rational result = new Rational (0.0);
        result.numerator = (this.numerator * y.denominator) - (this.denominator * y.numerator);
        result.denominator = this.denominator * y.denominator;
        result.simplify ();
        return result;
    }
    
    //Public Method Multiplication
    public Rational multiply (Rational y) {
        Rational result = new Rational (0.0);
        result.numerator = this.numerator * y.numerator;
        result.denominator = this.denominator * y.denominator;
        result.simplify ();
        return result;
    }
    
    //Public Method Division
    public Rational divide (Rational y) {
        Rational result = new Rational (0.0);
        result.numerator = this.numerator * y.denominator;
        result.denominator = this.denominator * y.numerator;
        result.simplify ();
        return result;
    }
    
    //Public toDouble
    public double toDouble () {
        return (double) this.numerator / this.denominator;
    }
    
    //Public toString
    public String toString () {
        return ("[" + this.numerator + " / " + this.denominator + "]");
    }
    
    //Private Method: Create Fraction
    private void createFraction (double frac) {
        int[] result = new int[2];
        String fstring = String.valueOf (frac);
        int decimals;
        
        decimals = fstring.length() - 1 - fstring.indexOf('.') ;
        
        this.numerator = (int) (frac * Math.pow(10, decimals));
        this.denominator = (int) (1 * Math.pow(10, decimals));
        this.simplify();
    }
    
    //Private Method: Find Greatest Common Factor
    private int gcf (int one, int two) {
        if (one == two || two == 0)
            return one;
        else
            return gcf (two, one % two);
    }
    
    //Private Method: Simplify
    private void simplify () {
        if (this.numerator !=0 && this.denominator != 0) {
            int factor = gcf (this.numerator, this.denominator);
            this.numerator /= factor;
            this.denominator /= factor;
        }
    }
}