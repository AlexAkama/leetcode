package leetcode.solution.ready;

import leetcode.utils.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//
// HARD
// Покраска домов
// https://leetcode.com/problems/paint-house-iii/
//
public class Solution1473 {

    private static final Map<String, Integer> cache = new HashMap<>();

    //Time Limit Exceeded
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        cache.clear();
        if (m < target && target == 0) return -1;
        int groupCount = groupCount(houses);
        int forPainting = forPainting(houses);
        if (groupCount > target && forPainting == 0) return -1;
        int paintedGroupCount = paintGroupCount(houses);
        if (paintedGroupCount - forPainting > target) return -1;
        boolean[][] colorMap = getColorMap(houses, m, n, target - paintedGroupCount);
        boolean[] priceMap = getPriceMap(colorMap);
        return foo(houses, cost, colorMap, priceMap, target);
    }

    private int foo(int[] houses, int[][] cost, boolean[][] colorMap, boolean[] priceMap, int target) {
        String code = getCode(houses);
        Integer cachedResult = cache.get(code);
        if (cachedResult != null) return cachedResult;
        int price0 = -1;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == 0) {
                boolean hasZero = false;
                for (int j = 0; j < colorMap[i].length; j++) {
                    if (colorMap[i][j]) {
                        int[] variant = Arrays.copyOf(houses, houses.length);
                        variant[i] = j + 1;
                        int temp = foo(variant, cost, colorMap, priceMap, target);
                        cache.put(getCode(variant), temp);
                        Utils.printIntArrayMonospace(variant);
                        price0 = getPositiveMin(temp, price0);
                        hasZero = true;
                    }
                }
                if (hasZero) return price0;
            }
        }
        int price = priceCalculate(houses, cost, priceMap, target);
        cache.put(getCode(houses), price);
        return price;
    }

    private int getPositiveMin(int i1, int i2) {
        if (i1 < 0 && i2 < 0) return -1;
        return Math.min(
                (i1 < 0) ? Integer.MAX_VALUE : i1,
                (i2 < 0) ? Integer.MAX_VALUE : i2
        );
    }

    private String getCode(int[] houses) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < houses.length; i++) {
            sb.append(houses[i]).append(".");
        }
        return sb.toString();
    }

    private int priceCalculate(int[] houses, int[][] cost, boolean[] priceMap, int target) {
        int result = 0;
        int groupCount = 1;
        for (int i = 0; i < houses.length; i++) {
            if (i > 0 && houses[i - 1] != houses[i]) groupCount++;
            if (groupCount > target) return -1;
            if (priceMap[i]) result += cost[i][houses[i] - 1];
        }
        return (groupCount == target) ? result : -1;
    }

    private boolean[] getPriceMap(boolean[][] colorMap) {
        boolean[] priceMap = new boolean[colorMap.length];
        for (int i = 0; i < colorMap.length; i++) {
            for (int j = 0; j < colorMap[i].length; j++) {
                if (colorMap[i][j]) {
                    priceMap[i] = true;
                    break;
                }
            }
        }
        return priceMap;
    }

    private boolean[][] getColorMap(int[] houses, int m, int n, int limitGroup) {
        boolean[][] colorMap = new boolean[m][n];
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == 0) {
                if (i > 0) {
                    if (limitGroup == 0) {
                        colorMap[i][houses[i - 1] - 1] = true;
                    } else {
                        for (int j = 0; j < n; j++) {
                            colorMap[i][j] = true;
                        }
                    }
                }
                if (i < houses.length - 1) {
                    if (limitGroup == 0) {
                        colorMap[i][houses[i + 1] - 1] = true;
                    } else {
                        for (int j = 0; j < n; j++) {
                            colorMap[i][j] = true;
                        }
                    }
                }
            }
        }
        return colorMap;
    }

    private int groupCount(int[] ints) {
        int count = 1;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i - 1] != ints[i]) count++;
        }
        return count;
    }

    private int paintGroupCount(int[] ints) {
        int count = (ints[0] == 0) ? 0 : 1;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] != 0
                    && ints[i - 1] != ints[i]) count++;
        }
        return count;
    }

    private int forPainting(int[] ints) {
        int count = 0;
        for (int anInt : ints) {
            if (anInt == 0) count++;
        }
        return count;
    }

}
