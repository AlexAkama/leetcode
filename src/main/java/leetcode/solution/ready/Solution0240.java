package leetcode.solution.ready;

//
// Поиск в отсортированной матрице
// https://leetcode.com/problems/search-a-2d-matrix-ii/
// Теория: https://www.youtube.com/watch?v=FOa55B9Ikfg
public class Solution0240 {

    //Runtime: 7 ms, faster than 87.67% of Java online submissions for Search a 2D Matrix II.
    //Memory Usage: 53.7 MB, less than 80.90% of Java online submissions for Search a 2D Matrix II.
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;
        int left = 0;
        int down = n - 1;
        int right = m - 1;
        int up = 0;
        while (left <= right && up <= down) {
            if (matrix[down][left] == target) return true;
            if (matrix[up][right] == target) return true;
            if (matrix[down][left] > target) down--;
            else left++;
            if (matrix[up][right] > target) right--;
            else up++;
        }
        return false;
    }

}
