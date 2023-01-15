package leetcode.solution.ready;

//
// Посчитать количество токенов
// https://leetcode.com/problems/number-of-valid-words-in-a-sentence/
//
public class Solution2047 {

    //Runtime 2 ms. Beats 99.63%
    //Memory 40.5 MB. Beats 100%
    public int countValidWords(String sentence) {
        int count = 0;
        boolean isGoodWord = false;
        boolean usedDash = false;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                if (isGoodWord) {
                    count++;
                    isGoodWord = false;
                    usedDash = false;
                }
                continue;
            }
            if (Character.isDigit(c)
                    || ((c == '!' || c == '.' || c == ',') && (i < sentence.length() - 1 && sentence.charAt(i + 1) != ' '))
                    || (c == '-' && (usedDash || i == 0 || i == sentence.length() - 1 || sentence.charAt(i - 1) == ' ' || !Character.isLetter(sentence.charAt(i + 1))))) {
                while (i < sentence.length() && sentence.charAt(i) != ' ') i++;
                isGoodWord = false;
                usedDash = false;
                continue;
            }
            if (c == '-') usedDash = true;
            isGoodWord = true;
        }
        if (isGoodWord) count++;
        return count;
    }

}
