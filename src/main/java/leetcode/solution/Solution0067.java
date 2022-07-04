package leetcode.solution;

//
// Бинарное сложение
//
//Runtime: 3 ms, faster than 66.02% of Java online submissions for Add Binary.
//Memory Usage: 42.1 MB, less than 85.09% of Java online submissions for Add Binary.
public class Solution0067 {

    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        boolean offset = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ac = (a.length() - 1 - i > -1) ? a.charAt(a.length() - 1 - i) : '0';
            char bc = (b.length() - 1 - i > -1) ? b.charAt(b.length() - 1 - i) : '0';
            char res = (ac == bc) ? (offset) ? '1' : '0' : (offset) ? '0' : '1';
            offset = (ac == '1' && bc == '1')
                    || (ac == '1' && offset)
                    || (bc == '1' && offset);
            sb.append(res);
        }
        if (offset) sb.append(1);
        return sb.reverse().toString();
    }

}
