package leetcode.solution.ready;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//
// TreeNode
// Среднее по уровням бинарного дерева
//
// https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class Solution637 {

    List<Double> result = new ArrayList<>();
    List<List<Integer>> accum = new ArrayList<>();

    //Runtime: 2 ms, faster than 98.49% of Java online submissions for Average of Levels in Binary Tree.
    //Memory Usage: 43.6 MB, less than 95.49% of Java online submissions for Average of Levels in Binary Tree.
    public List<Double> averageOfLevels(TreeNode root) {
        foo(root, 0);
        calculateAverage();
        return result;
    }

    private void foo(TreeNode node, int level) {
        if (node == null) return;
        if (accum.size() == level) accum.add(new ArrayList<>());
        accum.get(level).add(node.val);
        foo(node.left, level + 1);
        foo(node.right, level + 1);
    }

    private double averageFromList(List<Integer> list) {
        double sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum / list.size();
    }

    private void calculateAverage() {
        for (List<Integer> list : accum) {
            result.add(averageFromList(list));
        }
    }

}
