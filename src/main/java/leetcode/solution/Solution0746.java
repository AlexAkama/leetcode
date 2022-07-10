package leetcode.solution;

//
// Подсчет минимальной стоимости подъема по лестнице при известной стоимости ступеньки
//
// Ход мыслейЖ
// 1. Рекурсия при тестах - Time Limit Exceeded
// 2. Считать сразу в массиве нельзя - теряются данные
// 3. Создать второй массив и в нем считать
// 4. Надо считать с хвоста!!!
// 5. Незачем создавать другой массив
//
//Runtime: 2 ms, faster than 32.47% of Java online submissions for Min Cost Climbing Stairs.
//Memory Usage: 43.8 MB, less than 42.84% of Java online submissions for Min Cost Climbing Stairs.
public class Solution0746 {

    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 1 - 2; i > -1; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }

}