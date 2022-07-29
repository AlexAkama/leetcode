package leetcode.solution.ready;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//
// Поиск слов по шаблону
// https://leetcode.com/problems/find-and-replace-pattern/
//
public class Solution0890 {

    //Runtime: 2 ms, faster than 74.25% of Java online submissions for Find and Replace Pattern.
    //Memory Usage: 43.2 MB, less than 33.39% of Java online submissions for Find and Replace Pattern.
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] patternFrame = getFrame(pattern);
        List<String> list = new LinkedList<>();
        for (String word : words) {
            if (match(word, patternFrame)) list.add(word);
        }
        return list;
    }

    private boolean match(String word, int[] patternFrame) {
        Map<Character, Integer> map = new HashMap<>(26);
        int count = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) map.put(chars[i], count++);
            if (patternFrame[i] != map.get(chars[i])) return false;
        }
        return true;
    }

    private int[] getFrame(String s) {
        int[] frame = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>(26);
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) map.put(chars[i], count++);
            frame[i] = map.get(chars[i]);
        }
        return frame;
    }

}
