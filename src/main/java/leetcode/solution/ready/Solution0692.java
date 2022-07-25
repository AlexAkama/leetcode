package leetcode.solution.ready;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

//
// Вернуть указанное число часто встречающихся слова, отсортированный от большей частоты к меньшей.
// Слова с одинаковой частотностью по их лексикографическому порядку.
// https://leetcode.com/problems/top-k-frequent-words/
//
// + Сортировка мапы в обратном порядке
// + PriorityQueue со своим компаратором
// + poll - получаем с удалением
// + offer
// + Queue size()
public class Solution0692 {

    //Runtime: 19 ms, faster than 5.23% of Java online submissions for Top K Frequent Words.
    //Memory Usage: 45.6 MB, less than 25.58% of Java online submissions for Top K Frequent Words.
    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> buff = new TreeMap<>();
        for (String word : words) {
            if (buff.containsKey(word)) {
                buff.put(word, buff.get(word) + 1);
            } else {
                buff.put(word, 1);
            }
        }
        return buff.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    //Runtime: 9 ms, faster than 68.84% of Java online submissions for Top K Frequent Words.
    //Memory Usage: 45.2 MB, less than 59.99% of Java online submissions for Top K Frequent Words.
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> buff = new HashMap<>();
        for (String word : words) {
            if (buff.containsKey(word)) {
                buff.put(word, buff.get(word) + 1);
            } else {
                buff.put(word, 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> stack = new PriorityQueue<>(
                (o1, o2) -> o1.getValue().intValue() == o2.getValue().intValue()
                        ? o2.getKey().compareTo(o1.getKey())
                        : o1.getValue().compareTo(o2.getValue())
        );
        for (Map.Entry<String, Integer> entry : buff.entrySet()) {
            stack.offer(entry);
            if (stack.size() > k) stack.poll();
        }
        List<String> list = new LinkedList<>();
        for (int i = 0; i < k; i++) list.add(0, stack.poll().getKey());
        return list;
    }

}
