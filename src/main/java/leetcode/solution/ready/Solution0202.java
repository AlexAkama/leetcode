package leetcode.solution.ready;

//
// Счастливое число
// Каждую цифру в квадрат и складываем, повторяем это до тех пор пока не останется 1ца.
//
// Ход мыслей:
// Вроде просто - процесс в рекурсию пока нге получим 1, остальное - "не счастливые"
// Подводный камень n=7 -> true!!!
public class Solution0202 {

    //Runtime: 1 ms, faster than 98.70% of Java online submissions for Happy Number.
    //Memory Usage: 41.1 MB, less than 59.31% of Java online submissions for Happy Number.
    public boolean isHappy(int n) {
        if (n == 1 || n == 7) return true;
        if (n < 10) return false;
        int a = 0;
        while (n > 0) {
            int d = n % 10;
            a += d * d;
            n /= 10;
        }
        return isHappy(a);
    }

}
