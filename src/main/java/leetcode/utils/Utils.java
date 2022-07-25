package leetcode.utils;

import leetcode.solution.ListNode;
import leetcode.solution.TreeNode;

import java.io.Serializable;
import java.util.List;

public class Utils {

    private Utils() {
    }

    public static void printListInString(List<? extends Serializable> list) {
        for (Serializable element : list) {
            System.out.print(element + " ");
        }
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
