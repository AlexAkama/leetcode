package leetcode.solution.ready;

import leetcode.solution.TreeNode;

import java.util.ArrayList;
import java.util.List;

//
// TreeNode
// Путь до листов дерева
//
public class Solution0257 {

    List<String> list;

    public List<String> binaryTreePaths(leetcode.solution.TreeNode root) {
        list = new ArrayList<>();
        if (root != null) foo(root, "");
        return list;
    }

    //Runtime: 9 ms, faster than 64.91% of Java online submissions for Binary Tree Paths.
    //Memory Usage: 42.9 MB, less than 76.70% of Java online submissions for Binary Tree Paths.
    private void foo(TreeNode node, String path) {
        path += node.val;
        if (node.left == null && node.right == null) list.add(path);
        if (node.left != null) foo(node.left, path + "->");
        if (node.right != null) foo(node.right, path + "->");
    }

}
