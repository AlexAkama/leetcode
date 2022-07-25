package leetcode.solution.ready;

//
// Поиск начальной и конечной позиции заданного символа в массиве
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//
public class Solution0034 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
    //Memory Usage: 47.6 MB, less than 22.49% of Java online submissions for Find First and Last Position of Element in Sorted Array.
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return res;
        if (nums[0] == target && nums[nums.length - 1] == target) return new int[]{0, nums.length - 1};
        int start = 0;
        int finish = nums.length - 1;
        int middle = (start + finish) / 2;
        while (nums[middle] != target) {
            if (nums[middle] > target) finish = middle;
            else start = middle + 1;
            if (start == finish) {
                if (nums[start] == target) return new int[]{start, start};
                else return res;
            }
            middle = (start + finish) / 2;
        }
        res[0] = findLeft(nums, start, middle, target);
        res[1] = findRight(nums, middle , finish, target);
        return res;
    }

    private int findLeft(int[] nums, int start, int finish, int target) {
        if (finish - 1 > -1 && nums[finish - 1] < target) return finish;
        if (start == finish && nums[start] == target) return start;
        int middle = (start + finish) / 2;
        if (nums[middle] < target) start = middle;
        else finish = middle;
        return findLeft(nums, start, finish, target);
    }

    private int findRight(int[] nums, int start, int finish, int target) {
        if (start + 1 < nums.length && nums[start + 1] > target) return start;
        if (nums[finish] == target) return finish;
        if (nums[finish] > target && nums[finish - 1] == target) return finish - 1;
        if (start == finish && nums[start] == target) return start;
        int middle = (start + finish) / 2;
        if (nums[middle] > target) finish = middle;
        else start = middle;
        return findRight(nums, start, finish, target);
    }

}
