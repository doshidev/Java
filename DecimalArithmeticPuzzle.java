import java.util.ArrayList;

/**
 * In the following decimal arithmetic puzzle, each of the ten different
 * letters is assigned a digit. Write a program that finds all possible
 * solutions (one of which is shown).
 *    MARK        A=1 W=2 N=3 R=4 E=5        9147
 * + ALLEN        L=6 K=7 I=8 M=9 S=0 +     16653
 *   -----                                  -----
 *   WEISS                                  25800
 *
 * Created by Devang on 01-Jan-17.
 */
public class DecimalArithmeticPuzzle {
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        permute(arr, 0);
    }

    public static void permute(int[] set, int pointer){

        if (pointer == set.length - 1) {
            validate(set);
            return;
        }

        for(int i = pointer; i < set.length; i++){
            int temp = set[pointer];
            set[pointer] = set[i];
            set[i] = temp;

            permute(set, pointer + 1);

            temp = set[i];
            set[i] = set[pointer];
            set[pointer] = temp;
        }

    }

    public static void validate(int[] array){
        char[] name = {'A','E','I','K','L','M','N','R','S','W'};
        int mark =  (array[5] * 1000)  + (array[0] * 100)  + (array[7] * 10)  + array[3]; //Mark
        int allen = (array[0] * 10000) + (array[4] * 1000) + (array[4] * 100) + (array[1] * 10) + array[6]; //Allen
        int weiss = (array[9] * 10000) + (array[1] * 1000) + (array[2] * 100) + (array[8] * 10) + array[8]; // Weiss

        if (!(mark + allen == weiss))
            return;

        System.out.print("{ ");

        for(int i =0; i < array.length; i++){
            System.out.print(name[i] + " = " + array[i] + "; ");
        }

        System.out.print("}");
        System.out.printf(" Mark [%d] + Allen [%d] = Weiss [%d]", mark, allen, weiss);
        System.out.print("\n");
    }
}
