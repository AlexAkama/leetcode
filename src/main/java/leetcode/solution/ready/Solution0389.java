package leetcode.solution.ready;

//
// Найти разницу в строках
// https://leetcode.com/problems/find-the-difference/
//
public class Solution0389 {

    // По условию t больше на 1 символ, значит можно обойтись подсчета, а просто +/- код символа из разных строк
    // и останется код искомого символа
    //
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Find the Difference.
    //Memory Usage: 42.1 MB, less than 68.50% of Java online submissions for Find the Difference.
    public char findTheDifference(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int code = 0;
        for (int i = 0; i < chars1.length; i++) {
            code -= chars1[i];
            code += chars2[i];
        }
        code += chars2[chars1.length];
        return(char) code;
    }

    //Runtime: 3 ms, faster than 54.18% of Java online submissions for Find the Difference.
    //Memory Usage: 42.3 MB, less than 51.83% of Java online submissions for Find the Difference.
    public char findTheDifference1(String s, String t) {
        int[] w = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) w[c - 'a']++;
        chars = t.toCharArray();
        for (char c : chars) w[c - 'a']--;
        for (char c : chars) if (w[c - 'a'] == -1) return c;
        return 'a';
    }

}
