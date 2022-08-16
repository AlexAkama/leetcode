package leetcode.solution.ready;

//
// Window
// Вернуть длину самой большой подстроки при замене выбранной буквы k раз
// https://leetcode.com/problems/longest-repeating-character-replacement/
//
public class Solution0424 {

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] w = new int[26];
        int max = 0;
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, ++w[chars[i] - 'A']);
            if (max + k - 1 < i - p) w[chars[p++] - 'A']--;
        }
        return chars.length - p;
    }

}
