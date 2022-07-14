package leetcode.solution.ready;

//
// Поиск цикла в односвязном списке
// и возврат узла с которого начинается цикл
//
public class Solution0142 {

    //Runtime: 1 ms, faster than 56.31% of Java online submissions for Linked List Cycle II.
    //Memory Usage: 44.5 MB, less than 81.02% of Java online submissions for Linked List Cycle II.
    //---
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
    //Memory Usage: 45 MB, less than 52.84% of Java online submissions for Linked List Cycle II.
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

}
