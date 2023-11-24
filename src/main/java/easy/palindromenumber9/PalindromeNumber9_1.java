package easy.palindromenumber9;

public class PalindromeNumber9_1 {
    public static void main(String[] args) {
        boolean resultA = isPalindrome(121);
        boolean resultB = isPalindrome(-121);
        boolean resultC = isPalindrome(10);

        System.out.println(resultA);
        System.out.println(resultB);
        System.out.println(resultC);
    }

    public static boolean isPalindrome(int x) {
        // edge case
        // negative number
        if (x < 0) {
            return false;
        }
        // 0 ~ 9
        if (x / 10 < 1) {
            return true;
        }

        String values = String.valueOf(x);
        for (int i = 0; i < (values.length() / 2) + 1; i++) {
            int lastIndex = values.length() - 1 - i;
            boolean isEqual = values.charAt(i) == values.charAt(lastIndex);
            if (!isEqual) {
                return false;
            }
        }

        return true;
    }
}
