package leetcode.solution.ready;

import java.util.Arrays;

//
// Комбинаторика. Сочетания
// Количество возможных вариантов получить целевое число из чисел массива
// https://leetcode.com/problems/combination-sum-iv/
//
// Рекурсия - Time Limit Exceeded
// Кеширование результатов вычисления в рекурсии, тоже Time Limit Exceeded
// Третий вариант: считать с 0 до требуемого значения
public class Solution0377 {

    // Подход снизу вверх:
    // Если вычитать target из каждого числа, и посмотреть какое кол-во вариантов есть получить это число,
    // а затем получить сумму всех этих вариантов.
    int[] cache;

    public int combinationSum4(int[] nums, int target) {
        cache = new int[target + 1];
        cache[0] = 1;
        for (int i = 0; i < target + 1; i++) {
            for (int num : nums) {
                if (i - num >= 0) cache[i] += cache[i - num];
            }
        }
        return cache[target];
    }

}

// Time Limit Exceeded
class Solution0377cache {

    int[] cache;

    public int combinationSum4(int[] nums, int target) {
        cache = new int[target];
        return calculate(nums, target);
    }

    private int calculate(int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (cache[target - 1] > 0) return cache[target - 1];
        int sum = 0;
        for (int num : nums) {
            sum += calculate(nums, target - num);
        }
        cache[target - 1] = sum;
        return sum;
    }

}

// Time Limit Exceeded
class Solution0377recursive {

    private int count = 0;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        calculate(nums, target);
        return count;
    }

    // Time Limit Exceeded
    private void calculate(int[] nums, int target) {
        if (target < 0) return;
        if (target == 0) {
            count++;
            return;
        }
        for (int num : nums) {
            calculate(nums, target - num);
        }
    }

}
