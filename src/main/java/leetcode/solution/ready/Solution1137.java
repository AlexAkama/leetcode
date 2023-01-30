package leetcode.solution.ready;

//
// Последовательность Фибоначи
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
// https://leetcode.com/problems/n-th-tribonacci-number/
//
public class Solution1137 {

    //Runtime 0 ms. Beats 100%
    //Memory 38.9 MB. Beats 80.79%
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] array = createArray(n);
        for (int i = 3; i < n + 1; i++) {
            array[i] = array[i - 3] + array[i - 2] + array[i - 1];
        }
        return array[n];
    }

    private int[] createArray(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 1;
        return ints;
    }

}
