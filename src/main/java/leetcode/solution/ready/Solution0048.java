package leetcode.solution.ready;

//
// Поворот матрицы
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
//Memory Usage: 43 MB, less than 27.67% of Java online submissions for Rotate Image.
public class Solution0048 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

}
