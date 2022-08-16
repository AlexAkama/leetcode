package leetcode.solution.ready;

import leetcode.utils.ListNode;

//
// ListNode
// Слияние двух сортированных односвязных листов
//
public class Solution0021 {

    //Runtime: 1 ms, faster than 78.95% of Java online submissions for Merge Two Sorted Lists.
    //Memory Usage: 43.2 MB, less than 42.22% of Java online submissions for Merge Two Sorted Lists.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p = new ListNode();
        ListNode res = p;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;
        return res.next;
    }

}
