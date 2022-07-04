package leetcode.solution;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//
// Создание Map.Entry
//
public class Solution1710v2 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (int[] boxType : boxTypes) {
            list.add(new AbstractMap.SimpleEntry<>(boxType[0], boxType[1])); //
        }
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int max = 0;
        int pointer = 0;
        int i = truckSize;
        while (i > 0 && pointer < list.size()) {
            Map.Entry<Integer, Integer> entry = list.get(pointer++);
            int val = Math.min(entry.getKey(), i);
            max += entry.getValue() * val;
            i -= val;
        }
        return max;
    }

}
