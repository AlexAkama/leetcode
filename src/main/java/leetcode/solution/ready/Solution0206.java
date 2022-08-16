package leetcode.solution.ready;

import leetcode.utils.ListNode;

//
// ListNode
// Разворот односвязного списка
//
public class Solution0206 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    //Memory Usage: 43.4 MB, less than 16.11% of Java online submissions for Reverse Linked List.
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode node = head;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

}
