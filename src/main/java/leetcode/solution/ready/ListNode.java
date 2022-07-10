package leetcode.solution.ready;

import java.util.Arrays;

public class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public static class Solution0108 {

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

}
