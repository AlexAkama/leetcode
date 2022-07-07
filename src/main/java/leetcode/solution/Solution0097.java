package leetcode.solution;

//
// Решение простой рекурсией при тестах дает Time Limit Exceeded
//
// Вариант с кеширавнием взят от сюда
// https://www.youtube.com/watch?v=kbuYSSW54tk&t=22s
//
public class Solution0097 {

    private String ss1;
    private String ss2;
    private String ss3;
    private boolean[][] falseCache;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
        if (s1.isEmpty() || s2.isEmpty()) return (s2.isEmpty()) ? s3.equals(s1) : s3.equals(s2);
        if (s1.length() + s2.length() != s3.length()) return false;
        ss1 = s1;
        ss2 = s2;
        ss3 = s3;
        falseCache = new boolean[s1.length() + 1][s2.length() + 1];
        return foo(0, 0, 0);
    }

    private boolean foo(int p1, int p2, int p3) {
        if (falseCache[p1][p2]) return false;
        if (p3 == ss3.length()) return true;
        boolean trueStatus =
                (p1 < ss1.length() && ss1.charAt(p1) == ss3.charAt(p3) && foo(p1 + 1, p2, p3 + 1))
                        || (p2 < ss2.length() && ss2.charAt(p2) == ss3.charAt(p3) && foo(p1, p2 + 1, p3 + 1));
        if (!trueStatus) falseCache[p1][p2] = true;
        return trueStatus;
    }

}
