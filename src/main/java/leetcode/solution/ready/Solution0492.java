package leetcode.solution.ready;

import java.util.Arrays;

//
// Построить прямоугольник по заданной площади
// так что бы разницам между длинами сторон была минимальной
//
// https://leetcode.com/problems/construct-the-rectangle/
public class Solution0492 {

    public static void main(String[] args) {
        int[] ints = constructRectangle(3);
        System.out.println(Arrays.toString(ints));
    }

    //Runtime 0ms, Beats 100%
    //Memory 40.1MB, Beats /29.62%
    public static int[] constructRectangle(int area) {
        int q = (int) Math.sqrt(area);
        int s = q * q;
        if (s == area) return new int[]{q, q};
        while (s != area) {
            s = q * (area / q--);
        }
        return new int[]{area / ++q, q,};
    }


}
