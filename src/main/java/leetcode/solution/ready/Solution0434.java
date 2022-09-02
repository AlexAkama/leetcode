package leetcode.solution.ready;

//
// Количество сегментов в строке
//
// https://leetcode.com/problems/number-of-segments-in-a-string/
public class Solution0434 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Segments in a String.
    //Memory Usage: 41.7 MB, less than 56.44% of Java online submissions for Number of Segments in a String.
    public int countSegments(String s) {
        if (s.trim().length() == 0) return 0;
        char[] chars = s.toCharArray();
        int count = 0;
        int prev = ' ';
        for (char c : chars) {
            if (c != ' ' && prev == ' ') count++;
            prev = c;
        }
        return count;
    }

}
