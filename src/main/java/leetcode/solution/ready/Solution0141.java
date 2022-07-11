package leetcode.solution.ready;

//
// Поиск цикла в односвязном списке
// Классический алгоритм заяц и черепаха
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
//Memory Usage: 44 MB, less than 83.87% of Java online submissions for Linked List Cycle.
public class Solution0141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

}
