package leetcode.solution.ready;

/*
https://leetcode.com/problems/perfect-number/

Perfect number (Великолепное число) - число которое равно сумме своих делителей
 */
public class Solution0507 {

    //Runtime 2ms, Beats 81.50%of users with Java
    //Memory 39.34MB, Beats 28.03%of users with Java
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) sum += i + num / i;
        }
        return num == sum;
    }

}
