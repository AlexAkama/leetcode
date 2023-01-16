package leetcode.utils;

public class GreatestCommonDivisor {

    /**
     * Поиск наибольшего общего делителя НОД
     * <br>Greatest common divisor GCD
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
