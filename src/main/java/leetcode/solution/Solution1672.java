package leetcode.solution;

public class Solution1672 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int j : account) {
                sum += j;
            }
            if (sum > max) max = sum;
        }
        return max;
    }

}
