package leetcode.solution.ready;

//
// Проверка является ли строка последовательностью из другой строки
// очень похоже на
// Можно ли создать строку из элементов другой строки
//
public class Solution0392 {

    //Runtime: 1 ms, faster than 93.02% of Java online submissions for Is Subsequence.
    //Memory Usage: 41.9 MB, less than 58.75% of Java online submissions for Is Subsequence.
    public boolean isSubsequence(String s, String t) {
        if (t.isEmpty() && s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        if (s.length() > t.length()) return false;
        if (s.length() == t.length()) return s.equals(t);
        int p = 0;
        char c = s.charAt(p);
        for (int i = 0; i < t.length(); i++) {
            if (c == t.charAt(i)) {
                if (++p == s.length()) return true;
                c = s.charAt(p);
            }
        }
        return false;
    }

}
