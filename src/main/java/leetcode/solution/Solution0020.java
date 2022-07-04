package leetcode.solution;

//
// Скобочки
// Открытые скобки должны быть закрыты однотипными скобками.
// Открытые скобки должны быть закрыты в правильном порядке.
//
// Правильный ответ только четной длинны
//
public class Solution0020 {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        char[] q = new char[s.length() / 2];
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                if (pointer == q.length) return false;
                switch (c) {
                    case '(':
                        q[pointer++] = ')';
                        break;
                    case '[':
                        q[pointer++] = ']';
                        break;
                    default:
                        q[pointer++] = '}';
                        break;
                }
            } else if (c == ')' || c == ']' || c == '}') {
                if (pointer < 1) return false;
                if (q[--pointer] != c) return false;
            }
        }
        return pointer == 0;
    }

}
