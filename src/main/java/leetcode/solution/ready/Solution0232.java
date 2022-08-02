package leetcode.solution.ready;

import java.util.Deque;
import java.util.LinkedList;

//
// Реализация очереди на основе двух стеков
// https://leetcode.com/problems/implement-queue-using-stacks/submissions/
//
public class Solution0232 {

    Deque<Integer> basket1;
    Deque<Integer> basket2;

    // Stack
    //Runtime: 1 ms, faster than 71.05% of Java online submissions for Implement Queue using Stacks.
    //Memory Usage: 41.6 MB, less than 73.27% of Java online submissions for Implement Queue using Stacks.
    //
    // ArrayDeque
    //Runtime: 1 ms, faster than 71.05% of Java online submissions for Implement Queue using Stacks.
    //Memory Usage: 41.5 MB, less than 77.56% of Java online submissions for Implement Queue using Stacks.
    //
    // LinkedList
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
    //Memory Usage: 40.4 MB, less than 85.46% of Java online submissions for Implement Queue using Stacks.
    public Solution0232() {
        basket1 = new LinkedList<>();
        basket2 = new LinkedList<>();
    }

    public void push(int x) {
        while (!basket2.isEmpty()) basket1.push(basket2.pop());
        basket1.push(x);
    }

    public int pop() {
        while (!basket1.isEmpty()) basket2.push(basket1.pop());
        return basket2.pop();
    }

    public int peek() {
        while (!basket1.isEmpty()) basket2.push(basket1.pop());
        //NPE проигнорировано из-за валидности данных теста
        return basket2.peek();
    }

    public boolean empty() {
        return basket1.isEmpty() && basket2.isEmpty();
    }

}
