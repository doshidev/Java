/*
 * File:    P1DeterminePi.java
 * Date:    Oct 25, 2016
 * Student: Devang Doshi | UCID: dbd24
 * Course:  Programming, Data Structure, and Alogrithms | Section: CS50581 
 * Desc:    The program will accept rational numbers (floats) and convert them 
 *          into a fractions. It will then perform basic aritmethic operations
 *          two fractions i.e. add, subtract, multiplication, and division.
 * Usage:   The program prompts user to enter two fraction of upto two decimals
 *          and prints the fraction and the result of the four arithmetic
 *          operations. 
 */

/**
 *
 * @author Devang
 */

import java.util.Scanner;

 public class RationalNumbers {
     public static void main(String[] args){
       Rational a = new Rational(getDouble("Enter 1st double value:")); 
       Rational b = new Rational(getDouble("Enter 2nd double value:"));
       
       System.out.println("Addition: " + a.add(b).toString());
       System.out.println("Addition: " + a.add(b).toDouble());
       
       System.out.println();
              
       System.out.println("Subtraction: " + a.subtract(b).toString());
       System.out.println("Subtraction: " + a.subtract(b).toDouble());
       
       System.out.println();
              
       System.out.println("Multiplication: " + a.multiply(b).toString());
       System.out.println("Multiplication: " + a.multiply(b).toDouble());
       
       System.out.println();
              
       System.out.println("Division: " + a.divide(b).toString());
       System.out.println("Division: " + a.divide(b).toDouble());
       
     }
     
     
     /** This function get a double input from the user
     * @param question
     * @return double input from the user
    */
   public static double getDouble(String question){
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        double userInput = input.nextDouble();
        return userInput;
   }
}

class Rational{
    // Local Variables
    private int numerator, denominator;
    
    // Constructor
    public Rational(double frac) {
        createFraction(frac);
    }
    
    //Public Method add
    public Rational add(Rational y){
        Rational result = new Rational(0.0);    
        int factor;
        
        result.numerator =((this.numerator * y.denominator) + (this.denominator * y.numerator));
        result.denominator =(this.denominator * y.denominator);
        
        factor = gcf(result.numerator, result.denominator);
        result.numerator = (int) (result.numerator / factor);
        result.denominator = (int) (result.denominator / factor);
        
        return result;
    }
    
    
    //Public Method Subtract
    public Rational subtract(Rational y){
        Rational result = new Rational(0.0);    
        int factor;
        
        result.numerator =((this.numerator * y.denominator) - (this.denominator * y.numerator));
        result.denominator =(this.denominator * y.denominator);
        
        factor = gcf(result.numerator, result.denominator);
        result.numerator = (int) (result.numerator / factor);
        result.denominator = (int) (result.denominator / factor);
        
        return result;
    }
    
    
    //Public Method Multiplication
    public Rational multiply(Rational y){
        Rational result = new Rational(0.0);    
        int factor;
        
        result.numerator =(this.numerator * y.numerator);
        result.denominator =(this.denominator * y.denominator);
        
        factor = gcf(result.numerator, result.denominator);
        result.numerator = (int) (result.numerator / factor);
        result.denominator = (int) (result.denominator / factor);
        
        return result;
    }
    
    //Public Method Division
    public Rational divide(Rational y){
        Rational result = new Rational(0.0);    
        int factor;
        
        result.numerator =(this.numerator * y.denominator);
        result.denominator =(this.denominator * y.numerator);
        
        factor = gcf(result.numerator, result.denominator);
        result.numerator = (int) (result.numerator / factor);
        result.denominator = (int) (result.denominator / factor);
        
        return result;
    }
    
    
    //Public toDouble
    public double toDouble(){
        return ((double)this.numerator / this.denominator);
    }
    
    //Public toString
    public String toString(){
        return ("[" + this.numerator +" / " + this.denominator + "]");
    }
    
    //Private Method: Find Greates Common Factor
    private void createFraction(double frac){
        int[] result = new int[2];
        String fstring = String.valueOf(frac);
        int decimals;
        
        decimals = fstring.length() - 1 - fstring.indexOf('.') ;
        
        this.numerator = (int) (frac * Math.pow(10, decimals));
        this.denominator = (int) (1 * Math.pow(10, decimals));
    }
    
    //Private Method: Find Greatest Common Factor
    private int gcf(int one, int two){
        
        if(one == two || two == 0)
            return one;
        else if(one < two)
            return gcf(one, two % one);
        else
            return gcf(two, one % two);
    }   
}