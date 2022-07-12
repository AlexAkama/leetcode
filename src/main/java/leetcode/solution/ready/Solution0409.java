package leetcode.solution.ready;

import java.util.HashMap;
import java.util.Map;

//
// Вернуть максимально возможную длину полиндрома созданного из строки
//
// Ход мыслей
// Первое это пройти циклом с вложенным циклом и определять полиндром или нет
// если да возвращать max
// !!! Задача была понята неправильно, надо не найти, а составить максимальный полиндром
// Идея посчитать кол-во повторений всех букв и его проанализировать
//
// Возможно можно оптимизировать убрав map и containsKey
public class Solution0409 {

    public int longestPalindrome0(String s) {
        if (s.length() == 1) return 1;
        StringBuilder sb = new StringBuilder(s);
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome(sb, j, i) && (i - j + 1) > max) max = i - j + 1;
            }
        }
        return max;
    }

    private boolean isPalindrome(StringBuilder sb, int start, int finish) {
        for (int i = start; i < start + (finish - start + 1) / 2; i++) {
            if (sb.charAt(i) != sb.charAt(finish + start - i)) return false;
        }
        return true;
    }

    //Runtime: 8 ms, faster than 38.66% of Java online submissions for Longest Palindrome.
    //Memory Usage: 41.9 MB, less than 77.66% of Java online submissions for Longest Palindrome.
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int singleChar = 0;
        int res = 0;
        for (Integer i : map.values()) {
            if (i == 1) {
                singleChar = 1;
                continue;
            }
            int temp = (i >> 1) << 1;
            res += temp;
            if (i != temp) singleChar = 1;
        }
        return res + singleChar;
    }

}
