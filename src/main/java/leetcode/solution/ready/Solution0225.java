package leetcode.solution.ready;

import java.util.LinkedList;
import java.util.Queue;

//
// Реализация стека
// https://leetcode.com/problems/implement-stack-using-queues/
//
// Первое, что пришло в голову, не есть себе голову и сделать на LinkedList
// Но по условию надо использовать две очереди
public class Solution0225 {

    Queue<Integer> basket1;
    Queue<Integer> basket2;

    //Runtime: 1 ms, faster than 32.05% of Java online submissions for Implement Stack using Queues.
    //Memory Usage: 41.8 MB, less than 46.61% of Java online submissions for Implement Stack using Queues.
    public Solution0225() {
        basket1 = new LinkedList<>();
        basket2 = new LinkedList<>();
    }

    public void push(int x) {
        if (basket1.isEmpty()) {
            basket1.offer(x);
            int size = basket2.size();
            for (int i = 0; i < size; i++) {
                basket1.offer(basket2.poll());
            }
        } else {
            basket2.offer(x);
            int size = basket1.size();
            for (int i = 0; i < size; i++) {
                basket2.offer(basket1.poll());
            }
        }
    }

    public int pop() {
        //NPE не обработано т.к. данные валидны по условию
        return (basket1.isEmpty()) ? basket2.poll() : basket1.poll();
    }

    public int top() {
        //NPE не обработано т.к. данные валидны по условию
        return (basket1.isEmpty()) ? basket2.peek() : basket1.peek();
    }

    public boolean empty() {
        return basket1.isEmpty() && basket2.isEmpty();
    }

}


class Solution0225v1 {

    private final LinkedList<Integer> list;

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
    //Memory Usage: 40.2 MB, less than 90.11% of Java online submissions for Implement Stack using Queues.
    public Solution0225v1() {
        list = new LinkedList<>();
    }

    public void push(int x) {
        list.addFirst(x);
    }

    public int pop() {
        return list.removeFirst();
    }

    public int top() {
        return list.getFirst();
    }

    public boolean empty() {
        return list.isEmpty();
    }

}
