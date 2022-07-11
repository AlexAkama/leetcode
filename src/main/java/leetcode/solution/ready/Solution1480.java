package leetcode.solution.ready;

public class Solution1480 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Running Sum of 1d Array.
    //Memory Usage: 43.2 MB, less than 55.16% of Java online submissions for Running Sum of 1d Array.
    public int[] runningSum(int[] nums) {
        if (nums.length == 1) return nums;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

}
