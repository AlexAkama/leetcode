package leetcode.solution.ready;

//
// Для заданных двух целых чисел n и k вернуть количество различных массивов, состоящих из чисел от 1 до n,
// таких, что существует ровно k обратных пар.
//
// Реализован алгоритм, но теория не ясна!
// https://leetcode.com/problems/k-inverse-pairs-array/discuss/2293243/DP-explained-with-figures-Python
public class Solution0629 {

    private static final int MOD = 1_000_000_007;

//    Runtime: 33 ms, faster than 62.65% of Java online submissions for K Inverse Pairs Array.
//    Memory Usage: 53.9 MB, less than 22.89% of Java online submissions for K Inverse Pairs Array.
    public int kInversePairs(int n, int k) {
        if (k == 0) return 1;
        long[] count = new long[k + 1];
        count[0] = 1;
        for (int i = 1; i < n; i++) {
            long[] newCount = new long[k + 1];
            newCount[0] = 1;
            long temp = 1;
            for (int j = 1; j < k + 1; j++) {
                temp += count[j];
                if (j > i) {
                    temp -= count[j - i - 1];
                }
                newCount[j] = temp % MOD;
            }
            count = newCount;
        }
        return (int) count[k];
    }

}
