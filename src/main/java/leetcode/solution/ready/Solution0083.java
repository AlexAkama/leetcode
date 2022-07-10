package leetcode.solution.ready;

//
// ListNode
// удаление дубликатов из односвязного списка
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
//Memory Usage: 42.1 MB, less than 84.84% of Java online submissions for Remove Duplicates from Sorted List.
public class Solution0083 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cursor = head;
        while (cursor != null) {
            if (cursor.next != null && cursor.val == cursor.next.val) {
                cursor.next = cursor.next.next;
                continue;
            }
            cursor = cursor.next;
        }
        return head;
    }

}
