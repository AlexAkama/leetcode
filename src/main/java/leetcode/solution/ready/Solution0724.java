package leetcode.solution.ready;

//
// Определение опорного индекса массива
// Опорный индекс — это индекс, в котором сумма всех чисел строго слева от индекса равна сумме всех чисел строго справа от индекса.
//
// Ход мыслей
// Первое пройтись по массиву и посчитать левую и правую сумму, но это получается O(n²)
// Второе искать алгоритм...
// Суммируем слева на право нарастающим итогом, сохраняем в исходный массив, а потом проходимся вычисляем
// сумму слева и сумму справа за одно действие и сравниваем, т.о. избавляемся от пересчета.
public class Solution0724 {

    //Runtime: 3 ms, faster than 35.69% of Java online submissions for Find Pivot Index.
    //Memory Usage: 53.4 MB, less than 24.57% of Java online submissions for Find Pivot Index.
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;
        for (int i = 1; i < nums.length; i++) nums[i] = nums[i] + nums[i - 1];
        int sum = nums[nums.length - 1];
        if (sum - nums[0] == 0) return 0;
        for (int i = 1; i < nums.length; i++) {
            if (sum - nums[i] == nums[i - 1]) return i;
        }
        return -1;
    }

}
