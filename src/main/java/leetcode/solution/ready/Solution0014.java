package leetcode.solution.ready;

//
// Поиск максимального префиска
//
public class Solution0014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length ==  1) return strs[0];
        String base = strs[0];
        String prefix = "";
        String temp;
        for (int i = 0; i < base.length(); i++) {
            temp = prefix + base.charAt(i);
            for (String str : strs) {
                if (str.length() == i) return prefix;
                if (str.charAt(i) != temp.charAt(i)) return prefix;
            }
            prefix = temp;
        }
        return prefix;
    }

}
