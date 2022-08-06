package leetcode.solution.ready;

//
// Ведра с ядом и свиньи
// https://leetcode.com/problems/poor-pigs/
//
// Хорошее объяснение https://youtu.be/_JcO3fqoG2M
public class Solution0458 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Poor Pigs.
    //Memory Usage: 40.9 MB, less than 58.40% of Java online submissions for Poor Pigs.
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) return 0;
        int res = 1;
        int radix = minutesToTest / minutesToDie + 1;
        if (buckets <= radix) return res;
        int left = radix;
        int right = radix * radix;
        while (true) {
            res++;
            if (buckets > left && buckets < right + 1) return res;
            left = right;
            right *= radix;
        }
    }

}
