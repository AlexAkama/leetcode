package leetcode.solution.ready;

import leetcode.utils.ListNode;

//
// ListNode
// Удаление ноды, но есть только ссылка на нее, т.е. на голову ссылки нет
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
//Memory Usage: 41.8 MB, less than 89.78% of Java online submissions for Delete Node in a Linked List.
public class Solution0237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
