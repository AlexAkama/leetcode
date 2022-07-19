package leetcode.solution.ready;

//
// Считаем кол-во островов
//
public class Solution0200 {

    int n;
    int m;

    //Runtime: 4 ms, faster than 76.56% of Java online submissions for Number of Islands.
    //Memory Usage: 57.9 MB, less than 26.53% of Java online submissions for Number of Islands.
    public int numIslands(char[][] grid) {
        n = grid.length - 1;
        m = grid[0].length - 1;
        int sum = 0;
        for (int x = 0; x < n + 1; x++) {
            for (int y = 0; y < m + 1; y++) {
                if (grid[x][y] == '1') {
                    mark(x, y, grid);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void mark(int x, int y, char[][] grid) {
        if (x < 0 || x > n || y < 0 || y > m) return;
        if (grid[x][y] == '1') {
            grid[x][y] = 'I';
            mark(x, y - 1, grid);
            mark(x + 1, y, grid);
            mark(x, y + 1, grid);
            mark(x - 1, y, grid);
        }
    }

}
