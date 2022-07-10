package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
// Треугольник паскаля
//
// + заполнение массива числом
// + лист из массива
//
// Алгоритма как посчитать отдельную строку не нашел
// Посчитано линейно с верху вниз
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
//Memory Usage: 39.7 MB, less than 98.07% of Java online submissions for Pascal's Triangle.
public class Solution0118 {

    public List<List<Integer>> generate(int numRows) {
        Integer[][] triangle = new Integer[numRows][];
        for (int i = 0; i < numRows; i++) {
            Integer[] row = new Integer[i + 1];
            Arrays.fill(row, 1); //+
            for (int j = 0; j < i + 1; j++) {
                if (j != 0 && j != i) {
                    row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
            triangle[i] = row;
        }
        List<List<Integer>> triangleList = new ArrayList<>(triangle.length);
        for (Integer[] integers : triangle) {
            List<Integer> rowList = Arrays.asList(integers); //+
            triangleList.add(rowList);
        }
        return triangleList;
    }

}
