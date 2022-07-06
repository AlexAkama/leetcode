package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//
// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// Что хотел сказать автор?
// Сработал вариант последовательного возвращения цепочки от листа дерева.
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
//Memory Usage: 42.4 MB, less than 39.85% of Java online submissions for Binary Tree Inorder Traversal.
public class Solution0094 {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        add(root);
        return list;
    }

    private void add(TreeNode node) {
        if (node == null) return;
        add(node.left);
        list.add(node.val);
        add(node.right);
    }

}