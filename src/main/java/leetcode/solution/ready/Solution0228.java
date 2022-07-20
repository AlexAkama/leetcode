package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.List;

//
// Визуализировать отсортированный массив по непрерывным диапазонам
//
public class Solution0228 {

    //Runtime: 9 ms, faster than 51.91% of Java online submissions for Summary Ranges.
    //Memory Usage: 42.2 MB, less than 58.62% of Java online submissions for Summary Ranges.
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                String range = (start == i) ? "" + nums[i] : nums[start] + "->" + nums[i];
                list.add(range);
                start = i + 1;
            }
        }
        return list;
    }

}
