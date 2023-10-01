package leetcode.solution.ready;

public class Solution0551 {

    private static final char ABSENT = 'A';
    private static final char LATE = 'L';
    private static final char PRESENT = 'P';

    //Runtime 0ms, Beats 100.00%of users with Java
    //Memory 40.28MB, Beats 84.20%of users with Java
    //
    // Интересно если не конвертировать в массив
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        byte countAbsent = 0;
        byte countLate = 0;
        for (char c : chars) {
            if (c == PRESENT) countLate = 0;
            else if (c == LATE) countLate++;
            else if (c == ABSENT) {
                countAbsent++;
                countLate = 0;
            }
            if (countAbsent == 2 || countLate == 3) return false;
        }
        return true;
    }

    //Runtime 0ms, Beats 100.00%of users with Java
    //Memory 40.36MB, Beats 71.74%of users with Java
    public boolean checkRecordV2(String s) {
        byte countAbsent = 0;
        byte countLate = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == PRESENT) countLate = 0;
            else if (c == LATE) countLate++;
            else if (c == ABSENT) {
                countAbsent++;
                countLate = 0;
            }
            if (countAbsent == 2 || countLate == 3) return false;
        }
        return true;
    }

}
