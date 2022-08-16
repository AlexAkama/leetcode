package leetcode.solution.ready;

import leetcode.utils.ListNode;

//
// ListNode
// Удаление узлов с указанным значением
//
public class Solution0203 {

    //Runtime: 1 ms, faster than 98.99% of Java online submissions for Remove Linked List Elements.
    //Memory Usage: 43.5 MB, less than 84.50% of Java online submissions for Remove Linked List Elements.
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode resHead = new ListNode(0);
        ListNode prev = resHead;
        ListNode node = head;
        while (node != null) {
            if (node.val != val) {
                prev.next = node;
                prev = node;
            } else {
                prev.next = node.next;
            }
            node = node.next;
        }
        return resHead.next;
    }

    //Runtime: 1 ms, faster than 98.99% of Java online submissions for Remove Linked List Elements.
    //Memory Usage: 49.2 MB, less than 34.32% of Java online submissions for Remove Linked List Elements.
    public ListNode removeElements2(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        head = node;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head.next;
    }


}
