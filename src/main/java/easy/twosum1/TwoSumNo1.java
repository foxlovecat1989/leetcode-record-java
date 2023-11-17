package easy.twosum1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSumNo1 {
    public static void main(String[] args) {
        int[] result1 = TwoSumNo1.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] result2 = TwoSumNo1.twoSum(new int[]{3, 2, 4}, 6);
        int[] result3 = TwoSumNo1.twoSum(new int[]{3, 3}, 6);

        System.out.println("result1: " + Arrays.toString(result1));
        System.out.println("result2: " + Arrays.toString(result2));
        System.out.println("result3: " + Arrays.toString(result3));
    }


    public static int[] twoSum(int[] nums, int target) {
        validateInput(nums);

        return findTarget(nums, target, toMap(nums));
    }

    private static void validateInput(int[] nums) {
        boolean invalidElementsSize = nums.length < 2;
        if (invalidElementsSize)
            throw new IllegalStateException("Length of nums can not be less than two");
    }

    private static int[] findTarget(int[] nums, int target, Map<Integer, Integer> map) {
        boolean hasOnlyTwoElements = nums.length == 2;
        if (hasOnlyTwoElements)
            return new int[]{0, 1};

        int currentIndex = -1;
        int targetIndex = -1;
        for (int i = 0; i < nums.length -1; i++) {
            Integer value = map.get(target - nums[i]);
            boolean isFound = value != null && value != i;
            if (isFound) {
                currentIndex = i;
                targetIndex = value;
                break;
            }
        }


        return new int[] {currentIndex, targetIndex};
    }

    private static Map<Integer, Integer> toMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        return map;
    }
}
