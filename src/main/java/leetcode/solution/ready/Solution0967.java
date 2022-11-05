package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.List;

//
// https://leetcode.com/problems/numbers-with-same-consecutive-differences/
//


public class Solution0967 {

    List<Integer> list = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i < 10; i++) {
            foo(i, k, n, 0);
        }
        //Runtime: 4 ms, faster than 65.31% of Java online submissions for Numbers With Same Consecutive Differences.
        //Memory Usage: 43.4 MB, less than 31.88% of Java online submissions for Numbers With
        int[] res = new int[list.size()];
        int count = 0;
        for (Integer integer : list) {
            res[count++] = integer;
        }
        return res;

        //При использовании стрима:
        //Runtime: 8 ms, faster than 28.13% of Java online submissions for Numbers With Same Consecutive Differences.
        //Memory Usage: 43.7 MB, less than 20.31% of Java online submissions for Numbers With Same Consecutive Differences.
        //return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private void foo(int lastDigit, int window, int level, int res) {
        if (level == 0) {
            list.add(res);
            return;
        }
        res = res * 10 + lastDigit;
        int nextDigit = lastDigit + window;
        if (nextDigit < 10) foo(nextDigit, window, level - 1, res);
        nextDigit = lastDigit - window;
        if (nextDigit > -1) foo(nextDigit, window, level - 1, res);
    }

}