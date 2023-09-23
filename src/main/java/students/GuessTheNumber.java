package students;

import java.util.Random;
import java.util.Scanner;

/*
Угадай число
 */
public class GuessTheNumber {

    public static void main(String[] args) {

        int expected = new Random().nextInt(100);
        System.out.println("Угадай число 1..100:");

        String win = "Вы угадали!";
        String message;
        int actual = -1;
        while (expected != actual) {
            actual = new Scanner(System.in).nextInt();
            if (expected == actual) message = win;
            else message = "Заданное число " + ((actual < expected) ? "больше" : "меньше");
            System.out.println(message);
        }

    }

}
