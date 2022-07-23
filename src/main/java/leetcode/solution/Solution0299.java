package leetcode.solution;

//
// Быки и Коровы
// https://leetcode.com/problems/bulls-and-cows/
//
public class Solution0299 {

    //Runtime: 9 ms, faster than 64.54% of Java online submissions for Bulls and Cows.
    //Memory Usage: 42.9 MB, less than 56.51% of Java online submissions for Bulls and Cows.
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        char[] chars1 = secret.toCharArray();
        char[] chars2 = guess.toCharArray();
        int[] buff1 = new int[10];
        int[] buff2 = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (chars1[i] == chars2[i]) bulls++;
            else {
                buff1[chars1[i] - 48]++;
                buff2[chars2[i] - 48]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (buff1[i] != 0) cows += Math.min(buff1[i], buff2[i]);
        }
        return bulls + "A" + cows + "B";
    }

    // Пробуем брать сразу из строки
    //
    //Runtime: 6 ms, faster than 86.95% of Java online submissions for Bulls and Cows.
    //Memory Usage: 42.5 MB, less than 83.05% of Java online submissions for Bulls and Cows.
    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] buff1 = new int[10];
        int[] buff2 = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                buff1[secret.charAt(i) - '0']++;
                buff2[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (buff1[i] != 0) cows += Math.min(buff1[i], buff2[i]);
        }
        return String.valueOf(bulls) + 'A' + cows + 'B';
    }

}
