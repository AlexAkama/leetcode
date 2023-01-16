package leetcode.solution.ready;

//
// Есть время начала блокировки и продолжительность блокировки, посчитать итоговое время блокировки
// https://leetcode.com/problems/teemo-attacking/description/
//
public class Solution0495 {

    //Runtime 1 ms. Beats 100%
    //Memory 44.4 MB. Beats 89.15%
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = (timeSeries[0] == 0) ? 1 : 0;
        int stopTime = 0;
        for (int time : timeSeries) {
            if (stopTime >= time) {
                count -= stopTime - time + 1;
            }
            stopTime = time + duration - 1;
            count += duration;
        }
        return count;
    }

}
