package leetcode.solution;

//
// Нахождение середины односвязанного списка
// Алгоритм "Черепаха и Заяц"
//
public class Solution0876 {
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
