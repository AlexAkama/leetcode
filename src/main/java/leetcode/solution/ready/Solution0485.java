package leetcode.solution.ready;

//
// Поиск максимальной длинны последовательности единиц в массиве из 0 и 1
// https://leetcode.com/problems/max-consecutive-ones/submissions/
//
public class Solution0485 {

    //Runtime: 3 ms, faster than 72.55% of Java online submissions for Max Consecutive Ones.
    //Memory Usage: 56.5 MB, less than 67.15% of Java online submissions for Max
    public int findMaxConsecutiveOnes(int[] nums) {
        var max = 0;
        var count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                if (count > max) max = count;
            } else count = 0;
        }
        return max;
    }

}
