package leetcode.solution.ready;

import leetcode.utils.TreeNode;

//
// TreeNode
// Проверка сбалансированности бинарного дерева
// Для этой задачи сбалансированное по высоте бинарное дерево определяется как:
// бинарное дерево, в котором левое и правое поддеревья каждого узла отличаются по высоте не более чем на 1.
//
// Ход мыслей:
// Вычисляем грубину сбалансированного дерева, если она есть то ок
//
//Runtime: 1 ms, faster than 99.03% of Java online submissions for Balanced Binary Tree.
//Memory Usage: 44.4 MB, less than 42.57% of Java online submissions for Balanced Binary Tree.
public class Solution0110 {

    public boolean isBalanced(TreeNode root) {
        return getBalanceDepth(root) != -1;
    }

    private int getBalanceDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getBalanceDepth(node.left);
        int rightDepth = getBalanceDepth(node.right);
        if (leftDepth == -1 || rightDepth == -1) return -1;
        int diff = Math.abs(leftDepth - rightDepth);
        if (diff > 1) return -1;
        else return Math.max(leftDepth, rightDepth) + 1;
    }

}
