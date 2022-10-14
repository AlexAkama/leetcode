package leetcode.solution.ready;

//
// Поиск периметра острова
// https://leetcode.com/problems/island-perimeter/
//
public class Solution0463 {

    //Runtime: 12 ms, faster than 50.17% of Java online submissions for Island Perimeter.
    //Memory Usage: 62.5 MB, less than 38.01% of Java online submissions for Island Perimeter.
    public int islandPerimeter(int[][] grid) {
        var sum = 0;
        var x = grid.length;
        var y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 < 0 || grid[i - 1][j] == 0) sum++;
                    if (i + 1 > x - 1 || grid[i + 1][j] == 0) sum++;
                    if (j - 1 < 0 || grid[i][j - 1] == 0) sum++;
                    if (j + 1 > y - 1 || grid[i][j + 1] == 0) sum++;
                }
            }
        }
        return sum;
    }

    //Runtime: 9 ms, faster than 87.16% of Java online submissions for Island Perimeter.
    //Memory Usage: 61.3 MB, less than 82.44% of Java online submissions for Island Perimeter.
    public int islandPerimeter1(int[][] grid) {
        var sum = 0;
        var x = grid.length;
        var y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 1) {
                    sum += 4;
                    if (i > 0 && grid[i - 1][j] == 1) sum -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) sum -= 2;
                }
            }
        }
        return sum;
    }

}
