package leetcode.solution.ready;

//
// Проверить число это квадратный корень или нет
// Извлечение квадратного корня
// https://leetcode.com/problems/valid-perfect-square/
//
public class Solution0367 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
    //Memory Usage: 39.2 MB, less than 88.51% of Java online submissions for Valid Perfect Square.
    public boolean isPerfectSquare(int num) {
        double squareRoot = (double) num / 2;
        double temp = 0;
        while (temp - squareRoot != 0) {
            temp = squareRoot;
            squareRoot = (temp + (num / temp)) / 2;
        }
        return squareRoot - (long) squareRoot == 0;
    }

}
