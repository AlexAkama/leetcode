package leetcode.solution;

//
// HARD
// Рейтинг конфеток
//
// Runtime: 1241 ms, faster than 5.02% of Java online submissions for Candy.
// Memory Usage: 52.3 MB, less than 20.56% of Java online submissions for Candy.
public class Solution0135 {

    public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        int[] candies = new int[ratings.length];
        int cur = 1;
        candies[0] = cur;
        for (int i = 1; i < ratings.length; i++) {
            int d = Integer.compare(ratings[i], ratings[i - 1]);
            if (d == 0) {
                candies[i] = cur = 1;
                continue;
            }
            if (d == 1) {
                candies[i] = ++cur;
            } else {
                cur = 1;
                candies[i] = cur;
                int j = i;
                while (--j > -1 && Integer.compare(ratings[j], ratings[j + 1]) == 1) {
                    if (candies[j + 1] == candies[j]) candies[j]++;
                }
            }
        }
        cur = 0;
        for (int e : candies) {
            cur += e;
        }
        return cur;
    }

}
