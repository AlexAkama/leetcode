package leetcode.solution.ready;

/*
https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 */
public class Solution2011 {

    private static final String PREFIX_ADD = "++X";
    private static final String POSTFIX_ADD = "X++";
    private static final String PREFIX_SUB = "--X";
    private static final String POSTFIX_SUB = "X--";

    //Runtime 1ms, Beats 72.11%of users with Java
    //Memory 42.12MB, Beats 12.37% of users with Java
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.equals(PREFIX_ADD) || operation.equals(POSTFIX_ADD)) res++;
            else if (operation.equals(PREFIX_SUB) || operation.equals(POSTFIX_SUB)) res--;
        }
        return res;
    }

    // А без статиков памяти меньше
    //
    //Runtime 1ms, Beats 72.11%of users with Java
    //Memory 40.94MB, Beats 97.86% of users with Java
    public int finalValueAfterOperationsV1(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) res++;
            else if (operation.equals("--X") || operation.equals("X--")) res--;
        }
        return res;
    }

}
