package leetcode.solution.ready;

import leetcode.utils.TreeNode;

//
// TreeNode
// Инвертировать бинарное дерево
//
public class Solution0226 {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    //Runtime: 1 ms, faster than 10.73% of Java online submissions for Invert Binary Tree.
    //Memory Usage: 41.3 MB, less than 69.88% of Java online submissions for Invert Binary Tree.
    private void invert(TreeNode node) {
        if (node == null) return;
        TreeNode temp;
        temp = node.left;
        node.left = node.right;
        node.right = temp;
        invert(node.left);
        invert(node.right);
    }

}
