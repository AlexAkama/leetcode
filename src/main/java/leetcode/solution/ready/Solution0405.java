package leetcode.solution.ready;

//
// Перевод числа в шестнадцатеричную систему
//
// https://leetcode.com/problems/convert-a-number-to-hexadecimal/
public class Solution0405 {

    private static final char[] hexDigits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    private static final int RADIX = 16;

    private static final long BASE = 4294967296L;

    //Runtime: 1 ms, faster than 69.99% of Java online submissions for Convert a Number to Hexadecimal.
    //Memory Usage: 41.1 MB, less than 69.99% of Java online submissions for Convert a Number to Hexadecimal.
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        long n = num < 0 ? BASE + num : num;
        while (n > 0) {
            long digit = n % RADIX;
            sb.append(hexDigits[(int) digit]);
            n /= RADIX;
        }
        return sb.reverse().toString();
    }

}
