package leetcode.solution.ready;

//
// Побитовые операции
// Дистанция Хемминга - кол-во различных бит в числах
//
// https://leetcode.com/problems/hamming-distance/
public class Solution0461 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
    //Memory Usage: 41.1 MB, less than 35.99% of Java online submissions for Hamming Distance.
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if (((x & 1) == 1) != ((y & 1) == 1)) count++;
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }

}
