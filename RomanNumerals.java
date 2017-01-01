import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Devang on 31-Dec-16.
 */
public final class RomanNumerals {
    public static Map<String, Integer> romanNumerals = new LinkedHashMap<>();
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
