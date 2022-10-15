package leetcode.solution.ready;

//
// Форматирование строки в строку формата группы заданного размером через тире
// https://leetcode.com/problems/license-key-formatting/submissions/
//
public class Solution0482 {

    private static final Character DASH = '-';

    //Runtime: 21 ms, faster than 70.23% of Java online submissions for License Key Formatting.
    //Memory Usage: 46.9 MB, less than 33.45% of Java online submissions for License Key Formatting.
    public String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        var count = 0;
        for (int i = chars.length - 1; i > -1; i--) {
            char c = chars[i];
            if (c == DASH) continue;
            if (count == k) {
                sb.append(DASH);
                count = 0;
            }
            sb.append(Character.isLowerCase(c) ? Character.toUpperCase(c) : c);
            count++;
        }
        return sb.reverse().toString();
    }

}
