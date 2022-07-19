package leetcode.solution.ready;

import java.util.HashSet;
import java.util.Set;

//
// Поиск близких дубликатов (в пределах k)
//
public class Solution0219 {

    //Time Limit Exceeded при больших k (думаю что из-за создания и очистки толстого сета)
    //надо попробовать на одном
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        Set<Integer> set = new HashSet<>(k);
        int limit = (nums.length > k) ? nums.length - k + 1 : nums.length;
        for (int i = 0; i < limit; i++) {
            set.clear();
            for (int j = i; j < Math.min(i + k + 1, nums.length); j++) {
                if (!set.add(nums[j])) return true;
            }
        }
        return false;
    }

    //Runtime: 27 ms, faster than 82.10% of Java online submissions for Contains Duplicate II.
    //Memory Usage: 77.7 MB, less than 73.45% of Java online submissions for Contains Duplicate II.
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (k == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }

}
