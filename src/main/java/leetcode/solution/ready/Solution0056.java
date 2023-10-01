package leetcode.solution.ready;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Интервалы
Слить(объединить) интервалы

Эмпирически: входные данные не отсортированы

https://leetcode.com/problems/merge-intervals/
 */
public class Solution0056 {

    public int[][] mergeV5(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) merged.add(interval);
            else merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    //Runtime 10ms, Beats 28.58%of users with Java
    //Memory
    //Details
    //45.29MB
    //Beats 77.14%of users with Java
    public int[][] mergeV4(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (interval[0] <= end) end = Math.max(end, interval[1]);
            else {
                merged.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);
    }

    //Runtime 9ms, Beats 56.37%of users with Java
    //Memory 45.66MB, Beats 33.99%of users with Java
    //
    // По времени вроде норм, но RED MEMORY
    public int[][] mergeV3(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] <= end) end = Math.max(end, interval[1]);
            else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    //Runtime 10msm, Beats 28.58%of users with Java
    //Memory 45.56MB, Beats 43.47%of users with Java
    //
    // RED TIME, RED MEMORY
    public int[][] mergeV2(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        List<Interval> list = new ArrayList<>(intervals.length);
        for (int[] intervalInts : intervals) {
            list.add(new Interval(intervalInts));
        }
        list.sort(Interval::compareTo);
        int start = list.get(0).start;
        int end = list.get(0).end;
        List<int[]> listRes = new ArrayList<>();
        for (Interval interval : list) {
            if (interval.start <= end) end = Math.max(end, interval.end);
            else {
                listRes.add(new int[]{start, end});
                start = interval.start;
                end = interval.end;
            }
        }
        listRes.add(new int[]{start, end});
        int[][] res = new int[listRes.size()][2];
        for (int i = 0; i < listRes.size(); i++) {
            res[i] = listRes.get(i);
        }
        return res;
    }

    //Wrong Answer
    // входные данные не отсортированы!!!
    public int[][] mergeV1(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] <= end) end = Math.max(end, interval[1]);
            else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[][] mergeV0(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        int min = 10_001;
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> operation = new HashMap<>();
        List<Integer> toDelete = new ArrayList<>();
        operation.put(intervals[0][0], intervals[0][1]);
        for (int[] interval : intervals) {
            if (interval[1] < min) {
                map.put(interval[0], interval[1]);
                min = interval[0];
            }
            if (interval[0] > max) {
                map.put(interval[0], interval[1]);
                max = interval[1];
            }
            for (Integer i0 : map.keySet()) {
                int i1 = map.get(i0);
                if (interval[0] <= i0 && i1 <= interval[1]) {
                    if (interval[0] == i0 && i1 == interval[1]) operation = new HashMap<>();
                    operation.put(interval[0], interval[1]);
                } else if (interval[0] < i0 && interval[1] >= i0 && interval[1] < i1) {
                    operation.put(i0, -1);
                    operation.put(interval[0], i1);
                } else if (i0 < interval[0] && i1 >= interval[0] && i1 < interval[1]) {
                    operation.put(interval[0], -1);
                    operation.put(i0, interval[1]);
                }
            }
        }
        for (Integer key : operation.keySet()) if (operation.get(key) == -1) toDelete.add(key);
        for (Integer key : toDelete) operation.remove(key);
        int[][] res = new int[operation.size()][2];
        int count = 0;
        for (Integer key : operation.keySet()) {
            res[count][0] = key;
            res[count++][1] = operation.get(key);
        }
        return res;
    }

    // Нужно подумать как убрать дубли в результате
    public int[][] mergeUseArray(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int[] applicant : intervals) {
            boolean isNotMerged = true;
            for (int[] interval : list) {
                if (!isNotCrossed(interval, applicant)) {
                    interval[0] = Math.min(interval[0], applicant[0]);
                    interval[1] = Math.max(interval[1], applicant[1]);
                    isNotMerged = false;
                }
            }
            if (isNotMerged) list.add(applicant);
        }
        int[][] res = new int[list.size()][2];
        int count = 0;
        for (int[] ints : list) res[count++] = ints;
        return res;
    }

    private boolean isNotCrossed(int[] left, int[] right) {
        return left[1] < right[0] || right[1] < left[0];
    }


    //Вариант с классом Interval
    //Runtime 2760 ms. Beats 5.11% - жуть какая-то, видимо время на создание объектов
    //Memory 45.2 MB. Beats 99.71%
    public int[][] mergeUseInnerClass(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Set<Interval> set = new HashSet<>();
        Interval first = new Interval(intervals[0]);
        set.add(first);
        for (int[] data : intervals) {
            Interval applicant = new Interval(data);
            List<Interval> toUpdate = new ArrayList<>();
            List<Interval> toDelete = new ArrayList<>();
            for (Interval interval : set) {
                if (!isNotCrossed(interval, applicant)) {
                    toDelete.add(interval);
                    applicant.start = Math.min(interval.start, applicant.start);
                    applicant.end = Math.max(interval.end, applicant.end);
                }
                toUpdate.add(applicant);
            }
            toDelete.forEach(set::remove);
            set.addAll(toUpdate);
        }
        int[][] res = new int[set.size()][2];
        int count = 0;
        for (Interval interval : set) {
            res[count][0] = interval.start;
            res[count++][1] = interval.end;
        }
        return res;
    }

    private boolean isNotCrossed(Interval left, Interval right) {
        return left.end < right.start || right.end < left.start;
    }

    static class Interval implements Comparable<Interval> {

        public int start;
        public int end;

        public Interval(int[] ints) {
            start = ints[0];
            end = ints[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start && end == interval.end;
        }

        @Override
        public int hashCode() {
            return 10_000 * start + end;
        }

        @Override
        public int compareTo(@NotNull Interval o) {
            if (this.start == o.start && this.end == o.end) return 0;
            return Integer.compare(this.start, o.start);
        }

    }

}
