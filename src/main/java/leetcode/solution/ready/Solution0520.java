package leetcode.solution.ready;

//
// https://leetcode.com/problems/detect-capital/
//
public class Solution0520 {

    //Runtime 1ms, Beats 100.00%of users with Java
    //Memory 40.51mb, Beats 97.28%of users with Java
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        char[] chars = word.toCharArray();
        boolean b0 = Character.isUpperCase(chars[0]);
        boolean b1 = Character.isUpperCase(chars[1]);
        for (int i = 1; i < chars.length; i++) {
            if (b1 != Character.isUpperCase(chars[i])) return false;
        }
        return b0 == b1 || b0;
    }

}
