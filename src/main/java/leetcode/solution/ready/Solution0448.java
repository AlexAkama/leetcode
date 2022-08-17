package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.List;

//
// Выдать отсутствующие (пропущенные, не добавленные) числа
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//
public class Solution0448 {

    //Runtime: 5 ms, faster than 97.95% of Java online submissions for Find All Numbers Disappeared in an Array.
    //Memory Usage: 67 MB, less than 46.83% of Java online submissions for Find All Numbers Disappeared in an Array.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] w = new int[n];
        for (int num : nums) w[num - 1]++;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            if (w[i] == 0) list.add(i + 1);
        }
        return list;
    }

}
