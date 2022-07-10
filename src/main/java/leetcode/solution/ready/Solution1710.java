package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//
// Сортировка массива в обратном порядке
//
public class Solution1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<Integer> boxes = new ArrayList<>();
        for (int[] boxType : boxTypes) {
            for (int i = 0; i < boxType[0]; i++) {
                boxes.add(boxType[1]);
            }
        }
        int max = 0;
        boxes.sort(Comparator.reverseOrder()); //
        for (int i = 0; i < truckSize && i < boxes.size(); i++) {
            max += boxes.get(i);
        }
        return max;
    }

}

