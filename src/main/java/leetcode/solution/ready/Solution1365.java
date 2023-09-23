package leetcode.solution.ready;

//
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
//
public class Solution1365 {

    public static void main(String[] args) {
        smallerNumbersThanCurrent(new int[]{10, 0, 4, 3, 0, 5, 6, 3, 0, 7});
    }

    //Runtime 1ms, Beats 99.85%of users with Java
    //Memory 43.58mb, Beats 88.68%of users with Java
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counter = new int[101];
        for (int num : nums) {
            counter[num] = counter[num] + 1;
        }
        int accum = counter[0];
        counter[0] = 0;
        for (int i = 1; i < counter.length; i++) {
            int temp = counter[i];
            counter[i] = accum;
            accum += temp;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = counter[nums[i]];
        }
        return res;
    }

}
