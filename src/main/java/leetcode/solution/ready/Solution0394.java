package leetcode.solution.ready;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//
// Декодирование строки
// https://leetcode.com/problems/decode-string/
//
// Первый вариант - через regex (но regex медленный)
// Второй что-то со стеком
// + offer - добавляем
// + poll - получаем с удалением
public class Solution0394 {

    //Runtime: 1 ms, faster than 87.68% of Java online submissions for Decode String.
    //Memory Usage: 42.1 MB, less than 48.46% of Java online submissions for Decode String.
    public String decodeString(String s) {
        Queue<Character> chars = new LinkedList<>();
        for (char c : s.toCharArray()) chars.offer(c);
        return decode(chars);
    }

    private String decode(Queue<Character> chars) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!chars.isEmpty()) {
            char c = chars.poll();
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                String text = decode(chars);
                sb.append(text.repeat(Math.max(0, count)));
                count = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    //Runtime: 8 ms, faster than 19.45% of Java online submissions for Decode String.
    //Memory Usage: 42.1 MB, less than 56.34% of Java online submissions for Decode String.
    public String decodeString2(String s) {
        Pattern pattern = Pattern.compile("\\d+\\[[a-z]+]");
        Matcher matcher = pattern.matcher(s);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (matcher.find()) {
            matcher.appendReplacement(sb, simpleDecode(matcher.group()));
            count++;
        }
        matcher.appendTail(sb);
        return (count == 0) ? sb.toString() : decodeString2(sb.toString());
    }

    private String simpleDecode(String code) {
        String[] split = code.split("\\[", 2);
        int count = Integer.parseInt(split[0]);
        String text = split[1].substring(0, split[1].length() - 1);
        return text.repeat(count);
    }

}
