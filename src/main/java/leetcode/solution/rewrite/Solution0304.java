package leetcode.solution.rewrite;

//
// NumMatrix
// Вернуть сумму части массива
// https://leetcode.com/problems/range-sum-query-2d-immutable/
//
// Используем Дерево Фенвика
// https://e-maxx.ru/algo/fenwick_tree
//
// Вариант 1.
// Каждую строку - в дерево фенвика.
// Вариант 2.
// Прочитать и реализовать двумерное дерево фенвика.
// https://brestprog.by/topics/fenwicktree/
public class Solution0304 {

    private int[][] fenvickTree;

    public Solution0304(int[][] matrix) {
        intitFenvickTree(matrix);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return -1;
    }

    private void intitFenvickTree(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {

            }

        }
    }

    // ВАРИАНТ 1
    public int sumRegion1(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row < row2 + 1; row++) {
            sum += getRangeSum1(fenvickTree[row], col1, col2);
        }
        return sum;
    }

    private int getRangeSum1(int[] fenvickTree, int left, int right) {
        return getSum1(fenvickTree, right) - getSum1(fenvickTree, left - 1);
    }

    private int getSum1(int[] fenvickTree, int index) {
        int sum = 0;
        while (index > -1) {
            sum += fenvickTree[index];
            index = (index & index + 1) - 1;
        }
        return sum;
    }

    private void intitFenvickTree1(int[][] matrix) {
        fenvickTree = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            fenvickTree[row][0] = matrix[row][0];
            for (int column = 1; column < matrix[0].length; column++) {
                int index = column & (column + 1);
                for (int i = index; i < column + 1; i++) fenvickTree[row][column] += matrix[row][i];
            }
        }
    }

}
