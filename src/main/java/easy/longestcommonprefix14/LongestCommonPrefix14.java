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
        for (int indexOfPointer = 0; indexOfPointer < strs[0].length(); indexOfPointer++) {
            for (int indexOfElement = 1; indexOfElement < strs.length; indexOfElement++) {
                boolean isIndexOutOfBound = indexOfPointer >= strs[indexOfElement].length();
                if (isIndexOutOfBound || strs[0].charAt(indexOfPointer) != strs[indexOfElement].charAt(indexOfPointer)) {
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
