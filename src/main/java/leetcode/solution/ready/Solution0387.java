package leetcode.solution.ready;

import java.util.Arrays;

//
// Поиск позиции первого не повторяющегося символа
// https://leetcode.com/problems/first-unique-character-in-a-string/
//
public class Solution0387 {

    //Runtime: 11 ms, faster than 80.52% of Java online submissions for First Unique Character in a String.
    //Memory Usage: 50.1 MB, less than 50.32% of Java online submissions for First Unique Character in a String.
    //
    // Мой
    public int firstUniqChar2(String s) {
        int[] w = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) w[c - 'a']++;
        for (int i = 0; i < chars.length; i++) {
            if (w[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }


    private static final int MAX = Integer.MAX_VALUE;

    //Runtime: 6 ms, faster than 96.43% of Java online submissions for First Unique Character in a String.
    //Memory Usage: 49.7 MB, less than 53.51% of Java online submissions for First Unique Character in a String.
    public int firstUniqChar1(String s) {
        int[] w = new int[26];
        int[] p = new int[26];
        Arrays.fill(p, MAX);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            w[index]++;
            if (w[index] > 1) p[index] = MAX;
            else p[index] = i;
        }
        int min = MAX;
        for (int i : p) {
            min = Math.min(min, i);
        }
        return (min == MAX) ? -1 : min;
    }

}
