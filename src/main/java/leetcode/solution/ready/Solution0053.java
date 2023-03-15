package leetcode.solution.ready;

// Dynamic Programming
// https://leetcode.com/problems/maximum-subarray/description/
public class Solution0053 {

    //Runtime 1ms, Beats 100%
    //Memory 52MB, Beats 22.30%
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = nums[0];
        int sum = Math.max(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            sum = Math.max(sum, 0);
        }
        return res;
    }

}
