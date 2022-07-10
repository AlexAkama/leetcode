package leetcode.solution.ready;

//
// TreeNode
// Минимальная глубина бинарного дерева
//
//Runtime: 13 ms, faster than 38.35% of Java online submissions for Minimum Depth of Binary Tree.
//Memory Usage: 95.9 MB, less than 15.02% of Java online submissions for Minimum Depth of Binary Tree.
//
// Рекурсия
// Интересно, а можно как-то быстрее?
public class Solution0111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null) return minDepth(root.right) + 1;
        if (root.right == null && root.left != null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
