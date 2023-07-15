package interview.algoritm;

import java.util.Random;

//
// Необходимо найти min, max и middle элементы из трех данных значений
//
public class SortOfThree {

    public static void main(String[] args) {

        Random random = new Random();

        int age1 = random.nextInt(100);
        int age2 = random.nextInt(100);
        int age3 = random.nextInt(100);

        int max = Math.max(Math.max(age1, age2), age3);
        int min = Math.min(Math.min(age1, age2), age3);
        int total = age1 + age2 + age3;
        int middle = total - max - min;

        System.out.println("Младший возраст: " + min);
        System.out.println("Средний возраст: " + middle);
        System.out.println("Максимальный возраст: " + max);

    }

}

