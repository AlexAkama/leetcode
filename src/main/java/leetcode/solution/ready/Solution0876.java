package leetcode.solution.ready;

import leetcode.utils.ListNode;

//
// ListNode
// Нахождение середины односвязного списка
// Алгоритм "Черепаха и Заяц"
//
public class Solution0876 {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    //Memory Usage: 42.1 MB, less than 18.33% of Java online submissions for Middle of the Linked List.
    public ListNode middleNode(ListNode head) {
        ListNode slowPinter = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPinter = slowPinter.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPinter;
    }

}
