package leetcode.solution.ready;

//
// Удаление одной буквы, что бы кол-во остальных стало одинаково
// https://leetcode.com/problems/remove-letter-to-equalize-frequency/
//
public class Solution2423 {

    //Runtime 0ms, Beats 100%
    //Memory 40.2MB, Beats 82.15%
    public boolean equalFrequency(String word) {
        int[] ints = new int[26];
        for (char c : word.toCharArray()) ints[c - 'a']++;

        int w1 = 0;
        int countW1 = 0;
        int w2 = 0;
        int countW2 = 0;

        for (int i : ints) {
            if (i == 0) continue;
            if (w1 == 0) w1 = i;
            else if (i != w1 && w2 == 0) w2 = i;
            if (w1 > 0 && w2 > 0 && i != w1 && i != w2) return false;
            if (i == w1) countW1++;
            if (i == w2) countW2++;
        }

        if (w2 == 0 && (w1 == 1 || countW1 == 1)) return true;
        if (countW1 == 1 && (w1 == 1 || w1 - w2 == 1)) return true;
        if (countW2 == 1 && (w2 == 1 || w2 - w1 == 1)) return true;

        return false;
    }

}
