package leetcode.solution.ready;

//
// Поменять две буквы, что бы было что надо
// https://leetcode.com/problems/buddy-strings/
//
public class Solution0859 {

    //Runtime 1 ms. Beats 100%
    //Memory 42.1 MB. Beats 77.90%
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            int[] w = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (++w[s.charAt(i) - 'a'] > 1) return true;
            }
            return false;
        }
        int count = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (count == 1) left = i;
                else if (count == 2) right = i;
                else return false;
            }
        }
        if (count == 2) return s.charAt(left) == goal.charAt(right)
                && s.charAt(right) == goal.charAt(left);
        return false;
    }

}
