package leetcode.utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppUtils {

    private AppUtils() {
    }

    public static void printListInString(List<? extends Serializable> list) {
        for (Serializable element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printIntArray(int[] ints) {
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
    }

    public static void printIntArray(int[] ints, String expected) {
        String accept = Arrays.stream(ints)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(expected + ": " + accept + " -" + accept.equals(expected));
    }

    public static void printIntArrayMonospace(int[] ints) {
        for (int anInt : ints) {
            System.out.printf("%4d", anInt);
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

    public static void printBinaryTree(TreeNode node) {
        if (node == null) return;
        System.out.printf("%4d", node.val);
        printBinaryTree(node.left);
        printBinaryTree(node.left);
    }

    public static void printNodeList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

}
