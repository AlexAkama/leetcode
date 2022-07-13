package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.List;

//
// TreeNode
// Вернуть список обхода узлов по уровням, т.е. каждый уровень свой список
//
public class Solution0102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        foo(root, list, 0);
        return list;
    }

    //Runtime: 1 ms, faster than 92.53% of Java online submissions for Binary Tree Level Order Traversal.
    //Memory Usage: 43.7 MB, less than 33.89% of Java online submissions for Binary Tree Level Order Traversal.
    private void foo(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) return;
        List<Integer> row;
        if (list.size() == level) {
            row = new ArrayList<>();
            list.add(row);
        } else {
            row = list.get(level);
        }
        row.add(node.val);
        foo(node.left, list, level + 1);
        foo(node.right, list, level + 1);
    }

}

