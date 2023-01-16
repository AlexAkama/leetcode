package leetcode.solution.ready;

//
// Садим розы через одну
// https://leetcode.com/problems/can-place-flowers/
//
public class Solution0605 {

    //Runtime 1 ms. Beats 100%
    //Memory 43.5 MB. Beats 56.56%
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 || (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1)) return true;
        int count = 0;
        int zeros = 0;
        for (int i = 0; i < flowerbed.length + 1; i++) {
            if (i < flowerbed.length && flowerbed[i] == 0) {
                zeros++;
                if (i == 0 || i == flowerbed.length - 1) zeros++;
            } else {
                if (zeros % 2 == 0) zeros--;
                if (zeros > 1) count += zeros / 2;
                if (count > n) return true;
                zeros = 0;
            }
        }
        return count == n;
    }

}
