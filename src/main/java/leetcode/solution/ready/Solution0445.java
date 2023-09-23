package leetcode.solution.ready;

import leetcode.utils.AppUtils;
import leetcode.utils.ListNode;

/*
ListNode
https://leetcode.com/problems/add-two-numbers-ii/description/

Сложение двух чисел, представленных связным списком.
Решение без реверсирования списка.

 */
public class Solution0445 {

    static ListNode over;
    static ListNode res;


    //Runtime 2ms, Beats 61.91%of users with Java
    //Memory 43.85MB, Beats 20.27%of users with Java
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        var p1 = l1;
        var p2 = l2;

        // Ищем какой список закончится первый
        while (p1.next != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // Устанавливаем первым список, который еще не кончился
        // И устанавливаем в его начало дополнительный указатель
        ListNode p0;
        if (p1.next == null && p2.next != null) {
            p1 = p2;
            p2 = l1;
            p0 = l2;
        } else {
            p0 = l1;
            p2 = l2;
        }

        // Доходим остаток списка до конца, одновременно сдвигая дополнительный указатель
        // Сразу начинаем заполнять лист переполнения и лист результата
        over = new ListNode(0);
        var po = over;
        res = new ListNode(0);
        var pr = res;
        while (p1.next != null) {
            pr.next = new ListNode(p0.val);
            pr = pr.next;
            p1 = p1.next;
            p0 = p0.next;
            po.next = new ListNode(0);
            po = po.next;
        }
        p1 = p0;
        while (p1 != null && p2 != null) {
            int val = p1.val + p2.val;
            pr.next = new ListNode(val % 10);
            po.next = new ListNode(val / 10);
            p1 = p1.next;
            p2 = p2.next;
            pr = pr.next;
            po = po.next;
        }

        addOver();

        return res.val == 0 ? res.next : res;
    }

    // Добавляем сдвиги пока список сдвигов не будет состоять только из нулей
    private static void addOver() {
        over = over.next;
        ListNode po = over;
        ListNode pr = res;
        boolean hasOver;
        do {
            hasOver = false;
            while (po != null && pr != null) {
                int val = pr.val + po.val;
                pr.val = val % 10;
                po.val = val / 10;
                if (!hasOver) hasOver = po.val == 1;
                po = po.next;
                pr = pr.next;
            }
            if (hasOver) {
                over = over.next;
                po = over;
                pr = res;
            }
        } while (hasOver);
    }


    public static void main(String[] args) {

        //99_456
        ListNode n1 = new ListNode(9, new ListNode(9, new ListNode(4, new ListNode(5, new ListNode(6)))));
        //987
        ListNode n2 = new ListNode(9, new ListNode(8, new ListNode(7)));
        //100_449
        ListNode expected = new ListNode(1, new ListNode(0, new ListNode(0, new ListNode(4, new ListNode(4, new ListNode(3))))));
        ListNode actual = addTwoNumbers(n1, n2);
        print(expected, actual);

        n1 = new ListNode(0);
        n2 = new ListNode(0);
        expected = new ListNode(0);
        actual = addTwoNumbers(n1, n2);
        print(expected, actual);

        n1 = new ListNode(1);
        n2 = new ListNode(2);
        expected = new ListNode(3);
        actual = addTwoNumbers(n1, n2);
        print(expected, actual);

        n1 = new ListNode(7);
        n2 = new ListNode(7);
        expected = new ListNode(1, new ListNode(4));
        actual = addTwoNumbers(n1, n2);
        print(expected, actual);

        n1 = new ListNode(9, new ListNode(0));
        n2 = new ListNode(9, new ListNode(0));
        expected = new ListNode(1, new ListNode(8, new ListNode(0)));
        actual = addTwoNumbers(n1, n2);
        print(expected, actual);

    }

    private static void print(ListNode expected, ListNode actual) {
        System.out.println("RESULT");
        AppUtils.printNodeList(expected);
        AppUtils.printNodeList(actual);
        System.out.println();
    }

}
