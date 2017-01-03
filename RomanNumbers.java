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

final class RomanNumerals {
    static Map<String, Integer> romanNumerals = new LinkedHashMap<>();
    static {
        romanNumerals.put("M", 1000);
        romanNumerals.put("CM", 900);
        romanNumerals.put("D", 500);
        romanNumerals.put("CD", 400);
        romanNumerals.put("C", 100);
        romanNumerals.put("XC", 90);
        romanNumerals.put("L", 50);
        romanNumerals.put("XL", 40);
        romanNumerals.put("X", 10);
        romanNumerals.put("IX", 9);
        romanNumerals.put("V", 5);
        romanNumerals.put("IV", 4);
        romanNumerals.put("I", 1);
    }
    private RomanNumerals() {}
}