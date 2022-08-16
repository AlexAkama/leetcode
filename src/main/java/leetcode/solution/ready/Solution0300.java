package leetcode.solution.ready;

import java.util.Arrays;

//
// Найти максимальную длину возрастающей последовательности
// https://leetcode.com/problems/longest-increasing-subsequence/
//
//
public class Solution0300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = -1;
        for (int i = nums.length - 1; i > -1; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}

class Solution0300v1 {

    //Runtime: 83 ms, faster than 44.94% of Java online submissions for Longest Increasing Subsequence.
    //Memory Usage: 44.8 MB, less than 27.91% of Java online submissions for Longest Increasing Subsequence.
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}

class Solution0300toV2 {

    int[] dp;

    //Runtime: 5 ms, faster than 89.61% of Java online submissions for Longest Increasing Subsequence.
    //Memory Usage: 44.7 MB, less than 32.42% of Java online submissions for Longest Increasing Subsequence.
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < dp.length; i++) {
            dp[find(nums[i])] = nums[i];
        }
        return find(Integer.MAX_VALUE);
    }

    private int find(int num) {
        int left = 0;
        int right = dp.length;
        while (left < right) {
            int i = left + (right - left) / 2;
            if (dp[i] >= num)
                right = i;
            else
                left = i + 1;
        }
        return left;
    }

}

class Solution0300toV3 {

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < num)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = num;
            if (i == size) ++size;
        }
        return size;
    }

}
