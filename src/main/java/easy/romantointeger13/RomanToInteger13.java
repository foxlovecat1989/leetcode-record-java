package easy.romantointeger13;


import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {
    public static void main(String[] args) {
        int resultA = romanToInt("III");
        int resultB = romanToInt("LVIII");
        int resultC = romanToInt("MCMXCIV");
        System.out.println(resultA);
        System.out.println(resultB);
        System.out.println(resultC);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> symbols = getSymbols();

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int current = symbols.get(s.charAt(i));
            int next = symbols.get(s.charAt(i + 1));
            sum += current >= next ? current : -current;
        }
        int lastValue = symbols.get(s.charAt(s.length() - 1));

        return sum + lastValue;
    }

    private static Map<Character, Integer> getSymbols() {
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);

        return symbols;
    }
}
