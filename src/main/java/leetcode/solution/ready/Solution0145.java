package leetcode.solution.ready;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// TreeNode
// Given the root of a binary tree, return the postorder traversal of its nodes' values.
// Создание списка значений из узлов в обратном порядке: слева на право, снизу вверх
//
// Мысль: делаем прямой список и разворачиваем
// Мысль верная, но реализация... перепутал и отсортировал в обратном порядке, а надо РАЗВЕРНУТЬ!!!
// После второй неудачи возник вопрос к формулировке задачи... судя по проваленным тестам надо возвращать
// строки в обратном порядке, а внутри строк слева на право (((
// Собираем список из списков каждой строки -> тоже не оно!!!
//
// Все оказалось значительно проще - если поменять порядок записи в "рекурсии" то получим, то что надо!!!
public class Solution0145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        foo(root, list);
        return list;
    }

    //Runtime: 1 ms, faster than 51.06% of Java online submissions for Binary Tree Postorder Traversal.
    //Memory Usage: 42.4 MB, less than 39.64% of Java online submissions for Binary Tree Postorder Traversal.
    private void foo(TreeNode node, List<Integer> list) {
        if (node == null) return;
        foo(node.left, list);
        foo(node.right, list);
        list.add(node.val);
    }

}
