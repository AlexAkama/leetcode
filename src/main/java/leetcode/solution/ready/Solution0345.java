package leetcode.solution.ready;

import java.util.Set;

//
// Инвертировать только гласны буквы
//
// Массив символов в строку
// https://www.baeldung.com/java-char-array-to-string
public class Solution0345 {

    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

    //Runtime: 10 ms, faster than 42.43% of Java online submissions for Reverse Vowels of a String.
    //Memory Usage: 45.1 MB, less than 59.50% of Java online submissions for Reverse Vowels of a String.
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (true) {
            while (left < chars.length && !set.contains(Character.toLowerCase(chars[left]))) {
                left++;
            }
            while (right > -1 && !set.contains(Character.toLowerCase(chars[right]))) {
                right--;
            }
            if (left > right) break;
            char temp = chars[right];
            chars[right--] = chars[left];
            chars[left++] = temp;
        }
        return new String(chars);
    }

}
