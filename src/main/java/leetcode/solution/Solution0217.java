package leetcode.solution;

import java.util.HashSet;
import java.util.Set;

//
// Проверка на наличие дубликатов
//
public class Solution0217 {

    //Runtime: 6 ms, faster than 96.83% of Java online submissions for Contains Duplicate.
    //Memory Usage: 70 MB, less than 42.24% of Java online submissions for Contains Duplicate.
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> buff = new HashSet<>();
        for (int num : nums) {
            if (!buff.add(num)) return true;
        }
        return false;
    }

}
