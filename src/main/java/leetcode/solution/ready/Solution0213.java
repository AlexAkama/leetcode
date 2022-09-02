package leetcode.solution.ready;

import java.util.Arrays;

//
// Ограбление домов
// Условие: воровать в соседних нельзя, первый и последние соседи (т.е. дома стоят по кругу)
//
public class Solution0213 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
    //Memory Usage: 39.6 MB, less than 94.70% of Java online submissions for House Robber II.
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] arr = Arrays.copyOf(nums, nums.length - 1);
        int p1 = lineRob(arr);
        arr = Arrays.copyOfRange(nums, 1, nums.length);
        int p2 = lineRob(arr);
        return Math.max(p1, p2);
    }

    public int lineRob(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for (int num : nums) {
            int p = p1;
            p1 = Math.max(p1, p2);
            p2 = num + p;
        }
        return Math.max(p1, p2);
    }

}
