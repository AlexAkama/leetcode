package leetcode.solution.ready;

import java.util.HashSet;
import java.util.Set;

//
// Вернуть единственное не парное число
//
// + получение первого элемента set'а set.iterator().next();
public class Solution0136 {

    //Runtime: 14 ms, faster than 28.91% of Java online submissions for Single Number.
    //Memory Usage: 54 MB, less than 17.91% of Java online submissions for Single Number.
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next(); //+
    }

    // Оптимизируем:
    // убираем contains, т.к. он все равно происходит при добавлении элемента,
    // используем возврат инфы при добавлении
    //
    //Runtime: 10 ms, faster than 35.27% of Java online submissions for Single Number.
    //Memory Usage: 42.7 MB, less than 86.86% of Java online submissions for Single Number.
    public int singleNumber2(int[] nums) {
        if (nums.length == 1) return nums[0];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) set.remove(num);
        }
        return set.iterator().next();
    }

    // Очень быстрый способ
    // Побитовые операции
    //
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Single Number.
    //Memory Usage: 41.9 MB, less than 99.78% of Java online submissions for Single Number.
    public int singleNumber3(int[] nums) {
        int res = 0;
        for (int i : nums) res ^= i;
        return res;
    }


}
