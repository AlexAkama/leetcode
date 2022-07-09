package leetcode.utils;


import java.io.Serializable;
import java.util.List;

public class Utils {

    private Utils() {
    }

    public static void printListInString(List<? extends Serializable> list) {
        list.forEach(System.out::print);
        System.out.println();
    }

    public static void printIntArray(int[] ints) {
        for (int anInt : ints) {
            System.out.print(anInt);
        }
        System.out.println();
    }

    public static void printIntArrayMonospace(int[] ints) {
        for (int anInt : ints) {
            System.out.printf("%3d", anInt);
        }
        System.out.println();
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%2d", matrix[i][j]);
            }
            System.out.println();
        }
    }

}
