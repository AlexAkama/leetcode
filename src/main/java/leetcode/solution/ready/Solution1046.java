package leetcode.solution.ready;

import java.util.Arrays;

//
// Выбивание камней
// https://leetcode.com/problems/last-stone-weight/
//
public class Solution1046 {

    //Runtime: 1 ms, faster than 99.66% of Java online submissions for Last Stone Weight.
    //Memory Usage: 39.7 MB, less than 94.12% of Java online submissions for Last Stone Weight.
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        for (int i = stones.length - 1; i > 0; i--) {
            Arrays.sort(stones);
            stones[i - 1] = stones[i] - stones[i - 1];
        }
        return stones[0];
    }

}
