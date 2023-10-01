package leetcode.solution.ready;

import leetcode.utils.Node;

import java.util.List;

/*
Глубина дерева

Похожая 104

https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class Solution0559 {


    //Runtime 0ms, Beats 100.00%of users with Java
    //Memory 42.72MB, Beats 73.43%of users with Java
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children.isEmpty()) return 1;
        int maxDepth = 0;
        for (Node child : root.children) {
            int childDepth = maxDepth(child);
            if (childDepth > maxDepth) maxDepth = childDepth;
        }
        return maxDepth + 1;
    }

    int deep = 0;

    //Runtime 0ms, Beats 100.00%of users with Java
    //Memory 43.05MB, Beats 36.58%of users with Java
    //
    // Плоховато по памяти
    public int maxDepthRedMemory(Node root) {
        if (root == null) return deep;
        dfs(root, 1);
        return deep;
    }

    private void dfs(Node node, int level) {
        List<Node> children = node.children;
        if (!children.isEmpty()) {
            for (Node child : children) {
                dfs(child, level + 1);
            }
        }
        if (level > deep) deep = level;
    }

}
