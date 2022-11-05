package leetcode.solution.ready;

//
// Определить что строка это повторение подстроки
// https://leetcode.com/problems/repeated-substring-pattern/
//
public class Solution0459 {

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < chars.length / 2 ; i++) {
            sb.append(chars[i]);
            double count = (double) s.length() / (i + 1);
            if (count % 1 != 0) continue;
            if (sb.toString().repeat((int) count).equals(s)) return true;
        }
        return false;
    }

}
