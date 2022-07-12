package leetcode.solution.ready;

import java.util.Arrays;

//
// Проверка можно ли из спичек разной длинны сложить квадрат
//
// Ход мыслей
// Длина > 4, если сумма длин не делится на 4 без остатка - нельзя (возможно проверка и вычисление избыточны)
// а нет мы можем посчитать длину стороны!!!
// т.к. 1 <= matchsticks.length <= 15 можно думать о рекурсии
// Надо как-то набирать длину стороны, сначала думал передавать 4 параметра, но получилось громоздко и некрасиво
// Т.к. в задаче квадрат, то можно сразу создать массив длинной 4 и его таскать за собой
// Сначала хотел "наполнять", но потом понравилась идея выставить лимит = длине стороны и из него вычитать,
// что бы в конце в массиве получились красивые нолики.
// Сортировка, что бы начинать с больших - думается что так будет быстрее.
// И сам процесс:
// Заканчиваем если взяли все палки и "закрыли" все стороны.
// Берем палку, кладем, если влазит, берем следующую...
// Если не влазит, идем на другую сторону (в цикле), и делаем строку выше.
// Если никуда не влезло = "это фиаско брат!"
public class Solution0473 {

    //Runtime: 123 ms, faster than 61.01% of Java online submissions for Matchsticks to Square.
    //Memory Usage: 40.1 MB, less than 91.45% of Java online submissions for Matchsticks to Square.
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        int sum = 0;
        for (int num : matchsticks) sum += num;
        if (sum % 4 != 0) return false;
        int side = sum / 4;
        int[] sideBuff = new int[]{side, side, side, side};
        Arrays.sort(matchsticks);
        return foo(matchsticks, sideBuff, matchsticks.length - 1);
    }

    private boolean foo(int[] nums, int[] sideBuff, int p) {
        if (p == -1) return (sideBuff[0] == 0 && sideBuff[1] == 0 && sideBuff[2] == 0 && sideBuff[3] == 0);
        for (int i = 0; i < sideBuff.length; i++) {
            if (nums[p] > sideBuff[i]) continue;
            sideBuff[i] -= nums[p];
            if (foo(nums, sideBuff, p - 1)) return true;
            sideBuff[i] += nums[p];
        }
        return false;
    }

}
