package leetcode.solution.ready;

//
// Число степень тройки?
// https://leetcode.com/problems/power-of-three/
//
// 1 способ.
// Если большое на малое делится нацело несколько раз, пока не получится единица.
// 2 способ.
// Перевести большое число в систему счисления с основанием малое число, и проверить, что получилось "1000..."
public class Solution0326 {

    //Runtime: 23 ms, faster than 55.03% of Java online submissions for Power of Three.
    //Memory Usage: 47.2 MB, less than 61.74% of Java online submissions for Power of Three.
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //Runtime: 19 ms, faster than 80.86% of Java online submissions for Power of Three.
    //Memory Usage: 47.5 MB, less than 38.43% of Java online submissions for Power of Three.
    public boolean isPowerOfThreeRecursive(int n) {
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        if (n == 0) return false;
        n /= 3;
        return isPowerOfThreeRecursive(n);
    }

}
