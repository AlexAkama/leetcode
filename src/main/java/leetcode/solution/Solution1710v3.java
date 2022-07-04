package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//
// Создание Map.Entry
//
public class Solution1710v3 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<Entry> list = new ArrayList<>();
        for (int[] boxType : boxTypes) {
            list.add(new Entry(boxType[0], boxType[1])); //
        }
        list.sort(Entry::compare);
        int max = 0;
        int pointer = 0;
        int i = truckSize;
        while (i > 0 && pointer < list.size()) {
            Entry entry = list.get(pointer++);
            int val = Math.min(entry.getAmount(), i);
            max += entry.getCapacity() * val;
            i -= val;
        }
        return max;
    }
}

class Entry {

    private final int amount;
    private final int capacity;

    Entry(int amount, int capacity) {
        this.amount = amount;
        this.capacity = capacity;
    }

    int compare(Entry entry) {
        Integer o1 = entry.capacity;
        Integer o2 = this.capacity;
        return o1.compareTo(o2);
    }

    public int getAmount() {
        return amount;
    }

    public int getCapacity() {
        return capacity;
    }

}
