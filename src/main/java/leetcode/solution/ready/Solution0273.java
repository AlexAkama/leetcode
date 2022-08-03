package leetcode.solution.ready;

//
// Положительное целое число, простые множители которого ограничены 2, 3 и 5?
// https://leetcode.com/problems/ugly-number/
//
public class Solution0273 {

    private static final int[] PRIMES = new int[]{2, 3, 5};

    //Runtime: 2 ms, faster than 69.42% of Java online submissions for Ugly Number.
    //Memory Usage: 41.1 MB, less than 70.11% of Java online submissions for Ugly Number.
    public boolean isUgly(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        int p = 0;
        while (p < 3) {
            if (n % PRIMES[p] == 0) {
                n = n / PRIMES[p];
                if (n == 1) return true;
            } else {
                p++;
            }
        }
        return false;
    }

}
