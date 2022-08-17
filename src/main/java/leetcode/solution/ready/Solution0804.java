package leetcode.solution.ready;

import java.util.HashSet;
import java.util.Set;

//
// Азбука Морзе
// Одинаковые последовательности
// https://leetcode.com/problems/unique-morse-code-words/
//
public class Solution0804 {

    private static final String[] MORSE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    //Runtime: 2 ms, faster than 99.55% of Java online submissions for Unique Morse Code Words.
    //Memory Usage: 42.1 MB, less than 60.25% of Java online submissions for Unique Morse Code Words.
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) set.add(getMorseString(word));
        return set.size();
    }

    private String getMorseString(String word) {
        StringBuilder sb = new StringBuilder();
        char[] chars = word.toCharArray();
        for (char c : chars) sb.append(MORSE[c - 'a']);
        return sb.toString();
    }

}
