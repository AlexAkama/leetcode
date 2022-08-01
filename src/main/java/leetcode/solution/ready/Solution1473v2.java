package leetcode.solution.ready;

//
// HARD
// Покраска домов
// https://leetcode.com/problems/paint-house-iii/
//
// Вторая попытка
public class Solution1473v2 {

    public static final int MAX = 100_000_000;

    private int[] houses;
    private int[][] cost;
    private int m;
    private int n;
    private int target;
    private int[][][] dp;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        dp = getDP(m, n, target);
        int optionalCost = paint(0, 0, -1);
        return (optionalCost == MAX) ? -1 : optionalCost;
    }

    private int paint(int house, int group, int lastColor) {
        if (house == m) {
            if (group == target) return 0;
            return MAX;
        }
        if (group == target + 1) return MAX;
        if (lastColor > -1 && dp[house][lastColor][group - 1] != -1) {
            return dp[house][lastColor][group - 1];
        }
        int minCost = MAX;

        for (int color = 0; color < n; color++) {
            if (houses[house] > 0 && houses[house] != color + 1) continue;
            boolean addCost = houses[house] == 0 && houses[house] != color + 1;
            int newGroup = (color != lastColor) ? 1 : 0;
            minCost = Math.min(
                    minCost,
                    paint(house + 1, group + newGroup, color) + ((addCost) ? cost[house][color] : 0));
        }
        if (lastColor > -1) {
            dp[house][lastColor][group - 1] = minCost;
        }
        return minCost;
    }

    private int[][][] getDP(int m, int n, int target) {
        int[][][] dp = new int[m][n][target];
        for (int house = 0; house < m; house++) {
            for (int color = 0; color < n; color++) {
                for (int group = 0; group < target; group++) {
                    dp[house][color][group] = -1;
                }
            }
        }
        return dp;
    }

}
