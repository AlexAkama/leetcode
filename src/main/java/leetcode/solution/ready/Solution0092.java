package leetcode.solution.ready;

import leetcode.utils.ListNode;

//
// ListNode
// Разворот односвязного списка внутри указанных позиций
//
// Ход мыслей:
// Выделить промежуток, которой надо развернуть
// не забыть определить начало и конец
// Крайние варианты начало первая нода и/или конец последняя
public class Solution0092 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
    //Memory Usage: 41.3 MB, less than 77.99% of Java online submissions for Reverse Linked List II.
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;
        ListNode node = head;
        ListNode start = null;
        ListNode finish = null;
        ListNode prev = null;
        ListNode next = null;
        int pos = 1;
        while (node != null) {
            if (node.next != null && pos + 1 == left) prev = node;
            if (pos == left) start = node;
            if (pos == right && start != null) {
                finish = node;
                next = node.next;
                finish.next = null;
                break;
            }
            node = node.next;
            pos++;
        }
        if (start == null || finish == null) return head;
        start = reverseList(start, next);
        if (prev == null) head = start;
        else prev.next = start;
        return head;
    }

    public ListNode reverseList(ListNode head, ListNode after) {
        if (head == null) return null;
        ListNode prev = after;
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
