package leetcode.solution;

//
// Поиск первой бед версии
// Т.е. надо понять на каком шаге сломалась функция
// isBadVersion(i) - возвращает сломана функция на шаге i или нет
//
// Первое, что просилось рекурсия
// Второе, сужающийся цикл
public class Solution0278 {

    private static final int BAD = 5;

    //Runtime: 18 ms, faster than 62.95% of Java online submissions for First Bad Version.
    //Memory Usage: 40.9 MB, less than 49.36% of Java online submissions for First Bad Version.
    public int firstBadVersion2(int n) {
        int start = 1;
        int finish = n;
        int middle;
        while (start != finish) {
            middle = start + (finish - start) / 2;
            if (isBadVersion(middle)) {
                finish = middle;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }

    public int firstBadVersion(int n) {
        if (n == 1) return n;
        return find(1, n);
    }

    //Runtime: 20 ms, faster than 52.70% of Java online submissions for First Bad Version.
    //Memory Usage: 41.1 MB, less than 26.56% of Java online submissions for First Bad Version.
    private int find(int start, int finish) {
        int middle = start + (finish - start) / 2;
        if (finish == start) return finish;
        if (isBadVersion(middle)) {
            return find(start, middle);
        } else {
            return find(middle + 1, finish);
        }
    }

    boolean isBadVersion(int index) {
        return index >= BAD;
    }

}
