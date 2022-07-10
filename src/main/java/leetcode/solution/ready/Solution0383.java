package leetcode.solution.ready;

//
// Можно ли создать строку из элементов другой строки
//
public class Solution0383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = sb.indexOf(Character.toString(ransomNote.charAt(i)));
            if (index == -1) return false;
            sb.deleteCharAt(index);
        }
        return true;
    }

}
