package leetcode.solution.ready;

import java.util.Arrays;

//
// Поиск максимально возможного периметра треугольника
// https://leetcode.com/problems/largest-perimeter-triangle/submissions/
//
public class Solution0976 {

    // Runtime: 10 ms, faster than 81.46% of Java online submissions for Largest Perimeter Triangle.
    // Memory Usage: 55.2 MB, less than 5.69% of Java online submissions for Largest Perimeter Triangle.
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        var i = nums.length - 1;
        while (i > 1) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
            i--;
        }
        return 0;
    }

}
