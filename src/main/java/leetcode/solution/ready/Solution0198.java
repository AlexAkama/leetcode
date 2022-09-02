package leetcode.solution.ready;

//
// Ограбление домов
// Условие: воровать в соседних нельзя
// https://leetcode.com/problems/house-robber/
//
public class Solution0198 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
    //Memory Usage: 41.8 MB, less than 24.95% of Java online submissions for House Robber.
    public int rob(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for (int num : nums) {
            int p = p1;
            p1 = Math.max(p1, p2);
            p2 = num + p;
        }
        return Math.max(p1, p2);
    }

}
