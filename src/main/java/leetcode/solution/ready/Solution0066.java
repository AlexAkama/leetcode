package leetcode.solution.ready;

//
// Перевод разряда
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
//Memory Usage: 40.4 MB, less than 97.49% of Java online submissions for Plus One.
public class Solution0066 {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i > -1) {
            boolean offset = ++digits[i] > 9;
            if (!offset) return digits;
            digits[i] = digits[i--] % 10;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

}
