package leetcode.solution.ready;

import java.util.Arrays;

//
// Являются ли строки анаграммами
// Анаграмма — это слово или фраза, образованная путем перестановки букв другого слова или фразы,
// обычно с использованием всех исходных букв ровно один раз.
//
public class Solution0242 {

    //Runtime: 8 ms, faster than 46.43% of Java online submissions for Valid Anagram.
    //Memory Usage: 45.4 MB, less than 30.70% of Java online submissions for Valid Anagram.
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != tc[i]) return false;
        }
        return true;
    }

    // Вариант с весом букв (по условию только маленькие английские) - если верить, то немого лучше
    //Runtime: 5 ms, faster than 75.47% of Java online submissions for Valid Anagram.
    //Memory Usage: 43.8 MB, less than 54.35% of Java online submissions for Valid Anagram.
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sa = new int[26];
        int[] ta = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (char c : sc) sa[(c - 'a')]++;
        for (char c : tc) ta[(c - 'a')]++;
        for (int i = 0; i < sa.length; i++) {
            if (sa[i] != ta[i]) return false;
        }
        return true;
    }

}
