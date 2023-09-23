package interview.array;

//
// Дан массив [4, 1, 2, 3, 5, 1, 2, 3, 4]
// Найти число у которого нет пары
// Используем XOR (^)
// Пример 1 ^ 1 = 0
// Т.е. если xor-ить последовательно с результатом получим число у которого нет пары
//
public class Array001 {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 3, 5, 1, 2, 3, 4};
        int res = 0;
        for (int num : nums) res ^= num;
        System.out.println(res);
    }

}
