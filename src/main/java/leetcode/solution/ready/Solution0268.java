package leetcode.solution.ready;

//
// Поиск отсутствующего числа в массиве
// https://leetcode.com/problems/missing-number/
//
public class Solution0268 {

    //Runtime: 1 ms, faster than 78.58% of Java online submissions for Missing Number.
    //Memory Usage: 51.2 MB, less than 46.73% of Java online submissions for Missing Number.
    public int missingNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int res = (sumToN(max) - sumToN(min - 1)) - sum;
        return (res == 0 && min == 0) ? max + 1 : res;
    }

    private int sumToN(int n) {
        return n * (n + 1) / 2;
    }

}
