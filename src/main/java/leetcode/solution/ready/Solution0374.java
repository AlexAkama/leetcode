package leetcode.solution.ready;

//
// Вернуть загаданное число
// guess() уже реализовано и по факту это compareTo
//
public class Solution0374 {

    private static final Integer PICK = 6;

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
    //Memory Usage: 38.9 MB, less than 94.83% of Java online submissions for Guess Number Higher or Lower.
    public int guessNumber(int n) {
        int res = guess(n);
        if (res == 0) return n;
        int left = 1;
        int right = Integer.MAX_VALUE;
        if (res == -1) right = n - 1;
        if (res == 1) left = n + 1;
        int pos = -1;
        while (res != 0) {
            pos = left + (right - left) / 2;
            res = guess(pos);
            if (res == -1) right = pos - 1;
            if (res == 1) left = pos + 1;
        }
        return pos;
    }


    private int guess(Integer n) {
        return PICK.compareTo(n);
    }

}
