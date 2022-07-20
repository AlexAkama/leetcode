package leetcode.solution.ready;

import java.util.HashMap;
import java.util.Map;

//
// Являются ли строки субпоследовательностью строки
// Субпоследовательность - это новая строка, сгенерированная из исходной строки с удалением некоторых символов
// (может не быть ни одного) без изменения относительного порядка оставшихся символов.
//
public class Solution0792 {

    private Map<String, Boolean> cache;

    public int numMatchingSubseq(String s, String[] words) {
        int sum = 0;
        cache = new HashMap<>();
        for (String word : words) {
            if (match(s, word)) sum++;
        }
        return sum;
    }

    //Runtime: 227 ms, faster than 30.67% of Java online submissions for Number of Matching Subsequences.
    //Memory Usage: 54.1 MB, less than 83.28% of Java online submissions for Number of Matching Subsequences.
    private boolean match(String s, String word) {
        if (cache.containsKey(word)) return cache.get(word);
        int p = 0;
        boolean res = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == word.charAt(p)) {
                p++;
                if (p == word.length()) {
                    res = true;
                    break;
                }
            }
        }
        cache.put(word, res);
        return res;
    }

    public int numMatchingSubseq2(String s, String[] words) {
        int sum = 0;
        cache = new HashMap<>();
        char[] sc = s.toCharArray();
        for (String word : words) {
            if (match2(sc, word)) sum++;
        }
        return sum;
    }

    //Runtime: 50 ms, faster than 97.56% of Java online submissions for Number of Matching Subsequences.
    //Memory Usage: 43 MB, less than 98.66% of Java online submissions for Number of Matching Subsequences.
    private boolean match2(char[] sc, String word) {
        if (cache.containsKey(word)) return cache.get(word);
        int p = 0;
        boolean res = false;
        char[] wc = word.toCharArray();
        for (char c : sc) {
            if (c == wc[p]) {
                p++;
                if (p == wc.length) {
                    res = true;
                    break;
                }
            }
        }
        cache.put(word, res);
        return res;
    }


}
