package leetcode.solution.ready;

//
// Поиск в матрице (двумерный массив)
// https://leetcode.com/problems/search-a-2d-matrix/
//
// По условию получается что это линейный массив разбитый на строки
public class Solution0074 {

    //Runtime: 1 ms, faster than 38.72% of Java online submissions for Search a 2D Matrix.
    //Memory Usage: 42.2 MB, less than 77.13% of Java online submissions for Search a 2D Matrix.
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) return false;
        if (matrix[0][0] == target || matrix[m - 1][n - 1] == target) return true;
        int start = 0;
        int finish = m * n;
        while (start != finish) {
            int medium = (start + finish) / 2;
            int temp = getElementByNumber(matrix, medium);
            if (temp == target) return true;
            if (temp > target) finish = medium;
            else start = medium + 1;
        }
        return getElementByNumber(matrix, start) == target;
    }

    private int getElementByNumber(int[][] matrix, int n) {
        int m = matrix[0].length;
        int y = (n - 1) / m;
        int x = (n - 1) % m;
        return matrix[y][x];
    }

}
