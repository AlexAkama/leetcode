package leetcode.solution.ready;

//
// Заголовки столбцов Excel в порядковые номера
//
public class Solution0171 {

    //Runtime: 2 ms, faster than 78.52% of Java online submissions for Excel Sheet Column Number.
    //Memory Usage: 42.4 MB, less than 77.02% of Java online submissions for Excel Sheet Column
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int pov = 1;
        for (int i = columnTitle.length() - 1; i > -1; i--) {
            int c = columnTitle.charAt(i) - 'A';
            res += (c + 1) * pov;
            pov *= 26;
        }
        return res;
    }

}
