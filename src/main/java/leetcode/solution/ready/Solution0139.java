package leetcode.solution.ready;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
// PrefixTree
// https://leetcode.com/problems/word-break/description/
//
public class Solution0139 {

    private boolean[] splittable;

    public boolean wordBreak(String s, List<String> wordDict) {

        Node head = init(wordDict);

        splittable = new boolean[s.length() + 1];
        splittable[0] = true;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!splittable[i]) continue;
            int offset = 0;
            Node cur = head;
            while (i + offset < chars.length && cur.hasChild(chars[i + offset])) {
                cur = cur.getChild(chars[i + offset]);
                offset++;
                if (cur.isTerminal()) markSplittable(i + offset);
            }
        }
        return splittable[splittable.length - 1];
    }

    private void markSplittable(int pos) {
        if (pos > -1 && pos < splittable.length) splittable[pos] = true;
    }


    private Node init(List<String> wordDict) {
        Node head = new Node('H');
        for (String word : wordDict) {
            addToTree(head, word);
        }
        return head;
    }

    private void addToTree(Node head, String word) {
        char[] chars = word.toCharArray();
        Node next = head;
        for (int i = 0; i < chars.length - 1; i++) {
            var c = chars[i];
            if (!next.hasChild(c)) {
                next = next.addChild(c);
            } else next = next.getChild(c);
        }
        char lastChar = chars[chars.length - 1];
        if (next.hasChild(lastChar)) {
            next.getChild(lastChar).markTerminal();
        } else {
            next.addTerminalChild(lastChar);
        }
    }

    static class Node {

        char name;
        Map<Character, Node> children = new HashMap<>();
        boolean terminal = false;

        public Node(char name) {
            this.name = name;
        }

        public void markTerminal() {
            this.terminal = true;
        }

        public boolean isTerminal() {
            return this.terminal;
        }

        public Node getChild(Character c) {
            return children.get(c);
        }

        public Node addChild(Character c) {
            Node node = new Node(c);
            children.put(node.name, node);
            return node;
        }

        public void addTerminalChild(Character c) {
            Node node = new Node(c);
            node.markTerminal();
            children.put(node.name, node);
        }

        public boolean hasChild(Character c) {
            return children.containsKey(c);
        }

    }

}
