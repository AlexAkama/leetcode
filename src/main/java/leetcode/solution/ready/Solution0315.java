package leetcode.solution.ready;

import leetcode.utils.AppUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//
// Найти кол-во элементов справа, которые меньше чем сам элемент
// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
//
// + Сортировка мапы по значению
// + Set to Array
// + Сортировка слиянием
//
// Что такое сортировка слиянием
// https://youtu.be/a5T1ARmL7IY
//
// Еще круче через дерево отрезков!
// Основная мысль: создать массив в котором мы будем записывать кол-во чисел (т.е. число это индекс).
// И кол-во чисел меньше чем это в каждый момент будет равно сумме от первого элемента до текущего.
// И что бы каждый раз быстро считать это кол-во мы используем дерево отрезков.
// Т.е. создаем массив кол-во элементов * 2, где первая половина будет использована по вычисление кол-ва элементов
// А вторая непосредственно для подсчета чисел.
//
public class Solution0315 {

    public List<Integer> countSmaller(int[] nums) {
        SegmentTree segmentTree = new SegmentTree();
        return segmentTree.countSmaller(nums);
    }

    class SegmentTree {


        // Смещение до нуля
        private static final int ZERO_OFFSET = 30_001;
        private static final int FIRST_NUM = -10_000;


        // Потому что у нас диапазон от -10^4 до 10^4 (+ноль) итого 20_001 элементов,
        // а для дерева надо N * 2, где N это кол-во элементов
        private final int[] tree = new int[40_002];

        public List<Integer> countSmaller(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                res[i] = calculate(FIRST_NUM, nums[i] - 1);
                add(nums[i]);
            }
            List<Integer> resList = new ArrayList<>(nums.length);
            for (int i : res) resList.add(i);
            return resList;
        }

        // Добавление i-го элемента
        private void add(int num) {
            num += ZERO_OFFSET;
            tree[num] += 1;
            for (int i = num / 2; i != 0; i /= 2) {
                tree[i] += 1;
            }
        }

