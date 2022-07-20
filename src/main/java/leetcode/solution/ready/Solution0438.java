package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.List;

//
// Начало всех анаграмм
//
// Ход мыслей:
// Берем кусок, равный длине образца и сравниваем, но... получаем
// Time Limit Exceeded
// Видимо если написано в условии "маленькие английские", надо сравнивать через вес
//
public class Solution0438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) return list;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        for (int i = 0; i < sc.length - pc.length + 1; i++) {
            if (compare(sc, i, i + pc.length, pc)) list.add(i);
        }
        return list;
    }

    //Runtime: 1033 ms, faster than 7.11% of Java online submissions for Find All Anagrams in a String.
    //Memory Usage: 65.2 MB, less than 5.20% of Java online submissions for Find All Anagrams in a String.
    private boolean compare(char[] source, int start, int finish, char[] target) {
        int[] sourceInts = new int[26];
        int[] targetInts = new int[26];
        for (int i = start; i < finish; i++) {
            char c = source[i];
            sourceInts[c - 'a']++;
        }
        for (char c : target) targetInts[c - 'a']++;
        for (int i = 0; i < sourceInts.length; i++) {
            if (sourceInts[i] != targetInts[i]) return false;
        }
        return true;
    }

}
