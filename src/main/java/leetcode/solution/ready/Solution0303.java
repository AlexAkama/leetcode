package leetcode.solution.ready;

//
// NumArray
// Сумма чисел в диапазоне
// https://leetcode.com/problems/range-sum-query-immutable/
//
// Т.к. immutable используем массив сумм
public class Solution0303 {

    private final int[] sumArray;

    public Solution0303(int[] nums) {
        sumArray = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArray[i] = sum;
        }
    }

    //Runtime: 10 ms, faster than 88.26% of Java online submissions for Range Sum Query - Immutable.
    //Memory Usage: 49.4 MB, less than 18.00% of Java online submissions for Range Sum Query - Immutable.
    public int sumRange(int left, int right) {
        if (left == 0) return sumArray[right];
        return sumArray[right] - sumArray[left - 1];
    }

}
