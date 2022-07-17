package leetcode.solution.ready;

//
// Перевод числа в двоичную систему
// И возврат бит в обратном порядке
//
// + Получение десятичного числа из бинарной строки
//
// Можно для ускорения процесса использовать побитовые операции
public class Solution190 {

    //Runtime: 4 ms, faster than 5.84% of Java online submissions for Reverse Bits.
    //Memory Usage: 43.2 MB, less than 7.10% of Java online submissions for Reverse Bits.
    public int reverseBits(int n) {
        String in = Integer.toBinaryString(n);
        if (in.length() < 32) in = "0".repeat(32 - in.length()) + in;
        StringBuilder sb = new StringBuilder(in);
        sb.reverse();
        return (int) Long.parseLong(sb.toString(), 2);
    }

    //Runtime: 1 ms, faster than 98.63% of Java online submissions for Reverse Bits.
    //Memory Usage: 42.4 MB, less than 53.62% of Java online submissions for Reverse Bits.
    public int reverseBits2(int n) {
        int res = 0;
        int i = 32;
        while (i != 0) {
            int last = n & 1;
            n = n >> 1;
            res = res << 1;
            res += last;
            i--;
        }
        return res;
    }

}
