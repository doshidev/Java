import java.util.*;

/**
 * Convert Decimal to Roman
 * e.g. 1998 to "MCMXCVIII"
 * Created by Devang on 31-Dec-16.
 */
public class RomanNumbers {

    public static void main(String[] args){
        System.out.println(Roman(1979));
    }

    public static String Roman(int n){
        String roman = new String();
        while(n > 0) {
            for(Map.Entry<String, Integer> rn : RomanNumerals.romanNumerals.entrySet()){
                if(n >= rn.getValue()){
                    System.out.print(rn.getKey());
                    n-= rn.getValue();
                    break;
                }
            }
        }
        return roman;
    }
}