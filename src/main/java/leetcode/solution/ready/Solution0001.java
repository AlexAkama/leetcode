package leetcode.solution.ready;

import java.util.HashMap;
import java.util.Map;

/*
Поиск позиций в массве, значения которых в сумме дают целевое значение.
По условию такая пара всегда существует.


 */
public class Solution0001 {

    public int[] twoSumV0(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            if (map.containsKey(d)) return new int[]{map.get(d), i};
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
