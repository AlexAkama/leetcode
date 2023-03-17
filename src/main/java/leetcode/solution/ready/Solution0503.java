package leetcode.solution.ready;

//
// Перевод числа в семеричную систему
//
public class Solution0503 {

    public static void main(String[] args) {
        Solution0503 solution0503 = new Solution0503();
        solution0503.convertToBase7(7);
    }

    //Runtime 1ms, Beats 83.70%
    //Memory 40.5MB, Beats 30.29%
    public String convertToBase7(int num) {
        int base = 7;
        int n = (num < 0) ? -num : num;
        StringBuilder sb = new StringBuilder();
        while (n >= base) {
            int remains = n % base;
            n = n / base;
            sb.append(remains);
        }
        sb.append(n);
        if (num < 0) sb.append("-");
        return sb.reverse().toString();
    }

}
