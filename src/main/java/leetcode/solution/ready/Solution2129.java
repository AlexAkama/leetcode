package leetcode.solution.ready;

//
// https://leetcode.com/problems/capitalize-the-title/
//
public class Solution2129 {

    //Runtime 2ms, Beats 91.90%of users with Java
    //Memory 40.55mb, Beats 99.71%of users with Java
    public String capitalizeTitle(String title) {
        if (title.length() < 2) return title.toLowerCase();
        var sb = new StringBuilder(title);
        int count = 0;
        boolean capitalized = false;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == ' ') {
                count = 0;
                capitalized = false;
            } else {
                sb.setCharAt(i, Character.toLowerCase(c));
                if (!capitalized && count++ > 1) {
                    sb.setCharAt(i - 2, Character.toUpperCase(sb.charAt(i - 2)));
                    count = 0;
                    capitalized = true;
                }
            }

        }
        return sb.toString();
    }

}
