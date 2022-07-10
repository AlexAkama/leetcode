package leetcode.solution.ready;

import java.util.HashMap;
import java.util.Map;

//
// Римские цифры
//
public class Solution0013 {

    private final Map<Character, Integer> map = new HashMap<>();

    public Solution0013() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        Integer sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        sum += map.get(s.charAt(s.length() - 1));
        return sum;
    }

}