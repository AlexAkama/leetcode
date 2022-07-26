package leetcode.solution.ready;

//
// TreeNode
// Поиск минимального общего предка в бинарном дереве
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// В простом бинарном дереве, не поиска!!!
// Условия:
// - Значения нод уникальны
// - p и q обязательно присутствуют
// - p и q не равны
public class Solution0236 {

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        foo(root, p, q);
        return lca;
    }

    //Runtime: 11 ms, faster than 49.59% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    //Memory Usage: 48.1 MB, less than 16.08% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    //
    // Охрененная разница
    private boolean foo(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int node = (root == p || root == q) ? 1 : 0;
        int left = (foo(root.left, p, q)) ? 1 : 0;
        int right = (foo(root.right, p, q)) ? 1 : 0;
        int res = node + left + right;
        if (res > 1) lca = root;
        return res == 1;
    }

    //Runtime: 931 ms, faster than 5.09% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    //Memory Usage: 47.5 MB, less than 39.06% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    //
    // мягко говоря не быстро
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = root;
        while (true) {
            if (lca == p || lca == q) return lca;
            boolean left = isPresent(lca.left, p) || isPresent(lca.left, q);
            boolean right = isPresent(lca.right, p) || isPresent(lca.right, q);
            if (left && right) return lca;
            if (left) lca = lca.left;
            else lca = lca.right;
        }
    }

    private boolean isPresent(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        return isPresent(root.left, node) || isPresent(root.right, node);
    }

}
