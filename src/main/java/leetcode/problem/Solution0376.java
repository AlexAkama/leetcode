package leetcode.problem;

//
// "Волнистая" последовательность
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Wiggle Subsequence.
//Memory Usage: 42.3 MB, less than 9.65% of Java online submissions for Wiggle Subsequence.
public class Solution0376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int vector = nums[1] - nums[0];
        int count = (vector == 0) ? 1 : 2;
        int offset;
        for (int i = 1; i < nums.length - 1; i++) {
            offset = nums[i + 1] - nums[i];
            if (vector >= 0 && offset < 0 || vector <= 0 && offset > 0) {
                vector = offset;
                count++;
            }
        }
        return count;
    }


}