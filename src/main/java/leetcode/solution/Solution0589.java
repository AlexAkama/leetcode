package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//
// Node
// Вернуть предварительный просмотр узлов
//
public class Solution0589 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for N-ary Tree Preorder Traversal.
    //Memory Usage: 43.2 MB, less than 88.84% of Java online submissions for N-ary Tree Preorder Traversal.
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        foo(root, list);
        return list;
    }

    private void foo(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        List<Node> children = node.children;
        for (Node child : children) {
            foo(child, list);
        }
    }

}
