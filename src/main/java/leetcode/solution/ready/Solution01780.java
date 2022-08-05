package leetcode.solution.ready;

//
// Число состоит их различных степеней тройки?
// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
//
public class Solution01780 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if Number is a Sum of Powers of Three.
    //Memory Usage: 41 MB, less than 50.82% of Java online submissions for Check if Number is a Sum of Powers of Three.
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }

}
