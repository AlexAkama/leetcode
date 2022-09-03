package leetcode.solution.ready;

//
// https://leetcode.com/problems/arranging-coins/
//
public class Solution0441 {

    //Runtime: 2 ms, faster than 97.00% of Java online submissions for Arranging Coins.
    //Memory Usage: 41.4 MB, less than 51.02% of Java online submissions for Arranging Coins.
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(8L * n + 1d) - 1) / 2;
    }

}
