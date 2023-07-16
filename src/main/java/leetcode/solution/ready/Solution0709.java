package leetcode.solution.ready;

//
// https://leetcode.com/problems/to-lower-case/description/
//
// s.toLowerCase() ???
//
public class Solution0709 {

    //Runtime 1ms, Beats 17.48%of users with Java
    //Memory 40.87mb, Beats 32.48%of users with Java
    public String toLowerCase(String s) {
        var sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(sb.charAt(i))) sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
        }
        return sb.toString();
    }

    //USE s.toLowerCase()
    //Runtime -ms, Beats 100.00%of users with Java
    //Memory 40.28mb, Beats 98.62%of users with Java

}
