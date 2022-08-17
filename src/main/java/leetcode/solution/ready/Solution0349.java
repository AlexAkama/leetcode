package leetcode.solution.ready;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//
// Поиск пересечения массивов
// https://leetcode.com/problems/intersection-of-two-arrays/
//
public class Solution0349 {

    //Runtime: 1 ms, faster than 99.87% of Java online submissions for Intersection of Two Arrays.
    //Memory Usage: 43.7 MB, less than 69.67% of Java online submissions for Intersection of Two Arrays.
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] counter1 = new int[1001];
        int[] counter2 = new int[1001];
        for (int i : nums1) counter1[i]++;
        for (int i : nums2) counter2[i]++;
        int[] minLengthNums = (nums1.length < nums2.length) ? nums1 : nums2;
        int[] accum = new int[minLengthNums.length];
        int p = 0;
        for (int i : minLengthNums) {
            if (counter1[i] > 0 && counter2[i] > 0) {
                accum[p++] = i;
                counter1[i] = 0;
                counter2[i] = 0;
            }
        }
        return Arrays.copyOf(accum, p);
    }


    //Runtime: 4 ms, faster than 74.41% of Java online submissions for Intersection of Two Arrays.
    //Memory Usage: 44.1 MB, less than 39.82% of Java online submissions for Intersection of Two Arrays.
    public int[] intersection1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums2) if (map.containsKey(i)) set.add(i);
        int[] res = new int[set.size()];
        int count = 0;
        for (int num : set) {
            res[count++] = num;
        }
        return res;
    }

}
