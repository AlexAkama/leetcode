package leetcode.solution.ready;

//
// Зеркальная комната, квадратная
// В какой отражатель попадет луч
// https://leetcode.com/problems/mirror-reflection/
//
public class Solution0858 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Mirror Reflection.
    //Memory Usage: 41.4 MB, less than 18.06% of Java online submissions for Mirror Reflection.
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }

//        if (p % 2 != 0 && q % 2 != 0) return 1;
//        if (p % 2 != 0 && q % 2 == 0) return 0;
//        if (p % 2 == 0 && q % 2 != 0) return 2;
//        return -1;

        if (p % 2 != 0 && q % 2 != 0) return 1;
        if (p % 2 != 0) return 0;
        return 2;
    }

}
