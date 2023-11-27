package easy.longestcommonprefix14;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strsA = {"flower", "flow", "flight"};
        String resultA = longestCommonPrefix(strsA);
        System.out.println(resultA);

        String[] strsB = {"dog", "racecar", "car"};
        String resultB = longestCommonPrefix(strsB);
        System.out.println(resultB);

        String[] strsC = {"ab", "a"};
        String resultC = longestCommonPrefix(strsC);
        System.out.println(resultC);
    }

    public static String longestCommonPrefix(String[] strs) {
        int count = 0;
        boolean isDiffer = false;
        for (int index = 0; index < strs[0].length(); index++) {
            for (int j = 1; j < strs.length; j++) {
                boolean isIndexOutOfBound = index >= strs[j].length();
                if (isIndexOutOfBound || strs[0].charAt(index) != strs[j].charAt(index)) {
                    isDiffer = true;
                    break;
                }
            }
            if (isDiffer) {
                break;
            }

            count++;
        }

        return count != 0 ? strs[0].substring(0, count) : "";
    }
}
