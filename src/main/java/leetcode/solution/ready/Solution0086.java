package leetcode.solution.ready;

import leetcode.solution.ListNode;

//
// ListNode
// Сортировка односвязного списка на больше/меньше
//
public class Solution0086 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
    //Memory Usage: 41.7 MB, less than 90.59% of Java online submissions for Partition List.
    public leetcode.solution.ListNode partition(leetcode.solution.ListNode head, int x) {
        leetcode.solution.ListNode node = head;
        leetcode.solution.ListNode prevLowest = new leetcode.solution.ListNode();
        head = prevLowest;
        leetcode.solution.ListNode prevGreater = new leetcode.solution.ListNode();
        leetcode.solution.ListNode greatHead = prevGreater;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = null;
            if (node.val < x) {
                prevLowest.next = node;
                prevLowest = prevLowest.next;
            } else {
                prevGreater.next = node;
                prevGreater = prevGreater.next;
            }
            node = next;
        }
        prevLowest.next = greatHead.next;
        return head.next;
    }

}
