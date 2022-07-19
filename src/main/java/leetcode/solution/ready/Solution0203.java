package leetcode.solution.ready;

import leetcode.solution.ListNode;

//
// ListNode
// Удаление узлов с указанным значением
//
public class Solution0203 {

    //Runtime: 1 ms, faster than 98.99% of Java online submissions for Remove Linked List Elements.
    //Memory Usage: 43.5 MB, less than 84.50% of Java online submissions for Remove Linked List Elements.
    public leetcode.solution.ListNode removeElements(leetcode.solution.ListNode head, int val) {
        if (head == null) return null;
        leetcode.solution.ListNode resHead = new leetcode.solution.ListNode(0);
        leetcode.solution.ListNode prev = resHead;
        leetcode.solution.ListNode node = head;
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
    public leetcode.solution.ListNode removeElements2(leetcode.solution.ListNode head, int val) {
        leetcode.solution.ListNode node = new ListNode(0);
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
