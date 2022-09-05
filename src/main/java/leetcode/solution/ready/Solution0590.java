package leetcode.solution.ready;

import leetcode.utils.Node;

import java.util.ArrayList;
import java.util.List;

//
// Node
// Обратный обход значений узлов
//
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/
public class Solution0590 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        foo(root);
        return res;
    }

    //Runtime: 2 ms, faster than 55.15% of Java online submissions for N-ary Tree Postorder Traversal.
    //Memory Usage: 46.4 MB, less than 25.89% of Java online submissions for N-ary Tree
    private void foo(Node node) {
        if (node == null) return;
        List<Node> children = node.children;
        for (Node child : children) {
            foo(child);
        }
        res.add(node.val);
    }

}
