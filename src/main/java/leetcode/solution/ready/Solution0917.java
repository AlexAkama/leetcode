package leetcode.solution.ready;

/*
Реверсирование только букв

https://leetcode.com/problems/reverse-only-letters/
 */
public class Solution0917 {

    public String reverseOnlyLetters(String s) {
        char[] chars = new char[s.length()];
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) chars[p++] = s.charAt(i);
        }
        reverseTo(chars, p);
        char[] res = new char[s.length()];
        p = 0;
        for (int i = 0; i < s.length(); i++) {
            res[i] = Character.isLetter(s.charAt(i)) ? chars[p++] : s.charAt(i);
        }
        return new String(res);
    }

    private void reverseTo(char[] chars, int finish) {
        for (int i = 0; i < finish / 2; i++) {
            char temp = chars[finish - 1 - i];
            chars[finish - 1 - i] = chars[i];
            chars[i] = temp;
        }
    }


    //Runtime 1ms, Beats 50.39%of users with Java
    //Memory 40.81MB, Beats 21.86%of users with Java
    //
    // Вроде плохо по памяти, но разница очень маленькая
    // можно попробовать через массив
    public String reverseOnlyLettersV0(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) sb.append(c);
        }
        reverseV0(sb);
        StringBuilder res = new StringBuilder(s);
        int p = 0;
        for (int i = 0; i < res.length(); i++) {
            if (Character.isLetter(res.charAt(i))) res.setCharAt(i, sb.charAt(p++));
        }
        return res.toString();
    }

    private void reverseV0(StringBuilder sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            char temp = sb.charAt(sb.length() - 1 - i);
            sb.setCharAt(sb.length() - 1 - i, sb.charAt(i));
            sb.setCharAt(i, temp);
        }
    }

}
