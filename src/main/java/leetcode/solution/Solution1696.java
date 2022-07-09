package leetcode.solution;

//
// Вывод максимальной суммы с ограничением шага от текущей позиции
// LinkedList вместо стека
//
// + LinkedList: getFirst(), removeLast()
//
//Runtime: 50 ms, faster than 60.03% of Java online submissions for Jump Game VI.
//Memory Usage: 114.6 MB, less than 30.69% of Java online submissions for Jump Game VI.
import java.util.LinkedList;

public class Solution1696 {

    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> posBuff = new LinkedList<>();
        posBuff.add(0);
        for (int pos = 1; pos < nums.length; pos++) {
            if (posBuff.getFirst() < pos - k) posBuff.removeFirst();
            nums[pos] += nums[posBuff.getFirst()];
            while (!posBuff.isEmpty() && nums[posBuff.getLast()] <= nums[pos]) posBuff.removeLast();
            posBuff.addLast(pos);
        }
        return nums[nums.length - 1];
    }

}
