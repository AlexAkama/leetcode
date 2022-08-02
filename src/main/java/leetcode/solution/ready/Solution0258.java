package leetcode.solution.ready;

//
// Складываем цифры числа между собой пока не останется одна цифра
// https://leetcode.com/problems/add-digits/
//
public class Solution0258 {

    //Runtime: 2 ms, faster than 72.51% of Java online submissions for Add Digits.
    //Memory Usage: 41.8 MB, less than 25.01% of Java online submissions for Add Digits.
    public int addDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num > 0) {
            int d = num % 10;
            sum += d;
            num /= 10;
        }
        return addDigits(sum);
    }

}
