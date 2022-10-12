package leetcode.solution.ready;

//
// Бинарные операции
// Двоичное дополнение:
//   Число:      101
//   Дополнение: 010
// https://leetcode.com/problems/number-complement/submissions/
//
public class Solution0476 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Number Complement.
    //Memory Usage: 40.5 MB, less than 76.85% of Java online submissions for Number Complement.
    public int findComplement(int num) {
        int base = 0;
        int pov = 1;
        int i = num;
        while (i != 0) {
            base += pov;
            pov *= 2;
            i = i >> 1;
        }
        return num ^ base;
    }
}
