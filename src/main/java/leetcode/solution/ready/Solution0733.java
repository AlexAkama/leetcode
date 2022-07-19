package leetcode.solution.ready;

//
// Закрашивание цветом.
// Если красим тем же цветом сразу выход.
// Рекурсия.
//
public class Solution0733 {

    int n;
    int m;
    int oldColor;

    //Runtime: 1 ms, faster than 90.40% of Java online submissions for Flood Fill.
    //Memory Usage: 48.3 MB, less than 22.25% of Java online submissions for Flood Fill.
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        oldColor = image[sr][sc];
        if (oldColor == color) return image;
        n = image.length;
        m = image[0].length;
        fill(image, sr, sc, color);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color) {
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length) return;
        if (image[sr][sc] != oldColor) return;
        image[sr][sc] = color;
        fill(image, sr - 1, sc, color);
        fill(image, sr + 1, sc, color);
        fill(image, sr, sc - 1, color);
        fill(image, sr, sc + 1, color);
    }

}
