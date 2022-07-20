package leetcode.solution.ready;

//
// Является ли число степенью двойки
// Побитовые операции. Классически вариант n&(n-1)=0
//
// Как это работает:
// n      : xxxxxx1000
// 1      : 0000000001
// n - 1  : xxxxxx0111
// n&(n-1): xxxxxx0000
// Это число будет равно нулю тогда и только когда, когда все xxxxxx равны нулю.
// Единственный случай, где наше соображение не проходит — число 0: там нет «самой правой» единицы вовсе,
// так что это случай приходится рассматривать отдельно.
public class Solution0231 {

    //Runtime: 2 ms, faster than 68.06% of Java online submissions for Power of Two.
    //Memory Usage: 41.3 MB, less than 47.82% of Java online submissions for Power of Two.
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
