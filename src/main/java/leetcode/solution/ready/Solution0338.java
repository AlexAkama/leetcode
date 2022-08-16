package leetcode.solution.ready;

//
// Выдать в массиве кол-во значащих бит от 0 до n
// Подзадача:
// Найти количество значащих бит в числе
// https://leetcode.com/problems/counting-bits/
//
public class Solution0338 {

    //Runtime: 3 ms, faster than 57.13% of Java online submissions for Counting Bits.
    //Memory Usage: 47.5 MB, less than 84.21% of Java online submissions for Counting Bits.
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++) res[i] = res[i >> 1] + (i & 1);
        return res;
    }

    //Runtime: 5 ms, faster than 29.00% of Java online submissions for Counting Bits.
    //Memory Usage: 48.5 MB, less than 19.34% of Java online submissions for Counting Bits.
    public int[] countBits1(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                count += (num & 1);
                num >>= 1;
            }
            res[i] = count;
        }
        return res;
    }

}
