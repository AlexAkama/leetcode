package leetcode.solution;

//
// Каждый раз вы можете подняться на 1 или 2 ступеньки. Сколькими различными способами вы можете подняться на вершину?
// Числа Фибоначи
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
//Memory Usage: 40.5 MB, less than 70.65% of Java online submissions for Climbing Stairs.

public class Solution0070 {

    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = a + b;
            int temp = a + b;
            a = b;
            b = temp;
        }
        return res;
    }

}
