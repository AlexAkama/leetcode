package leetcode.solution.ready;

import leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

//
// TreeNode
// Бинарное дерево в связанный список
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//
public class Solution0114 {

    //Runtime: 1 ms, faster than 78.58% of Java online submissions for Flatten Binary Tree to Linked List.
    //Memory Usage: 42.9 MB, less than 28.80% of Java online submissions for Flatten Binary Tree to Linked List.
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode node = root.left;
                while (node.right != null) node = node.right;
                node.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }


    private final Deque<TreeNode> deque = new ArrayDeque<>();

    //Runtime: 4 ms, faster than 5.95% of Java online submissions for Flatten Binary Tree to Linked List.
    //Memory Usage: 42.7 MB, less than 52.44% of Java online submissions for Flatten Binary Tree to Linked List.
    public void flatten1(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (!deque.isEmpty()) root.right = deque.pollLast();
            flatten(root.right);
            return;
        }
        if (root.left != null) {
            if (root.right != null) deque.offer(root.right);
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

}
