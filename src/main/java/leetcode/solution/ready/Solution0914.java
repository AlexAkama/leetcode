package leetcode.solution.ready;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//
// Разбить на группы одинакового размера
// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
//
// Используется наибольший общий делитель
//
public class Solution0914 {

    //Runtime 14 ms. Beats 45.77%
    //Memory 42.2 MB. Beats 87.68%
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            if (value == 1) return false;
            set.add(value);
        }
        if (set.size() == 1) return true;
        int prev = 0;
        int gcd = 10_000;
        for (Integer integer : set) {
            if (prev != 0) {
                int temp = gcd(prev, integer);
                if (temp < gcd) gcd = temp;
            }
            prev = integer;
        }
        if (gcd == 1) return false;
        for (Integer integer : set) {
            if (integer % gcd != 0) return false;
        }
        return true;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
