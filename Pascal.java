/*
 * File:    Pascal.java
 * Date:    Dec 21, 2016
 * Student: Devang Doshi | UCID: dbd24
 * Course:  Programming, Data Structure, and Alogrithms | Section: CS50581
 *          two fractions i.e. add, subtract, multiplication, and division.
 * Desc:    The program will generate Pascal Triangle using recursion.

/**
 *
 * @author Devang
 */
public class Pascal {
    public static void main(String args[]){
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 1;

        for (int i = 1; i <= n; ++i) {
            int[] arr = Pascal.triangle(i);
            System.out.print((i < 10 ? " " : "") + i + ": ");
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[] triangle(int i) {
        if (i == 1) {
            return new int[] { 1 };
        }
        int[] prevResult = triangle(i - 1);
        int[] result = new int[i];
        result[0] = 1;
        result[i - 1] = 1;
        for (int x = 1; x < i - 1; ++x) {
            result[x] = prevResult[x - 1] + prevResult[x];
        }
        return result;
    }


}
