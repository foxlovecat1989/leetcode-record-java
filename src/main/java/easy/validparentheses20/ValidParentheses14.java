package easy.validparentheses20;

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
        Map<Character, Character> leftSideMap = getLeftSideMap();

        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            boolean isLeftSide = leftSideMap.get(currentChar) != null;
            if (isLeftSide) {
                stack.add(currentChar);
            } else {
                if (stack.isEmpty() || leftSideMap.get(stack.get(stack.size() - 1)) != currentChar) {
                    return false;
                }

                stack.remove(stack.size() - 1);
            }
        }

        return stack.isEmpty();
    }

    private static Map<Character, Character> getLeftSideMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');

        return map;
    }
}
