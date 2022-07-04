package leetcode.solution;

public class Solution0026 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int counter = 1;
        int cursor = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cursor] != nums[i]) {
                nums[++cursor] = nums[i];
                counter++;
            }
        }
        return counter;
    }

}
