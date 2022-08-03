package leetcode.solution.ready;

//
// Удаление нулей из массива, без создания копии массива
// https://leetcode.com/problems/move-zeroes/
//
public class Solution0283 {

    //Runtime: 2 ms, faster than 82.89% of Java online submissions for Move Zeroes.
    //Memory Usage: 55.4 MB, less than 9.57% of Java online submissions for Move Zeroes.
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[p++] = nums[i];
        }
        while (p < nums.length) {
            nums[p++] = 0;
        }
    }

}
