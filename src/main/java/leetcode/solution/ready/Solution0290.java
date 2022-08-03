package leetcode.solution.ready;

import java.util.HashMap;
import java.util.Map;

//
// Паттерн предложения
// https://leetcode.com/problems/word-pattern/
//
public class Solution0290 {

    //Runtime: 1 ms, faster than 97.56% of Java online submissions for Word Pattern.
    //Memory Usage: 40 MB, less than 97.00% of Java online submissions for Word Pattern.
    public boolean wordPattern(String pattern, String s) {
        Map<Character, Integer> patternMap = new HashMap<>(26);
        Map<String, Integer> stringMap = new HashMap<>(26);
        char[] patternChars = pattern.toCharArray();
        char[] stringChars = s.toCharArray();
        int patternCount = 0;
        int stringCount = 0;
        int p = 0;
        for (char patternChar : patternChars) {
            Integer patternInteger = patternMap.get(patternChar);
            if (patternInteger == null) {
                patternInteger = patternCount;
                patternMap.put(patternChar, patternCount++);
            }
            StringBuilder sb = new StringBuilder();
            while (p < stringChars.length && stringChars[p] != ' ') {
                sb.append(stringChars[p++]);
            }
            p++;
            String word = sb.toString();
            Integer stringInteger = stringMap.get(word);
            if (stringInteger == null) {
                stringInteger = stringCount;
                stringMap.put(word, stringCount++);
            }
            if (patternInteger.intValue() != stringInteger.intValue()) return false;
        }
        return --p == stringChars.length;
    }

}
