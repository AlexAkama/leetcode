package leetcode.solution.ready;

//
// Поиск мощности строки - максимальная последовательность непустой подстроки из одного уникального символа
// https://leetcode.com/problems/consecutive-characters/
//
public class Solution1446 {

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Consecutive Characters.
    //Memory Usage: 42.3 MB, less than 71.70% of Java online submissions for Consecutive Characters.
    public int maxPower(String s) {
        if (s.length() == 1) return 1;
        var w = new int[26];
        char[] chars = s.toCharArray();
        var count = 0;
        var last = chars[0];
        for (char c : chars) {
            if (last == c) {
                count++;
            } else {
                if (count > w[last - 'a']) w[last - 'a'] = count;
                count = 1;
                last = c;
            }
        }
        if (count > w[last - 'a']) w[last - 'a'] = count;
        var max = 0;
        for (int i : w) {
            if (i > max) max = i;
        }
        return max;
    }

}
