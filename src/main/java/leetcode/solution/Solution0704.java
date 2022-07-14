package leetcode.solution;

//
// Бинарный поиск
//
public class Solution0704 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
    //Memory Usage: 54.7 MB, less than 25.60% of Java online submissions for Binary Search.
    public int search(int[] nums, int target) {
        int start = 0;
        int finish = nums.length - 1;
        int middle;
        while (start != finish) {
            middle = start + (finish - start) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            } else {
                finish = middle;
            }
        }
        return (nums[start] == target) ? start : -1;
    }

}
