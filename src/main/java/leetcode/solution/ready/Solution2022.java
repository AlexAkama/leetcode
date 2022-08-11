package leetcode.solution.ready;

public class Solution2022 {

    //Runtime: 14 ms, faster than 8.00% of Java online submissions for Convert 1D Array Into 2D Array.
    //Memory Usage: 118.8 MB, less than 81.05% of Java online submissions for Convert 1D Array Into 2D Array
    public int[][] construct2DArray1(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];
        int[][] res = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            res[i / n][i % n] =original[i];
        }
        return res;
    }

    //Runtime: 4 ms, faster than 95.41% of Java online submissions for Convert 1D Array Into 2D Array.
    //Memory Usage: 118.7 MB, less than 81.99% of Java online submissions for Convert 1D Array Into 2D Array.
    public int[][] construct2DArray2(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];
        int[][] res = new int[m][];
        int p = 0;
        for (int i = 0; i < m; i++) {
            int[] ints = new int[n];
            for (int j = 0; j < n; j++) {
                ints[j] = original[p++];
            }
            res[i] = ints;
        }
        return res;
    }



}
