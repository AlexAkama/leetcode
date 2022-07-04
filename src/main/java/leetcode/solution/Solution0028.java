package leetcode.solution;

//
// Строки вхождение
//
// Полезно:
// String.contains()
// String.lastIndexOf()
//
// Про StringUtils (Apache Commons)
// https://dev-gang.ru/article/java-kak-proverit-soderzhit-li-stroka-podstroku-0c4hoa1j3h/
//
public class Solution0028 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
