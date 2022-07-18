package leetcode.solution.ready;

import leetcode.solution.TreeNode;

//
// TreeNode
// Поиск минимального общего предка
// Важно: TreeNode(int x) { val = x; }
//
public class Solution0235 {

    //Runtime: 8 ms, faster than 50.14% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    //Memory Usage: 50.9 MB, less than 6.23% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    public leetcode.solution.TreeNode lowestCommonAncestor(leetcode.solution.TreeNode root, leetcode.solution.TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ((p.val >= root.val && q.val <= root.val) || (p.val <= root.val && q.val >= root.val)) return root;
        if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }

}
