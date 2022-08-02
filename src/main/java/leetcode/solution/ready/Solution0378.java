package leetcode.solution.ready;

//
// Вернуть k-й наименьший элемент в отсортированной матрице
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
//
// Алгоритм:
// low = matrix[0][0] и high = matrix[n-1][n-1].
// middle =  low + (high - low) / 2
// Считаем все числа, меньшие или равные middle.
// Если количество меньше k, то low = middle + 1, если счетчик больше или равен k, то high = middle,
// В какой-то момент low == high становятся равными по значениям, и цикл завершается.
public class Solution0378 {

    //Runtime: 1 ms, faster than 92.44% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
    //Memory Usage: 48.3 MB, less than 86.64% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix.length - 1];
        if (k == 1) return low;
        if (k == matrix.length * matrix.length) return high;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (getLessThatOrEqualTo(matrix, middle) < k) low = middle + 1;
            else high = middle;
        }
        return low;
    }

    private int getLessThatOrEqualTo(int[][] matrix, int x) {
        int count = 0;
        for (int[] ints : matrix) {
            if (ints[ints.length - 1] <= x) {
                count += ints.length;
                continue;
            }
            if (ints[0] > x) return count;
            int j = 0;
            while (ints[j++] <= x) count++;
        }
        return count;
    }

}
