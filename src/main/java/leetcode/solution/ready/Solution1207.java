package leetcode.solution.ready;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//
// Кол-во вхождений в массив уникально
// https://leetcode.com/problems/unique-number-of-occurrences/
//
public class Solution1207 {

    //Runtime: 4 ms, faster than 67.10% of Java online submissions for Unique Number of Occurrences.
    //Memory Usage: 42.5 MB, less than 16.92% of Java online submissions for Unique Number of Occurrences.
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            if (!set.add(value)) return false;
        }
        return true;
    }

}
