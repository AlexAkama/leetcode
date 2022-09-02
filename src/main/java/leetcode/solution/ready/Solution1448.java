package leetcode.solution.ready;

import leetcode.utils.TreeNode;

//
// TreeNode
// Подсчет нод со значением больше корня (хороших нод)
//
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class Solution1448 {

    int count = 0;

    //Runtime: 3 ms, faster than 76.76% of Java online submissions for Count Good Nodes in Binary Tree.
    //Memory Usage: 59.4 MB, less than 69.52% of Java online submissions for Count Good Nodes in Binary Tree.
    public int goodNodes(TreeNode root) {
        foo(root, root.val);
        return count;
    }

    private void foo(TreeNode node, int peak) {
        if (node == null) return;
        if (node.val >= peak) {
            count++;
            peak = node.val;
        }
        foo(node.left, peak);
        foo(node.right, peak);
    }

}
