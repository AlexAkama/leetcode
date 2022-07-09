package leetcode.solution;


//
// Глубина бинарного дерева
// Рекурсия
//
//Runtime: 1 ms, faster than 25.45% of Java online submissions for Maximum Depth of Binary Tree.
//Memory Usage: 43.2 MB, less than 40.98% of Java online submissions for Maximum Depth of Binary Tree.
public class Solution0104 {

    public int maxDepth(TreeNode root) {
        return getDepth(root, 1);
    }

    private int getDepth(TreeNode node, int level) {
        if (node == null) return level;
        return Math.max(getDepth(node.left, level + 1), getDepth(node.right, level + 1));
    }

}
