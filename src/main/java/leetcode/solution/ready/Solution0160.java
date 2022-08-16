package leetcode.solution.ready;

import leetcode.utils.ListNode;

//
// TreeNode
// Определить пресекаются ли два односвязных списка, если да то вернуть узел пересечения
//
// Проходим оба списка до конца, если последний одинаковый, то пересекаются.
// Если пересекаются зацикливаем на одну из голов, и со второй ищем пересечение (Заяц и Черепаха)
public class Solution0160 {

    //Runtime: 2 ms, faster than 56.17% of Java online submissions for Intersection of Two Linked Lists.
    //Memory Usage: 56 MB, less than 9.57% of Java online submissions for Intersection of Two Linked Lists.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1.next != null || p2.next != null) {
            if (p1.next != null) p1 = p1.next;
            if (p2.next != null) p2 = p2.next;
        }
        if (p1 != p2) return null;
        ListNode last = p1;
        last.next = headB;
        p1 = headA;
        p2 = headA;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                ListNode circleHead = headA;
                while (p1 != circleHead) {
                    p1 = p1.next;
                    circleHead = circleHead.next;
                }
                last.next = null;
                return circleHead;
            }
        }
        return null;
    }

}
