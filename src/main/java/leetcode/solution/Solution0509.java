package leetcode.solution;

//
// Числа Фибоначи
// Рекурсия

//Runtime: 14 ms, faster than 16.78% of Java online submissions for Fibonacci Number.
//Memory Usage: 40.9 MB, less than 41.71% of Java online submissions for Fibonacci Number.
//
// При использовании прямого подсчета: значительно быстрее
// Метод из задачи №70
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
//Memory Usage: 40.9 MB, less than 49.33% of Java online submissions for Fibonacci Number.
//
public class Solution0509 {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        n--;
        int a = 0;
        int b = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = a + b;
            int temp = a + b;
            a = b;
            b = temp;
        }
        return res;
    }

}
