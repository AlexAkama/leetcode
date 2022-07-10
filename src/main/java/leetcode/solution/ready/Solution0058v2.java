package leetcode.solution.ready;

//
// Поиск длинны последнего слова
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
//Memory Usage: 41.7 MB, less than 80.43% of Java online submissions for Length of Last Word.
public class Solution0058v2 {

    public int lengthOfLastWord(String s) {
        int counter = 0;
        int i = s.length() - 1;
        while (i > -1 && s.charAt(i) == ' ') {
            i--;
        }
        while (i > -1 && s.charAt(i) != ' ') {
            counter++;
            i--;
        }
        return counter;
    }

}
