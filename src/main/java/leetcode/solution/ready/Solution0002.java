package leetcode.solution.ready;

//
// ListNode
// Сложение двух чисел представленных связным списком
// !!! Числа не отрицательные и хранятся в обратном порядке
//
public class Solution0002 {

    //Runtime: 3 ms, faster than 78.30% of Java online submissions for Add Two Numbers.
    //Memory Usage: 48 MB, less than 39.55% of Java online submissions for Add Two Numbers.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean offset = false;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        ListNode cur;
        while (l1 != null || l2 != null) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;
            int sum = v1 + v2 + (offset ? 1 : 0);
            offset = sum > 9;
            cur = new ListNode(offset ? sum % 10 : sum);
            temp.next = cur;
            temp = cur;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (offset) temp.next = new ListNode(1);
        return res.next;
    }

}
