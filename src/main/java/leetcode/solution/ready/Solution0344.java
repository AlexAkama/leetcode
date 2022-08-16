package leetcode.solution.ready;

//
// Реверс строки
// https://leetcode.com/problems/reverse-string/
//
public class Solution0344 {

    //Runtime: 1 ms, faster than 99.91% of Java online submissions for Reverse String.
    //Memory Usage: 54.4 MB, less than 68.29% of Java online submissions for Reverse String.
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
        }
    }

}
