package leetcode.solution.ready;

import leetcode.utils.ListNode;

//
// ListNode
// Удаление среднего элемента LinkedList'а
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
//
// Первая часть решения (поиск середины) - Solution0876
public class Solution2095 {

    //Runtime: 6 ms, faster than 65.81% of Java online submissions for Delete the Middle Node of a Linked List.
    //Memory Usage: 202.7 MB, less than 83.35% of Java online submissions for Delete the Middle Node of a Linked List.
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode slowPinter = head;
        ListNode fastPointer = head;
        ListNode prev = head;
        while (fastPointer != null && fastPointer.next != null) {
            prev = slowPinter;
            slowPinter = slowPinter.next;
            fastPointer = fastPointer.next.next;
        }
        prev.next = slowPinter.next;
        return head;
    }

}
