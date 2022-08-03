package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//
// MyCalendar
// https://leetcode.com/problems/my-calendar-i/
//
// Идея:
// Интервалы храним в тримапе, key = start, value = end, получается стразу отсортировано
// при добавлении ищем что start не попадает, если ок, тогда ищем что финиш < начала следующего
// Чет как-то очень медленно получилось.
// Попробую создать класс, и проверять все без сортировки
// С использованием отдельного класса и "сортированной" вставке получилось быстрее
public class Solution0729 {

    private final List<Event> list;
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    public Solution0729() {
        list = new ArrayList<>();
    }


    public boolean book(int start, int end) {
        Event event = new Event(start, end);
        int position = findInsertPosition(event);
        if (position == -1) return false;
        addToPosition(position, event);
        return true;
    }

    private void addToPosition(int position, Event event) {
        list.add(position, event);
        if (event.start < min) min = event.start;
        if (event.finish > max) max = event.finish;
    }

    private int findInsertPosition(Event event) {
        if (list.isEmpty()) return 0;
        if (event.finish < min) return 0;
        if (event.start >= max) return list.size();
        int start = 0;
        int finish = list.size();
        while (start < finish) {
            int middle = (start + finish) / 2;
            if (list.get(middle).finish <= event.start) start = middle + 1;
            else finish = middle;
        }
        if (event.finish > list.get(start).start) return -1;
        return start;
    }

    //Runtime: 30 ms, faster than 75.04% of Java online submissions for My Calendar I.
    //Memory Usage: 53.7 MB, less than 82.72% of Java online submissions for My Calendar I.
    static class Event {

        int start;
        int finish;

        public Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

    }

    static class Solution0729v1 {

        private final Map<Integer, Integer> calendar;

        //Runtime: 312 ms, faster than 6.81% of Java online submissions for My Calendar I.
        //Memory Usage: 54.9 MB, less than 28.22% of Java online submissions for My Calendar I.
        public Solution0729v1() {
            calendar = new TreeMap<>();
        }


        public boolean book(int start, int end) {
            for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
                if (end <= entry.getKey()) break;
                if (start == entry.getKey() || start < entry.getValue()) return false;
            }
            calendar.put(start, end);
            return true;
        }

    }

}
