package leetcode.solution.ready;

//
// Число полиндлром
//
public class Solution0009 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

}
