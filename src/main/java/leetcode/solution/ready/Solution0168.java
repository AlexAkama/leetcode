package leetcode.solution.ready;

//
// Заголовки как в Excel
//
public class Solution0168 {

    //Runtime: 12 ms, faster than 9.66% of Java online submissions for Excel Sheet Column Title.
    //Memory Usage: 42.3 MB, less than 6.75% of Java online submissions for Excel Sheet Column Title.
    private static final int RADIX = 26;

    public String convertToTitle(int columnNumber) {
        if (columnNumber-- == 0) return "";
        return convertToTitle(columnNumber / RADIX) + getChar(columnNumber % RADIX);
    }

    private char getChar(int i) {
        return (char) ('A' + i);
    }

    // Попробовал сделать быстрее
    //
    //Runtime: 11 ms, faster than 14.42% of Java online submissions for Excel Sheet Column Title.
    //Memory Usage: 42.1 MB, less than 14.42% of Java online submissions for Excel Sheet Column Title.
    public String convertToTitle2(int columnNumber) {
        if (columnNumber-- == 0) return "";
        return convertToTitle(columnNumber / 26) + (char) ('A' + columnNumber % 26);
    }

    // Без рекурсии (как изначально пробовал)
    //
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
    //Memory Usage: 42 MB, less than 14.42% of Java online submissions for Excel Sheet Column Title.
    //
    // Вывод если можно без рекурсии делать без нее.
    public String convertToTitle3(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            char c = (char) ('A' + (columnNumber - 1) % 26);
            res.insert(0, c);
            columnNumber = (columnNumber - 1) / 26;
        }
        return res.toString();
    }

}
