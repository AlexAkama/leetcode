package leetcode.solution.ready;

//
// TreeNode
// Проверка на симметрию бинарное дерево
//
// Основано на методе сравнения бинарных деревьев - только в сравнение передаются симметричные ветви
//
//Runtime: 1 ms, faster than 63.40% of Java online submissions for Symmetric Tree.
//Memory Usage: 42.5 MB, less than 31.85% of Java online submissions for Symmetric Tree.
public class Solution0101 {

    public boolean isSymmetric(TreeNode root) {
        return isMirrorTree(root.right, root.left);
    }

    private boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
    }

}
