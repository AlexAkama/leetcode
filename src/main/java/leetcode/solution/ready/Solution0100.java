package leetcode.solution.ready;

import leetcode.utils.TreeNode;

//
// TreeNode
// Сравнение бинарных деревьев
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
//Memory Usage: 41.5 MB, less than 57.92% of Java online submissions for Same Tree.
public class Solution0100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
