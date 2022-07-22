package leetcode.solution.ready;

//
// Сравнение строк с символами удаления
// https://leetcode.com/problems/backspace-string-compare/
//
public class Solution0844 {

    private static final int BACKSPACE = '#';

    //Runtime: 1 ms, faster than 93.96% of Java online submissions for Backspace String Compare.
    //Memory Usage: 42.6 MB, less than 25.17% of Java online submissions for Backspace String Compare.
    public boolean backspaceCompare(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int p1 = 0;
        int p2 = 0;
        int[] buff1 = new int[chars1.length];
        int[] buff2 = new int[chars2.length];
        for (int i = 0; i < Math.max(chars1.length, chars2.length); i++) {
            if (p1 > -1 && i < chars1.length) {
                if (chars1[i] != BACKSPACE) buff1[p1++] = chars1[i];
                else p1 = (--p1 < 0) ? 0 : p1;
            }
            if (p2 > -1 && i < chars2.length) {
                if (chars2[i] != BACKSPACE) buff2[p2++] = chars2[i];
                else p2 = (--p2 < 0) ? 0 : p2;
            }
        }
        if (p1 < 1 && p2 < 1) return true;
        if (p1 != p2) return false;
        for (int i = 0; i < p1; i++) {
            if (buff1[i] != buff2[i]) return false;
        }
        return true;
    }

    // Вариант с поиском букв с конца
    // Посчитаем символы удаления, потом пропустим сколько насчитали и это будет последня буква
    //
    //Runtime: 2 ms, faster than 65.41% of Java online submissions for Backspace String Compare.
    //Memory Usage: 42.1 MB, less than 63.16% of Java online submissions for Backspace String Compare.
    public boolean backspaceCompare2(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int count1 = 0;
        int count2 = 0;
        int p1 = chars1.length - 1;
        int p2 = chars2.length - 1;
        for (; ; ) {
            while (p1 > -1 && (count1 > 0 || chars1[p1] == BACKSPACE))
                count1 += (chars1[p1--] == BACKSPACE) ? 1 : -1;
            while (p2 > -1 && (count2 > 0 || chars2[p2] == BACKSPACE))
                count2 += (chars2[p2--] == BACKSPACE) ? 1 : -1;
            if (p1 < 0 && p2 < 0) return true;
            if (p1 < 0 || p2 < 0) return false;
            if (chars1[p1] != chars2[p2]) return false;
            p1--;
            p2--;
        }
    }

}
