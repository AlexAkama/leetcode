package leetcode.solution.ready;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//
// TreeNode
// Учитывая корень двоичного дерева, определите, является ли оно допустимым двоичным деревом поиска (BST).
//    Левое поддерево узла содержит только узлы с ключами меньше ключа узла.
//    Правое поддерево узла содержит только узлы с ключами больше, чем ключ узла.
//    И левое, и правое поддеревья также должны быть бинарными деревьями поиска.
//
// Рекурсия съела мозг!!!
// Хитрость в том что когда слева надо проверять, что не больше, а когда справа - то не меньше )))
// Плюс значения -2³¹ <= Node.val <= 2³¹ - 1 - что заставляет сравнивать с лонгом.
//
// Еще вариант:
// Если составить список неупорядоченного обхода, то он должен быть упорядоченным, если нет то и дерево "кривое".
// Судя по всему значения уникальны.
public class Solution0098 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
    //Memory Usage: 43.9 MB, less than 55.24% of Java online submissions for Validate Binary Search Tree.
    public boolean isValidBST(TreeNode root) {
        return foo(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean foo(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return foo(node.left, min, node.val) && foo(node.right, node.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        foo2(root, list);
        return isSortedList(list);
    }

    //Runtime: 2 ms, faster than 23.26% of Java online submissions for Validate Binary Search Tree.
    //Memory Usage: 43.9 MB, less than 48.44% of Java online submissions for Validate Binary Search Tree.
    private void foo2(TreeNode node, List<Integer> list) {
        if (node == null) return;
        foo2(node.left, list);
        list.add(node.val);
        foo2(node.right, list);
    }

    private boolean isSortedList(List<Integer> list) {
        if (list.size() == 1) return true;
        int prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int cur = list.get(i);
            if (prev >= cur) return false;
            prev = cur;
        }
        return true;
    }

}
