package leetcode.solution.ready;

//
// Число полиндлром
// Если кончается на 0 точно не полиндром
// Получения половины числа
//
public class Solution0009v2 {

    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int rx = 0;
        while (x > rx) {
            rx = rx * 10 + x % 10;
            x /= 10;
        }
        return x == rx || x == rx / 10;
    }

}
