package leetcode.solution.ready;

import java.util.Arrays;

//
// Поиск мажоритарного элемента
// По условию он есть всегда!!!
//
// Три варианта (минимум):
// 1. Пройтись в лоб двумя чиклами
// 2. Посчитать в HashMap и сравнить
// 3. Отсортировать - и взять средний
public class Solution0169 {

    //Runtime: 4 ms, faster than 53.53% of Java online submissions for Majority Element.
    //Memory Usage: 57 MB, less than 12.33% of Java online submissions for Majority Element.
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
