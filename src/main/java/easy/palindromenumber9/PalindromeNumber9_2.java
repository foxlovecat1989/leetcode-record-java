package easy.palindromenumber9;

public class PalindromeNumber9_2 {
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

        return x == reverseNumber(x);
    }

    public static int reverseNumber(int x) {
        int reverse = 0;
        while (x > 0) {
           int lastNumber = x % 10;
           reverse = reverse * 10 + lastNumber;
           x = x / 10;
        }

       return reverse;
    }
}
