/*
 * File:    P1DeterminePi.java
 * Date:    Oct 01, 2016
 * Student: Devang Doshi | UCID: dbd24
 * Course:  Programming, Data Structure, and Alogrithms | Section: CS50581 
 * Desc:    The program will do an experiment of choosing points at random, 
 *          within a unit square which has a circle inscribed in it,
 *          an arbitrarily large number of times and use the ratio of the 
 *          number of points which lie within the circle to the number of 
 *          points within the unit square (all of them) to determine the value
 *          of π
 * Usage:   The program takes a random size of sqaure and inscribes a circle 
 *          inside the square. The diameter of the circle will be same as the 
 *          size of the side of the square.
 *          The program will prompt user to enter a number and will run the 
 *          experiment that many number of times by generating random points 
 *          and determine if the point lies within circle or square.
 *          The final output shows the above numbers, its ratio and also 
 *          determines the value of pi by multiplying the ratio by 4
 */

/**
 *
 * @author Devang
 */

// Imports
import java.util.Random;
import java.util.Scanner;

public class P1DeterminePi {
   public static void main(String args[]){
       int squareSide = newSquare();
       printLine("");
       int n = getInt("How many times you want to run the experiment?");
       newExperiment(n, squareSide);
       
   }
   
   /** This function creates a new square and circle of a random size and
    *  displays the basic properties 
     * @return the size of the side of the square
    */
   public static int newSquare(){
       int side=newRandom(1, 100);
       
       // Print properties of a square
       printLine("Square");
       printLine("------");
       printLine("- Side of the square: " + side + " units");
       printLine("- Area of the square: " + (side * side) + " sq. units");
       printLine("- Perimeter of the square: " + (4 * side) + " units");
       printLine("");
       
       // Print properties of a circle
       printLine("circle");
       printLine("------");
       printLine("- Diameter of a circle: " + side + " units");
       printLine("- Radius of a circle: " + side/2 + " units");
       printLine("- Area of a square: " + ((22 * side * side)/7) + " sq. units");
       printLine("- Circumference of the square: " + ((2 * 22* side)/7) + " units");
       
       return side;
   }
   
   
   /** This function generates a random number between a range of two 
    *  numbers 
     * @param minvalue 
     * @param maxvalue
     * @return random number
    */
   public static int newRandom(int minvalue, int maxvalue){
        if(minvalue >= maxvalue){
            return 0;
        } else {
            Random rand1 = new Random();
            int randomNum = rand1.nextInt((maxvalue - minvalue) + 1) + minvalue;
            return randomNum;
       }
   }
   
   /** This function prints a line
     * @param printtext
    */
   public static void printLine(String printtext){
        System.out.println(printtext);
   }
   
   
   /** This function get a integer input from the user
     * @param question
     * @return int input from the user
    */
   public static int getInt(String question){
        printLine(question);
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        return userInput;
   }
   
   
   /** This function get a integer input from the user
     * @param times
     * @param range
    */
   public static void newExperiment(int times, int range){
       //Variables
       int c = 0;
       int s = 0;
       int x, y;
       int radius = (range/2);
       double pi;
       
       //Run Experiment
       printLine("");
       printLine("#. ( x,y ) Circle?");
       printLine("---------------------------------");
       for(int i=0; i< times; i++){ 
           x = newRandom(-radius, radius);
           y = newRandom(-radius, radius);
           
           
           //Determine if it is within cirlce
           
           if(((x * x)+(y * y)) < (radius * radius)){
               c++;
               printLine(i + ". (" + x + ", " + y + ")*");
           } else {
               printLine(i + ". (" + x + ", " + y + ")");
           }
       }
       printLine("");
       printLine("Points within Circle = " + c);
       
       //Calculate pi
       pi=(double)(4*c)/times;
       printLine("Value of Pi = " + pi);
   }
   
}