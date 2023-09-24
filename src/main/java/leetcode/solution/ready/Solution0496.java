package leetcode.solution.ready;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Основная мысль:
Посчитать для каждого элемента его первый больший справа.
Кажется избыточным, но, а как по другому?
Сохраняем в мапу, а потом, проходя по целевым значениям, просто берем из мапы значение.

Построение мапы:
Проходим массив со значениями в обратном порядке.
Если в стеке есть элементы и вершина больше чем текущий элемент,
то записываем в мапу для него вершину стека.
Если текущий элемент больше чем вершина, выкидываем из стека все значения меньше него.
Если опустошили весь стек, т.е. текущий больше чем все справа - пишем в мапу -1.

Получение следующего большего элемента
https://leetcode.com/problems/next-greater-element-i/
 */
public class Solution0496 {

    //Runtime 3ms, Beats 89.94%of users with Java
    //Memory 43.66MB, Beats 31.84%of users with Java
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 1) return new int[]{-1};
        Deque<Integer> stack = new ArrayDeque<>(nums2.length);
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n2 = new int[]{3, 1, 4, 5, 9, 2, 6};
        int[] n1 = new int[]{4, 1, 2};
        nextGreaterElement(n1, n2);
    }

}
