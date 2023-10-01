package leetcode.solution.ready;

/*
Реверс части строки

https://leetcode.com/problems/reverse-string-ii/
 */
public class Solution0541 {

    //Runtime 1ms, Beats 81.77%of users with Java
    //Memory 43.32MB, Beats 56.25%of users with Java
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int num = s.length() / (k * 2);
        for (int i = 0; i < num + 1; i++) {
            reversePartOfString(sb, i * 2 * k, Math.min(i * 2 * k + k, sb.length()));
        }
        return sb.toString();
    }

    private void reversePartOfString(StringBuilder sb, int start, int finish) {
        int length = finish - start;
        for (int i = 0; i < length / 2; i++) {
            char temp = sb.charAt(finish - 1 - i);
            sb.setCharAt(finish - 1 - i, sb.charAt(start + i));
            sb.setCharAt(start + i, temp);
        }
    }

    //Runtime 1ms, Beats 81.67%of users with Java
    //Memory 43.68MB, Beats 22.96%of users with Java
    //
    // Плохо по памяти - может StringBuilder лучше?
    public String reverseStrV0(String s, int k) {
        char[] chars = s.toCharArray();
        int num = s.length() / (k * 2);
        for (int i = 0; i < num + 1; i++) {
            reversePartOfStringV0(chars, i * 2 * k, Math.min(i * 2 * k + k, chars.length));
        }
        return new String(chars);
    }

    private void reversePartOfStringV0(char[] chars, int start, int finish) {
        int length = finish - start;
        for (int i = 0; i < length / 2; i++) {
            char temp = chars[finish - 1 - i];
            chars[finish - 1 - i] = chars[start + i];
            chars[start + i] = temp;
        }
    }


}
