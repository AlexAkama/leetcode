package leetcode.solution.ready;

//
// NumArray
// Реализация массива с поиском суммы подряд идущих элементов
// https://leetcode.com/problems/range-sum-query-mutable/
//
// Дерево Фенвика
// https://www.youtube.com/watch?v=muW1tOyqUZ4
//
// f(i) = i & (i + 1) - индекс для суммы
// f(i) = i & (i + 1) - индекс для обновления
//
// BigO              |    Update   |   RangeSum  |
// -----------------------------------------------
// Исходный масcив   |     O(1)    |     O(n)    |
// -----------------------------------------------
// Массив cумм       |     O(n)    |     O(1)    |
// -----------------------------------------------
// Дерево Фенвика    |  O(log(n))  |  O(log(n))  |
// -----------------------------------------------
//
public class Solution0307 {

    private final int[] nums;
    private int[] fenvickTree;

    //Runtime: 94 ms, faster than 92.89% of Java online submissions for Range Sum Query - Mutable.
    //Memory Usage: 136.5 MB, less than 19.49% of Java online submissions for Range Sum Query - Mutable.
    public Solution0307(int[] nums) {
        this.nums = nums;
        fenvickTreeInit(nums);
    }

    public void update(int index, int val) {
        int d = val - nums[index];
        nums[index] = val;
        while (index < fenvickTree.length) {
            fenvickTree[index] += d;
            index = index | (index + 1);
        }
    }

    public int sumRange(int left, int right) {
        return getSum(right) - getSum(left - 1);
    }

    private int getSum(int index) {
        int sum = 0;
        while (index > -1) {
            sum += fenvickTree[index];
            index = (index & index + 1) - 1;
        }
        return sum;
    }

    private void fenvickTreeInit(int[] nums) {
        fenvickTree = new int[nums.length];
        fenvickTree[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int index = i & (i + 1);
            for (int j = index; j < i + 1; j++) fenvickTree[i] += nums[j];
        }
    }

}
