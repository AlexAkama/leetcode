package leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution0001v2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            if (map.containsKey(d)) {
                return new int[]{i, map.get(d)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
