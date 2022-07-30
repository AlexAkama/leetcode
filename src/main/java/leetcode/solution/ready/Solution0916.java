package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.List;

//
// Найти все строки для которых другие строки являются их подмножеством
// https://leetcode.com/problems/word-subsets/
//
// + computeIfAbsent
// + putIfAbsent
public class Solution0916 {

    //Runtime: 17 ms, faster than 91.87% of Java online submissions for Word Subsets.
    //Memory Usage: 50.1 MB, less than 97.97% of Java online submissions for Word Subsets.
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] frame = getTotalFrame(words2);
        List<String> list = new ArrayList<>();
        for (String word : words1) {
            if (matchesTheTotalFrame(word, frame)) list.add(word);
        }
        return list;
    }

    private boolean matchesTheTotalFrame(String word, int[] frame) {
        int[] cur = getFrame(word);
        return isSubSet(cur, frame);
    }

    private boolean isSubSet(int[] base, int[] candidate) {
        for (int i = 0; i < 26; i++) {
            if (candidate[i] > base[i]) return false;
        }
        return true;
    }

    private int[] getTotalFrame(String[] words2) {
        int[] totalFrame = new int[26];
        for (String word : words2) {
            int[] frame = getFrame(word);
            for (int i = 0; i < 26; i++) {
                if (frame[i] > totalFrame[i]) totalFrame[i] = frame[i];
            }
        }
        return totalFrame;
    }

    private int[] getFrame(String word) {
        char[] chars = word.toCharArray();
        int[] ints = new int[26];
        for (char c : chars) ints[c - 'a']++;
        return ints;
    }

}
