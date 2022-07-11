package leetcode.solution.ready;

//
// Нахождение максимального профита
//
//Runtime: 4 ms, faster than 30.12% of Java online submissions for Best Time to Buy and Sell Stock.
//Memory Usage: 76.5 MB, less than 78.33% of Java online submissions for Best Time to Buy and Sell Stock.
public class Solution0121 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }

    // Эксперимент - замена методов на if
    //Runtime: 2 ms, faster than 93.21% of Java online submissions for Best Time to Buy and Sell Stock.
    //Memory Usage: 76.4 MB, less than 79.55% of Java online submissions for Best Time to Buy and Sell Stock.
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price < min) min = price;
            if (price - min > profit) profit = price - min;
        }
        return profit;
    }


}
