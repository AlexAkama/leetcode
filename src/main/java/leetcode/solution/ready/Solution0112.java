package leetcode.solution.ready;

import leetcode.utils.TreeNode;

//
// TreeNode
// Проверка суммы пути до листа
//
// Ход мыслей:
// 1. Посчитать все - сложить куда - то, а потом проверить есть что надо или нет - как-то очень громоздко получилось.
// 2. Считаем и возвращаем что-то если не верно и искомую цифру если оно и сравнивать
// - возникла проблема с тем что возвращать если есть два варианта
// 3. Возвращать сразу boolean
//
//Runtime: 1 ms, faster than 60.07% of Java online submissions for Path Sum.
//Memory Usage: 44 MB, less than 28.62% of Java online submissions for Path Sum.
public class Solution0112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkSum(root, 0, targetSum);
    }

    private boolean checkSum(TreeNode node, int sum, int targetSum) {
        if (node == null) return false;
        sum += node.val;
        if (node.left == null && node.right == null) return sum == targetSum;
        return checkSum(node.left, sum, targetSum) || checkSum(node.right, sum, targetSum);
    }

}
