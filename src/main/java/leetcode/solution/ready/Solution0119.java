package leetcode.solution.ready;

import java.util.Arrays;
import java.util.List;

//
// Строка из треугольника паскаля
// Алгоритм из задачи 118
//
//Runtime: 1 ms, faster than 91.39% of Java online submissions for Pascal's Triangle II.
//Memory Usage: 41.8 MB, less than 44.62% of Java online submissions for Pascal's Triangle II.
public class Solution0119 {

    public List<Integer> getRow(int rowIndex) {
        Integer[][] triangle = new Integer[rowIndex + 1][];
        for (int i = 0; i < rowIndex + 1; i++) {
            Integer[] row = new Integer[i + 1];
            Arrays.fill(row, 1);
            for (int j = 0; j < i + 1; j++) {
                if (j != 0 && j != i) {
                    row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
            triangle[i] = row;
        }
        return Arrays.asList(triangle[rowIndex]);
    }

}
