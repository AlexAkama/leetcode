package leetcode.solution.ready;

//
// Подсчет вариантов выпнуть мяч с поля за определенное кол-во ударов
//
// Рекусия в лоб - дала Time Limit Exceeded
// надо делать кэш
//
// И дебильное приведение типов
public class Solution0576 {

    private static final int MOD = 1_000_000_007;

    Long[][][] cache;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new Long[m][n][maxMove + 1];
        return (int) find(m, n, maxMove, startRow, startColumn);
    }

    //Runtime: 4 ms, faster than 100.00% of Java online submissions for Out of Boundary Paths.
    //Memory Usage: 41.7 MB, less than 88.54% of Java online submissions for Out of Boundary Paths.
    private long find(int m, int n, int maxMove, int row, int column) {
        if (maxMove < 0) return 0;
        if (row == -1 || row == m || column == -1 || column == n) return 1;
        if (cache[row][column][maxMove] != null) return cache[row][column][maxMove];
        long res
                = find(m, n, maxMove - 1, row + 1, column)
                + find(m, n, maxMove - 1, row, column + 1)
                + find(m, n, maxMove - 1, row - 1, column)
                + find(m, n, maxMove - 1, row, column - 1);
        cache[row][column][maxMove] = res % MOD;
        return cache[row][column][maxMove];
    }

}