        // Вычисление суммы между числами
        private int calculate(int left, int right) {
            left += ZERO_OFFSET;
            right += ZERO_OFFSET;

            int sum = 0;
            while (left <= right) {
                if (left % 2 == 1) {
                    sum += tree[left];
                    left += 1;
                }
                if (right % 2 == 0) {
                    sum += tree[right];
                    right -= 1;
                }
                left /= 2;
                right /= 2;
            }
            return sum;
        }

    }

    class MergeAndCount {

        // МАГИЯ: Сортировка слиянием.
        // Сортируем по порядку и считаем сколько раз число было смещено вправо
        //Runtime: 122 ms, faster than 77.42% of Java online submissions for Count of Smaller Numbers After Self.
        //Memory Usage: 137.4 MB, less than 42.49% of Java online submissions for Count of Smaller Numbers After Self.

        int[] ints;
        int[] count;
        int[] index;

        public List<Integer> countSmaller(int[] nums) {
            ints = nums;
            int len = nums.length;
            count = new int[len];
            index = new int[len];
            for (int i = 0; i < len; i++) index[i] = i;
            sortAndCount(0, len - 1);
            List<Integer> res = new ArrayList<>(len);
            for (int i = 0; i < len; i++) res.add(count[i]);
            return res;
        }

        private void sortAndCount(int left, int right) {
            if (left < right) {
                int middle = left + (right - left) / 2;
                sortAndCount(left, middle);
                sortAndCount(middle + 1, right);
                merge(left, middle, right);
            }
        }

        //     Сортировка слиянием
        private void merge(int left, int middle, int right) {
            int leftSize = middle - left + 1;
            int rightSize = right - middle;
            int[] leftIndex = new int[leftSize];
            int[] rightIndex = new int[rightSize];
            System.arraycopy(index, left, leftIndex, 0, leftSize);
            System.arraycopy(index, middle + 1, rightIndex, 0, rightSize);
            int leftPointer = 0;
            int rightPointer = 0;
            int pos = left;
            int rightCount = 0;
            while (leftPointer < leftSize && rightPointer < rightSize) {
                if (ints[leftIndex[leftPointer]] <= ints[rightIndex[rightPointer]]) {
                    index[pos++] = leftIndex[leftPointer];
                    count[leftIndex[leftPointer++]] += rightCount;
                } else {
                    index[pos++] = rightIndex[rightPointer++];
                    rightCount++;
                }
            }
            if (leftPointer < leftSize) {
                index[pos] = leftIndex[leftPointer];
                count[leftIndex[leftPointer]] += rightCount;
            }
            if (rightPointer < rightSize) {
                index[pos] = rightIndex[rightPointer];
            }

        }

    }

    class BadVariants {

        // ---------- ВАРИАНТ 3 ---------
        // С классом CountNode

        // Time Limit Exceeded
        public List<Integer> countSmaller4(int[] nums) {
            List<Integer> res = new LinkedList<>();
            CountTreeNode root = new CountTreeNode(nums[nums.length - 1]);
            for (int i = nums.length - 1; i > -1; i--) {
                res.add(0, addNode(root, nums[i]));
            }
            return res;
        }

        private int addNode(CountTreeNode root, int val) {
            CountTreeNode node = root;
            int sum = 0;
            while (node.val != val) {
                if (val < node.val) {
                    if (node.left == null) {
                        node.left = new CountTreeNode(val);
                    }
                    node.smallerCount++;
                    node = node.left;
                } else {
                    sum += node.smallerCount + node.count;
                    if (node.right == null) {
                        node.right = new CountTreeNode(val);
                    }
                    node = node.right;
                }
            }
            node.count++;
            return sum + node.smallerCount;
        }

        private class CountTreeNode {

            int val;
            int smallerCount = 0;
            int count = 0;
            CountTreeNode left;
            CountTreeNode right;

            public CountTreeNode(int val) {
                this.val = val;
            }

        }

        // ---------- ВАРИАНТ 3 ---------
        // С классом CountNode

        private CountNode last;
        private CountNode head;

        // Валимся на тесте который невозможно проверить руками
        public List<Integer> countSmaller3(int[] nums) {
            List<Integer> res = new LinkedList<>();
            res.add(0);
            if (nums.length == 1) return res;
            head = new CountNode(nums[nums.length - 1]);
            last = head;
            for (int i = nums.length - 2; i > -1; i--) {
                int count = foo(nums[i]);
                res.add(0, count);
            }
            return res;
        }

        private int foo(int val) {
            if (val < head.val) {
                CountNode node = new CountNode(val);
                node.next = head;
                head = node;
                last = node;
                return node.rights;
            }
            if (val == last.val) {
                last.count++;
                return last.rights;
            }
            if (val < last.val) last = head;
            while (last.next != null && last.next.val < val) {
                last.next.rights = last.count + last.rights;
                last = last.next;
            }
            CountNode next = last.next;
            CountNode node = new CountNode(val);
            node.rights = last.count + last.rights;
            last.next = node;
            node.next = next;
            return node.rights;
        }

        static class CountNode {

            CountNode next;
            int val;
            int count = 1;
            int rights = 0;

            public CountNode(int val) {
                this.val = val;
            }

        }

        // --------- ВАРИАНТ 2 ---------

        // Time Limit Exceeded
        public List<Integer> countSmaller2(int[] nums) {
            int len = nums.length;
            int[] res = new int[len];
            Map<Integer, Integer> posMap = new HashMap<>();
            for (int i = 0; i < len; i++) posMap.put(i, nums[i]);
            posMap = posMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {
                throw new AssertionError();
            }, LinkedHashMap::new));
            Integer[] pos = posMap.keySet().toArray(new Integer[0]);
            for (int i = 1; i < len; i++) {
                int count = 0;
                int temp = pos[i];
                int p = i - 1;
                while (p > -1 && pos[p + 1] < pos[p]) {
                    temp = pos[p + 1];
                    pos[p + 1] = pos[p];
                    pos[p--] = temp;
                    count++;
                }
                res[temp] = count;
            }
            List<Integer> list = new ArrayList<>(len);
            for (int i : res) list.add(i);
            return list;
        }

        // --------- ВАРИАНТ 1 ---------

        // Time Limit Exceeded
        public List<Integer> countSmaller1(int[] nums) {
            int len = nums.length;
            int[] buff = new int[len];
            TreeMap<Integer, Integer> cache = new TreeMap<>();
            for (int i = len - 1; i > -1; i--) {
                int cur = nums[i];
                if (cache.containsKey(cur)) {
                    cache.put(cur, cache.get(cur) + 1);
                } else {
                    cache.put(cur, 1);
                }
                Map<Integer, Integer> lower = cache.headMap(cur);
                int sum = 0;
                for (int j : lower.values()) sum += j;
                buff[i] = sum;
            }
            List<Integer> list = new ArrayList<>(len);
            for (int i : buff) list.add(i);
            return list;
        }

    }

}


