package leetcode.solution.ready;

//
// Суммирование чисел представленных строками
// https://leetcode.com/problems/add-strings/
//
public class Solution0415 {

    //Runtime: 3 ms, faster than 84.69% of Java online submissions for Add Strings.
    //Memory Usage: 43.4 MB, less than 55.34% of Java online submissions for Add Strings.
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int maxLength = Math.max(length1, length2);
        boolean offset = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            int index1 = length1 - 1 - i;
            int digit1 = (index1 > -1) ? chars1[index1] - '0' : 0;
            int index2 = length2 - 1 - i;
            int digit2 = (index2 > -1) ? chars2[index2] - '0' : 0;
            int offsetDigit = (offset) ? 1 : 0;
            int res = digit1 + digit2 + offsetDigit;
            offset = res > 9;
            sb.append((offset) ? res - 10 : res);
        }
        if (offset) sb.append("1");
        return sb.reverse().toString();
    }

}
