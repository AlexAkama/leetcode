package leetcode.solution;

import java.util.Arrays;

//
// Поиск самой длинной последовательности последовательных элементов в не сортированном массиве
//
// + Сортировка массива
//
//Runtime: 19 ms
//Memory Usage: 64.3 MB
public class Solution0128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        Arrays.sort(nums); //+
        int max = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] - 1) temp++;
            else if (nums[i - 1] != nums[i]) {
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        return Math.max(max, temp);
    }

}
