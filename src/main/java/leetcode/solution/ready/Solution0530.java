package leetcode.solution.ready;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
TreeNode
Поиск минимальной разницы между двумя любыми узлами

https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class Solution0530 {

    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;

    //Runtime 0ms, Beats 100.00%of users with Java
    //Memory 42.92MB, Beats 72.86%of users with Java
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return minDiff;
        getMinimumDifference(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        getMinimumDifference(root.right);
        return minDiff;
    }


    List<Integer> list = new ArrayList<>();

    //Runtime 4ms, Beats 12.18%of users with Java
    //Memory 42.89MB, Beats 83.85%of users with Java
    //
    // Вариант с сортировкой листа ОЧЕНЬ ПЛОХ!!!
    public int getMinimumDifferenceToList(TreeNode root) {
        toList(root);
        Collections.sort(list);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff < minDiff) minDiff = diff;
        }
        return minDiff;
    }

    private void toList(TreeNode node) {
        if (node == null) return;
        list.add(node.val);
        toList(node.left);
        toList(node.right);
    }


}
