package leetcode.solution.ready;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
Сортируем
Строим префиксные суммы
Потом загоняем это TreeMap префикс:позиция+1 (т.е. сколько ячеек использовано, что бы получить эту сумму)

ВАЖНО!!! Именно TreeMap из-за метода floorEntry
(https://metanit.com/java/tutorial/5.9.php)

Потом берем целевое значение и тащим из мапы ближайшее значение по ключу снизу
И таким образом получаем, что бы создать получить число не больше целевого значения нам надо использовать
то количество элементов которое для создания ключа, он же префикс

https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
 */
public class Solution2389 {

    public static void main(String[] args) {
        answerQueries(new int[]{4, 5, 2, 1}, new int[]{10, 21, 3});
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(prefix[0], 1);
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            map.put(prefix[i], i + 1);
        }
        int[] ans = new int[queries.length];
        int pos = 0;
        for (int query : queries) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(query);
            ans[pos++] = entry.getValue();
        }

        return ans;
    }

}
