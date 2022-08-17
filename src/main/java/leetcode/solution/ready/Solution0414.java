package leetcode.solution.ready;

import java.util.Arrays;

//
// Найти третий максимум
// https://leetcode.com/problems/third-maximum-number/
//
public class Solution0414 {

    // Можно попробовать без сортировки и сделать поиск максима и складывать их что-то типа стека на троих
    //
    //Runtime: 1 ms, faster than 97.93% of Java online submissions for Third Maximum Number.
    //Memory Usage: 42.8 MB, less than 83.54% of Java online submissions for Third Maximum Number.
    private static final long MIN = Long.MIN_VALUE;

    long firstMax = MIN;
    long secondMax = MIN;
    long thirdMax = MIN;

    public int thirdMax(int[] nums) {
        for (int num : nums) addToMax(num);
        return (thirdMax == MIN) ? (int) firstMax : (int) thirdMax;
    }

    private void addToMax(int num) {
        if (num > firstMax) {
            thirdMax = secondMax;
            secondMax = firstMax;
            firstMax = num;
            return;
        }
        if (num < firstMax && num > secondMax) {
            thirdMax = secondMax;
            secondMax = num;
            return;
        }
        if (num < secondMax && num > thirdMax) {
            thirdMax = num;
        }
    }


    //Runtime: 4 ms, faster than 67.36% of Java online submissions for Third Maximum Number.
    //Memory Usage: 43.4 MB, less than 66.69% of Java online submissions for Third Maximum Number
    public int thirdMax1(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        Integer res = null;
        int p = nums.length - 2;
        int count = 1;
        while (res == null) {
            if (nums[p + 1] != nums[p]) count++;
            if (count == 3) res = nums[p];
            if (--p < 0 && count < 3) return nums[nums.length - 1];
        }
        return res;
    }

}
