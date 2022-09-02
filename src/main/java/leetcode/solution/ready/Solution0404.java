package leetcode.solution.ready;

import leetcode.utils.TreeNode;

//
// TreeNode
// Сумма всех левых листьев
// https://leetcode.com/problems/sum-of-left-leaves/
//
public class Solution0404 {

    int count = 0;

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
    //Memory Usage: 41.6 MB, less than 72.03% of Java online submissions for Sum of Left Leaves.
    public int sumOfLeftLeaves(TreeNode root) {
        foo(root, false);
        return count;
    }

    private void foo(TreeNode node, boolean isLeftChild) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (isLeftChild) count += node.val;
            return;
        }
        foo(node.left, true);
        foo(node.right, false);
    }

}
