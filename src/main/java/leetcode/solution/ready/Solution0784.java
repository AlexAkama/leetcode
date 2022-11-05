package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//
// Вернуть все варианты с заменой регистра букв
// https://leetcode.com/problems/letter-case-permutation/
//
// Использована рекурсия т.к. ограничение длинны входной строки = 12
public class Solution0784 {

    private List<String> res;

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        res = new ArrayList<>();
        res.add(String.valueOf(chars));
        foo(0, chars);
        return res;
    }

    private void foo(int start, char[] chars) {
        if (start > chars.length - 1) return;
        for (int i = start; i < chars.length; i++) {
            var c = chars[i];
            if (Character.isDigit(c)) continue;
            foo(i + 1, Arrays.copyOf(chars, chars.length));
            chars[i] = Character.toUpperCase(c);
            res.add(String.valueOf(chars));
        }
    }

}
