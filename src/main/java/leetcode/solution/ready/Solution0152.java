package leetcode.solution.ready;

public class Solution0152 {

    public int maxProduct(int[] nums) {

        if (nums.length == 1) return nums[0];

        var maxProduct = Integer.MIN_VALUE;
        var rightProduct = 0;
        var leftProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            var right = nums[i];
            var left = nums[nums.length - 1 - i];

            rightProduct = rightProduct == 0 ? right : rightProduct * right;
            leftProduct = leftProduct == 0 ? left : leftProduct * left;

            maxProduct = Math.max(maxProduct, rightProduct);
            maxProduct = Math.max(maxProduct, leftProduct);

        }

        return maxProduct;
    }

}
