package leetcode.solution.ready;

//
// Поиск максимальной площади острова на карате (0 - вода, 1 - земля)
//
// Последовательно обходит все, если наткнулись = 1, то считать рекурсивно площадь.
// Посчитанные = -1, что бы не посчитать два раза.
public class Solution0695 {

    //Runtime: 3 ms, faster than 84.14% of Java online submissions for Max Area of Island.
    //Memory Usage: 47.7 MB, less than 29.41% of Java online submissions for Max Area of Island.
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length - 1;
        int m = grid[0].length - 1;
        int max = 0;
        for (int x = 0; x < n + 1; x++) {
            for (int y = 0; y < m + 1; y++) {
                if (grid[x][y] == 1) {
                    int temp = count(x, y, n, m, grid);
                    if (temp > max) max = temp;
                }
            }
        }
        return max;
    }

    private int count(int x, int y, int n, int m, int[][] grid) {
        int sum = 0;
        if (x < 0 || x > n || y < 0 || y > m) return 0;
        if (grid[x][y] == 1) {
            sum++;
            grid[x][y] = -1;
            sum = sum + count(x, y - 1, n, m, grid);
            sum = sum + count(x + 1, y, n, m, grid);
            sum = sum + count(x, y + 1, n, m, grid);
            sum = sum + count(x - 1, y, n, m, grid);
        }
        return sum;
    }

}
