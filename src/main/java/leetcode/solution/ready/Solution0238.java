package leetcode.solution.ready;

//
// Найти произведение всех элементов кроме текущего
// ВАЖНО! Не использовать деление и уложиться в O(n)
// https://leetcode.com/problems/product-of-array-except-self/
//
public class Solution0238 {

    //Runtime: 2 ms, faster than 89.58% of Java online submissions for Product of Array Except Self.
    //Memory Usage: 50 MB, less than 99.58% of Java online submissions for Product of Array Except Self.
    public int[] productExceptSelf(int[] nums) {
        var left = new int[nums.length];
        var right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            var revers = nums.length - 1 - i;
            right[revers] = right[revers + 1] * nums[revers + 1];
        }
        for (int i = 0; i < nums.length; i++) nums[i] = left[i] * right[i];
        return nums;
    }

}
