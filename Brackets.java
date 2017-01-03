/**
 * This program print out numbers in brackets, formatted as [1][2][3],
 * and so on. The method that takes two parameters: howMany and lineLength.
 * The method prints out line numbers from 1 to howMany in the above format,
 * but more than lineLength characters on any one line.
 * It does not not start a [ unless it can fit the corresponding ].
 *
 * Created by Devang on 01-Jan-17.
 */
public class Brackets {
    public static void main(String[] args){
        printBrackets(1000, 100);
    }

    public static void printBrackets(int howMany, int lineLength){
        int currentFill = 0;
        int newFill;

        for(int i = 1; i <= howMany; i++){
            newFill = String.valueOf(i).length() + 2;
            if(lineLength < currentFill + newFill){
                System.out.print("\n");
                currentFill = 0;
            }
            System.out.printf("[%d]", i);
            currentFill += newFill;
        }
    }
}