package leetcode.solution.ready;

//
// Быстрое деление на 2 (побайтовый сдвиг)
//
public class Solution1342 {

    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 != 0) {
                num--;
            } else {
                num = num >> 1;
            }
            count++;
        }
        return count;
    }

}
