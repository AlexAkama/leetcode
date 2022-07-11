package leetcode.solution.ready;

//
// Строка полиндром
//
// + Character.isLetterOrDigit()
// + Character.toLowerCase()
public class Solution0125 {

    //Runtime: 872 ms, faster than 21.57% of Java online submissions for Valid Palindrome.
    //Memory Usage: 47.3 MB, less than 23.86% of Java online submissions for Valid Palindrome.
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z\\d]", "").toLowerCase(); // видимо долго из-за этого
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) return false;
        }
        return true;
    }

    //Runtime: 6 ms, faster than 66.43% of Java online submissions for Valid Palindrome.
    //Memory Usage: 43.7 MB, less than 62.22% of Java online submissions for Valid Palindrome.
    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) sb.append(Character.toLowerCase(s.charAt(i))); //+
        }
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) return false;
        }
        return true;
    }


}
