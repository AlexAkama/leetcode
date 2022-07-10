package leetcode.solution.ready;

public class Solution0027 {

    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[pointer++] = nums[i];
        }
        return pointer;
    }

}
