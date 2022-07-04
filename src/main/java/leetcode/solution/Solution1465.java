package leetcode.solution;

import java.util.Arrays;

//
// Режем торт (прямоугольный), ищем больший кусок (площадь)
// Кусок будет с самыми большими отрезками
// ищем максимальные отрезки по x и y
//
public class Solution1465 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int start = 0;
        int maxH = 0;
        for (int cut : horizontalCuts) {
            maxH = Math.max(cut - start, maxH);
            start = cut;
        }
        maxH = Math.max(h - start, maxH);
        start = 0;
        int maxW = 0;
        for (int cut : verticalCuts) {
            maxW = Math.max(cut - start, maxW);
            start = cut;
        }
        maxW = Math.max(w - start, maxW);
        int mod = 1000000007;
        return (int) (((long) maxH * maxW) % mod);
    }

}
