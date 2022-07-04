package leetcode.solution;

import java.util.HashMap;
import java.util.Map;

//
// Сортировка мапы по значению
//
public class Solution1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        Map<Integer, Integer> map = new HashMap<>(m);
        for (int i = 0; i < m; i++) {
            map.put(i, getPower(mat[i]));
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(i -> i)
                .toArray();
    }

    private int getPower(int[] ints) {
        int count = 0;
        for (int anInt : ints) {
            if (anInt == 1) count++;
            else return count;
        }
        return count;
    }

}
