package leetcode.solution;

public class Solution0069 {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        double i;
        double j = x >> 1;
        do {
            i = j;
            j = (i + (x / i)) / 2;
        } while ((i - j) != 0);
        return (int) j;
    }

}
