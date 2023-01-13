package leetcode.solution.ready;

//
// Восходящая последовательность
// Нужно удалить 1 элемент (обязательно) и сказать можно ли получить восходящую последовательность
// https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
//
public class Solution1909 {

    // Runtime 0 ms. Beats 100%
    // Memory 42.1 MB. Beats 67.90%
    public boolean canBeIncreasing(int[] nums) {
        if (nums.length == 2) return true;
        int peek = -1;
        for (int i = 1; i < nums.length; i++) {
            if (!(nums[i] > nums[i - 1])) {
                if (peek != -1) return false;
                peek = i;
            }
        }
        if (peek == 1 || peek == nums.length - 1) return true;
        return peek == -1
                || nums[peek] > nums[peek - 2]
                || nums[peek + 1] > nums[peek - 1];
    }

}
