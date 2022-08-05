package leetcode.solution.ready;

//
// Число степень четверки?
// https://leetcode.com/problems/power-of-three/
//
public class Solution0342 {

    //Runtime: 2 ms, faster than 66.58% of Java online submissions for Power of Four.
    //Memory Usage: 41.8 MB, less than 18.79% of Java online submissions for Power of Four.
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
    //Memory Usage: 41.8 MB, less than 18.79% of Java online submissions for Power of Four.
    public boolean isPowerOfFourRecursive(int n) {
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        if (n == 0) return false;
        n /= 4;
        return isPowerOfFourRecursive(n);
    }

}
