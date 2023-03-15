package leetcode.solution.ready;

import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/
public class Solution0455 {

    //Runtime 8ms, Beats 83.69%
    // Memory 43.4MB, Beats 55.5%
    public int findContentChildren(int[] g, int[] s) {
        int posG = g.length - 1;
        int posS = s.length - 1;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        while (posG > -1 && posS > -1) {
            if (s[posS] >= g[posG]) {
                count++;
                posS--;
            }
            posG--;
        }
        return count;
    }

}
