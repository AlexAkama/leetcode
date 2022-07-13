package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.List;

//
// TreeNode
// Поиск видимых узлов с правой стороны
//
// Ход мыслей:
// Первая идея просто обойти правую сторону - не работает т.к. например левая ветка может быть длиннее
// Вторая сделать "срезы" каждого уровня и потом взять последний элемент - громоздко, не рационально по памяти
// Третья - проходить весь лист справа на лево и записывать первый элемент на уровне, вопрос: но как это определить?
// По длине массива!!!
public class Solution0199 {

    //Runtime: 1 ms, faster than 95.06% of Java online submissions for Binary Tree Right Side View.
    //Memory Usage: 43.4 MB, less than 5.70% of Java online submissions for Binary Tree Right Side View.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        foo(root, 0, list);
        return list;
    }

    private void foo(TreeNode node, int level, List<Integer> list) {
        if (node == null) return;
        if (list.size() == level) list.add(node.val);
        foo(node.right, level + 1, list);
        foo(node.left, level + 1, list);
    }

}
