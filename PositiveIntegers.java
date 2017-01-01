/**
 * Write a program to determine all pairs of positive integers (a,b),
 * such that a < b < 1000 and (a2 + b2 + 1)/(ab) is an integer.
 *                             a to the power 2
 * Created by Devang on 31-Dec-16.
 */
public class PositiveIntegers {
    public static void main(String[] args){

        for(int a = 1; a < 1000; a++){
            for(int b = a + 1; b < 1000; b++){

                double mod = (Math.pow(a,2) + Math.pow(b,2) + 1) % (a * b);
                if(mod == 0)
                    System.out.println("(" + a +", " + b +")");
            }
        }
    }
}
