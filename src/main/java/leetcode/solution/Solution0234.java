package leetcode.solution;

//
// Список полиндром
//
public class Solution0234 {

    public boolean isPalindrome(ListNode head) {
        ListNode slowPinter = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPinter = slowPinter.next;
            fastPointer = fastPointer.next.next;
        }
        ListNode temp;
        ListNode reversHead = null;
        while (slowPinter != null) {
            temp = slowPinter.next;
            slowPinter.next = reversHead;
            reversHead = slowPinter;
            slowPinter = temp;
        }
        while (reversHead != null) {
            if (reversHead.val != head.val) {
                return false;
            }
            reversHead = reversHead.next;
            head = head.next;
        }
        return true;
    }

}

