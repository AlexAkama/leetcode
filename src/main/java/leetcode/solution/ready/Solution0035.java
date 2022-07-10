package leetcode.solution.ready;

public class Solution0035 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            if (target < nums[i]) return  i;
        }return nums.length;
    }
}
