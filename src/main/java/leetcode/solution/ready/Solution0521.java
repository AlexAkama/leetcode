package leetcode.solution.ready;

/*
https://leetcode.com/problems/longest-uncommon-subsequence-i/
 */
public class Solution0521 {

    //Runtime 0ms, Beats 100.00%of users with Java
    //Memory 40.27MB, Beats 56.87%of users with Java
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }

}
