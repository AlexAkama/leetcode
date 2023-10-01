package leetcode.solution.ready;

/*
Реверсирование всех слов в строке

https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class Solution0557 {

    //Runtime 3ms, Beats 98.87%of users with Java
    //Memory 44.03MB, Beats 76.51%of users with Java
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int finish = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ' ') {
                finish = i;
                reversePartOfString(chars, start, finish);
                start = finish + 1;
            }
        }
        finish = chars.length;
        reversePartOfString(chars, start, finish);
        return new String(chars);
    }

    private void reversePartOfString(char[] chars, int start, int finish) {
        int length = finish - start;
        for (int i = 0; i < length / 2; i++) {
            char temp = chars[finish - 1 - i];
            chars[finish - 1 - i] = chars[start + i];
            chars[start + i] = temp;
        }
    }

}
