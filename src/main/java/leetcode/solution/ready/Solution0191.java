package leetcode.solution.ready;

//
// Возвращает кол-во битов "1" в числе (вес Хэмминга)
//
// Побитовые операции
public class Solution0191 {

    //Runtime: 1 ms, faster than 85.79% of Java online submissions for Number of 1 Bits.
    //Memory Usage: 41.1 MB, less than 61.81% of Java online submissions for Number of 1 Bits.
    public int hammingWeight(int n) {
        int res = 0;
        int i = 32;
        while (i != 0) {
            int last = n & 1;
            n = n >> 1;
            res += last;
            i--;
        }
        return res;
    }

}
