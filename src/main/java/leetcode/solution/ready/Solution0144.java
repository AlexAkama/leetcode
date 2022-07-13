package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.List;

//
// TreeNode
// Создание списка значений из узлов сверху вниз, слева направо
//
public class Solution0144 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
    //Memory Usage: 40.6 MB, less than 86.63% of Java online submissions for Binary Tree Preorder Traversal.
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        foo(root, list);
        return list;
    }

    private void foo(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        foo(node.left, list);
        foo(node.right, list);
    }

}
