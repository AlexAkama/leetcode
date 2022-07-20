package leetcode.solution.ready;

import java.math.BigInteger;

//
// Кол-во путей из точки (0,0) в точку (x,y)
// Комбинаторика - количество сочетаний
//  k        k!             x+y   (x + y)!     | x   = m - 1    |      (m + n -2)!
// C  = --------------  => C   = ---------- => | y   = n - 1    | => -----------------
//  n   (n - k)! * r!       x     x! * y!      | x+y = m + n -2 |    (m -1)! * (n -1)!
//
// Еще можно через буфер
public class Solution0062 {

    BigInteger fm = BigInteger.ONE;
    BigInteger fn = BigInteger.ONE;
    BigInteger ft = BigInteger.ONE;

    public int uniquePaths(int m, int n) {
        factorial(m, n);
        BigInteger divide = ft.divide(fm.multiply(fn));
        return divide.intValue();
    }

    //Runtime: 5 ms, faster than 5.05% of Java online submissions for Unique Paths.
    //Memory Usage: 41.2 MB, less than 33.02% of Java online submissions for Unique Paths.
    private void factorial(int m, int n) {
        BigInteger temp = BigInteger.ONE;
        for (int i = 2; i <= m + n - 2; i++) {
            temp = temp.multiply(new BigInteger(String.valueOf(i)));
            if (i == m - 1) fm = temp;
            if (i == n - 1) fn = temp;
        }
        ft = temp;
    }

    // Пересчет в лоб
    //Runtime: 1 ms, faster than 53.06% of Java online submissions for Unique Paths.
    //Memory Usage: 41.4 MB, less than 17.12% of Java online submissions for Unique Paths
    //
    // очень удивлен такому времени!!!
    private int calculate(int m, int n) {
        int[][] buff = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) buff[i][j] = 1;
                else buff[i][j] = buff[i - 1][j] + buff[i][j - 1];
            }
        }
        return buff[m - 1][n - 1];
    }

}
