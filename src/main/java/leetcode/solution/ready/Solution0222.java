package leetcode.solution.ready;

import leetcode.utils.TreeNode;

/*
TreeNode

https://leetcode.com/problems/count-complete-tree-nodes
 */
public class Solution0222 {

    //Рекурсия по всем
    //
    //Runtime 0ms, Beats 100.00%of users with Java
    //Details 45.82MB, Beats 38.65%of users with Java
    public int countNodesV0(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodesV0(root.left) + countNodesV0(root.right);
    }

    // Оптимизация:
    // Если дерево полное, то конец левой ветки и конец правой находится на одном уровне
    // Если нет - то рекурсия
    //
    //Runtime 0ms, Beats 100.00%of users with Java
    //Details 46.31MB, Beats 5.45%of users with Java
    //
    // Как-то ни чуть не быстрее )))
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) return (int) Math.pow(2, leftHeight) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode root) {
        TreeNode left = root.left;
        int height = 1;
        while (left != null) {
            height++;
            left = left.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode root) {
        TreeNode right = root.right;
        int height = 1;
        while (right != null) {
            height++;
            right = right.right;
        }
        return height;
    }

}
