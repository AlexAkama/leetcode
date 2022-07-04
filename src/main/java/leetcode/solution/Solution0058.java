package leetcode.solution;

//
// Поиск длинны последнего слова
//
//Runtime: 6 ms
//Memory Usage: 43.1 MB
public class Solution0058 {
    public int lengthOfLastWord(String s) {
        String[] split = s.trim().split("\\s+");
        return split[split.length -1].length();
    }
}
