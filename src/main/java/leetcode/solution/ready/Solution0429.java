package leetcode.solution.ready;

import leetcode.utils.Node;

import java.util.ArrayList;
import java.util.List;

//
// Node
// Список по уровням
//
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/
public class Solution0429 {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        foo(root, 0);
        return res;
    }

    //Runtime: 2 ms, faster than 95.52% of Java online submissions for N-ary Tree Level Order Traversal.
    //Memory Usage: 46.6 MB, less than 83.46% of Java online submissions for N-ary Tree Level Order Traversal.
    private void foo(Node node, int level) {
        if (node == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        List<Integer> row = res.get(level);
        row.add(node.val);
        List<Node> children = node.children;
        if (children != null) {
            for (Node child : children) {
                foo(child, level + 1);
            }
        }
    }

}
