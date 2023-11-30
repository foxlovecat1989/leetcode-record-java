package easy.validparentheses;

import java.util.*;

public class ValidParentheses14 {
    public static void main(String[] args) {
        boolean resultA = isValid("()");
        System.out.println(resultA);

        boolean resultB = isValid("()[]{}");
        System.out.println(resultB);

        boolean resultC = isValid("(]");
        System.out.println(resultC);

        boolean resultD = isValid("{[]}");
        System.out.println(resultD);

        boolean resultE = isValid("(){}}{");
        System.out.println(resultE);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> leftPart = new HashMap<>();
        leftPart.put('[', ']');
        leftPart.put('(', ')');
        leftPart.put('{', '}');

        Map<Character, Character> rightPart = new HashMap<>();
        rightPart.put(']', '[');
        rightPart.put(')', '(');
        rightPart.put('}', '{');

        // first element is right part
        if (rightPart.get(s.charAt(0)) != null) {
            return false;
        }

        List<Character> store = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            boolean isLeftPart = leftPart.get(currentChar) != null;
            if (isLeftPart) {
                store.add(currentChar);
            } else {
                if (store.isEmpty() || store.get(store.size() - 1) != rightPart.get(currentChar)) {
                    return false;
                }

                store.remove(store.size() - 1);
            }
        }

        return store.isEmpty();
    }
}
