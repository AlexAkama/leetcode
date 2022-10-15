package leetcode.solution.ready;

//
// Посчитать что длиннее самая длинна последовательность 0 или 1
// https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
//
// Поиск самой длинной последовательности единиц в задаче 485
public class Solution1869 {

    //Runtime: 1 ms, faster than 95.20% of Java online submissions for Longer Contiguous Segments of Ones than Zeros.
    //Memory Usage: 42 MB, less than 50.60% of Java online submissions for Longer Contiguous Segments of Ones than Zeros.
    public boolean checkZeroOnes(String s) {
        char[] chars = s.toCharArray();
        var max0 = 0;
        var max1 = 0;
        var count0 = 0;
        var count1 = 0;
        for (char c : chars) {
            if (c == '1') {
                count1++;
                if (count1 > max1) max1 = count1;
                count0 = 0;
            } else {
                count0++;
                if (count0 > max0) max0 = count0;
                count1 = 0;
            }
        }
        return max1 > max0;
    }

}
