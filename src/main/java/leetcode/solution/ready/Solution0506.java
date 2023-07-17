package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

//
// Проставить места по балам, макс бал - первое место
//
// https://leetcode.com/problems/relative-ranks/
public class Solution0506 {

    public static void main(String[] args) {
        Solution0506 sol = new Solution0506();
        sol.findRelativeRanksV1(new int[]{10, 3, 8, 9, 4});
    }

    //Runtime 11ms, Beats 39.9%
    //Memory 43.6MB, Beats 37.96%
    //
    // В целом рабочий вариант
    public String[] findRelativeRanksV0(int[] score) {
        SortedMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        String[] res = new String[score.length];
        int count = 1;
        for (Integer key : map.keySet()) {
            int pos = map.get(key);
            if (count == 1) {
                res[pos] = "Gold Medal";
            } else if (count == 2) {
                res[pos] = "Silver Medal";
            } else if (count == 3) {
                res[pos] = "Bronze Medal";
            } else {
                res[pos] = String.valueOf(count);
            }
            count++;
        }
        return res;
    }

    //Runtime 699ms, Beats 5.22%
    //Memory 43.5MB, Beats 47.27%
    //
    // ОЧЕНЬ плохо по времени
    public String[] findRelativeRanksV1(int[] score) {
        String[] res = new String[score.length];
        List<Integer> list = new ArrayList<>();
        for (int i : score) list.add(i);
        Collections.sort(list);
        for (int i = 0; i < res.length; i++) {
            if (list.indexOf(score[i]) == score.length - 1) res[i] = "Gold Medal";
            else if (list.indexOf(score[i]) == score.length - 2) res[i] = "Silver Medal";
            else if (list.indexOf(score[i]) == score.length - 3) res[i] = "Bronze Medal";
            else res[i] = score.length - list.indexOf(score[i]) + "";
        }
        return res;
    }

}
