package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
// Поиск пересечения массивов
// https://leetcode.com/problems/intersection-of-two-arrays-ii/
//
public class Solution0350 {

    //Runtime: 1 ms, faster than 99.83% of Java online submissions for Intersection of Two Arrays II.
    //Memory Usage: 43.6 MB, less than 71.00% of Java online submissions for Intersection of Two Arrays II.
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] cache = new int[1001];
        for (int i : nums1) cache[i]++;
        int[] accum = new int[Math.max(nums1.length, nums2.length)];
        int p = 0;
        for (int i : nums2) {
            if (cache[i] != 0) {
                accum[p++] = i;
                cache[i]--;
            }
        }
        return Arrays.copyOf(accum, p);
    }

    //Runtime: 4 ms, faster than 72.60% of Java online submissions for Intersection of Two Arrays II.
    //Memory Usage: 44.5 MB, less than 14.05% of Java online submissions for Intersection of Two Arrays II.
    public int[] intersection1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] res = new int[list.size()];
        int count = 0;
        for (int num : list) {
            res[count++] = num;
        }
        return res;
    }

}
