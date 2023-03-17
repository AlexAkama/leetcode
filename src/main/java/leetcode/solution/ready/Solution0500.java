package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//
// Выбрать слова которы модно напечатать из одной строки клавиатуры
//
// https://leetcode.com/problems/keyboard-row/
public class Solution0500 {

    public static void main(String[] args) {
        Solution0500 sol = new Solution0500();
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] oneRowWords = sol.findWords(words);
        System.out.println(Arrays.toString(oneRowWords));
    }


    //    private Set<Character> first;
    //    private Set<Character> second;
    //    private Set<Character> third;
    private Set<Character> first = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
    private Set<Character> second = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
    private Set<Character> third = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');

    //Runtime 1ms, Beats 59.69%
    //Memory 40.3MB, Beats 58.8%

    //Для улучшения времени можно попытаться захардходить сеты
    //Runtime 1ms, Beats 59.69%
    //Memory 40.6 MB, Beats 35.95%
    //на время это не повлияло )))
    public String[] findWords(String[] words) {
        //init();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isOneRowWord(word.toLowerCase())) res.add(word);
        }
        return res.toArray(String[]::new);
    }

    private boolean isOneRowWord(String word) {
        int row = getRowNumber(word.charAt(0));
        for (char c : word.toCharArray()) {
            if (getRowNumber(c) != row) return false;
        }
        return true;
    }

    private int getRowNumber(char c) {
        if (first.contains(c)) return 1;
        if (second.contains(c)) return 2;
        if (third.contains(c)) return 3;
        return -1;
    }

    private void init() {
        first = createSet("qwertyuiop");
        second = createSet("asdfghjkl");
        third = createSet("zxcvbnm");
    }

    private Set<Character> createSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

}
