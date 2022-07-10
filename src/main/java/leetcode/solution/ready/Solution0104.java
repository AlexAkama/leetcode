package leetcode.solution.ready;

//
// TreeNode
// Глубина бинарного дерева
// Рекурсия
//
//Runtime: 1 ms, faster than 25.45% of Java online submissions for Maximum Depth of Binary Tree.
//Memory Usage: 43.2 MB, less than 40.98% of Java online submissions for Maximum Depth of Binary Tree.
public class Solution0104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
