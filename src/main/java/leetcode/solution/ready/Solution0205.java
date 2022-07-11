package leetcode.solution.ready;

import java.util.HashMap;
import java.util.Map;

//
// Изоморфность
// Две строки s и t изоморфны, если символы в s можно заменить, чтобы получить t.
//
// Ход мыслей
// Например создать "схему", а потом ее сравнить
public class Solution0205 {

    //Runtime: 15 ms, faster than 41.30% of Java online submissions for Isomorphic Strings.
    //Memory Usage: 42.9 MB, less than 66.99% of Java online submissions for Isomorphic Strings.
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int counter1 = 0;
        int counter2 = 0;
        int code1;
        int code2;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map1.get(c1) == null) {
                map1.put(c1, counter1);
                code1 = counter1++;
            } else {
                code1 = map1.get(c1);
            }
            if (map2.get(c2) == null) {
                map2.put(c2, counter2);
                code2 = counter2++;
            } else {
                code2 = map2.get(c2);
            }
            if (code1 != code2) return false;
        }
        return true;
    }

}
