package leetcode.solution;

//
// Создание бинарного дерева из массива
// Рекурсия
//
//Runtime: 3 ms, faster than 34.99% of Java online submissions for Convert Sorted Array to Binary Search Tree.
//Memory Usage: 43.8 MB, less than 46.21% of Java online submissions for Convert Sorted Array to Binary Search Tree.

import java.util.Arrays;

public class Solution0108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int center = nums.length / 2;
        int[] leftArray = Arrays.copyOf(nums, center);
        int[] rightArray = Arrays.copyOfRange(nums, center + 1, nums.length);
        TreeNode left = sortedArrayToBST(leftArray);
        TreeNode right = sortedArrayToBST(rightArray);
        return new TreeNode(nums[center], left, right);
    }

}
