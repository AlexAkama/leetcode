package leetcode.solution.ready;

//
// Можно ли создать строку из элементов другой строки
//
public class Solution0383 {

    //Runtime: 7 ms, faster than 59.10% of Java online submissions for Ransom Note.
    //Memory Usage: 45.7 MB, less than 71.64% of Java online submissions for Ransom Note.
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = sb.indexOf(Character.toString(ransomNote.charAt(i)));
            if (index == -1) return false;
            sb.deleteCharAt(index);
        }
        return true;
    }

    //Runtime: 2 ms, faster than 99.48% of Java online submissions for Ransom Note.
    //Memory Usage: 42.4 MB, less than 97.49% of Java online submissions for Ransom Note.
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] w = new int[26];
        char[] chars = magazine.toCharArray();
        for (char c : chars) w[c - 'a']++;
        chars = ransomNote.toCharArray();
        for (char c : chars) {
            if (--w[c - 'a'] < 0) return false;
        }
        return true;
    }

}
