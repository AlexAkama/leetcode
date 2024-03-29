package leetcode.solution.ready;

import leetcode.utils.TreeNode;

//
// TreeNode
// Поиск минимального общего предка в бинарном дереве поиска
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Важно: TreeNode(int x) { val = x; }
// Значения отсортированы!!!
//
public class Solution0235 {

    //Runtime: 8 ms, faster than 50.14% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    //Memory Usage: 50.9 MB, less than 6.23% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ((p.val >= root.val && q.val <= root.val) || (p.val <= root.val && q.val >= root.val)) return root;
        if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }

}
