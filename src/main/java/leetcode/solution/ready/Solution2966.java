package leetcode.solution.ready;

import java.util.Arrays;

public class Solution2966 {

    public static void main(String[] args) {
        Solution2966 solution2966 = new Solution2966();

        int[][] res = solution2966.divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 3);

        System.out.println(Arrays.toString(res));

    }


    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] res = new int[nums.length / 3][];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) return new int[0][];
            else res[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return res;
    }

}
