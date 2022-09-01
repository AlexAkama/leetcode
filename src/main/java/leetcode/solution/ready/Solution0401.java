package leetcode.solution.ready;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Бинарные часы
// https://leetcode.com/problems/binary-watch/
//
// + Integer.bitCount
public class Solution0401 {

    //Runtime: 18 ms, faster than 35.99% of Java online submissions for Binary Watch.
    //Memory Usage: 43.4 MB, less than 19.89% of Java online submissions for Binary Watch.
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    list.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return list;
    }


    //Runtime: 24 ms, faster than 15.16% of Java online submissions for Binary Watch.
    //Memory Usage: 44 MB, less than 5.01% of Java online submissions for Binary Watch.
    public List<String> readBinaryWatch1(int turnedOn) {
        List<String> list = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    list.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return list;
    }

}

class Solution0401v0 {

    private static final int[] DIGITS = new int[]{1, 2, 4, 8, 16, 32};
    List<String> list = new ArrayList<>();

    //Runtime: 25 ms, faster than 12.45% of Java online submissions for Binary Watch.
    //Memory Usage: 43.5 MB, less than 13.80% of Java online submissions for Binary Watch.
    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 8) return list;
        if (turnedOn == 0) {
            list.add(getTimeString(0, 0));
            return list;
        }
        foo(0, turnedOn, new int[10]);
        return list;
    }

    private void foo(int start, int level, int[] frame) {
        if (level == 0) {
            addTimeFromFrame(frame);
            return;
        }
        for (int i = start; i < 10; i++) {
            if (frame[i] == 1) continue;
            int[] ints = Arrays.copyOf(frame, frame.length);
            ints[i] = 1;
            foo(i, level - 1, ints);
        }
    }

    private void addTimeFromFrame(int[] frame) {
        int hours = DIGITS[0] * frame[0]
                + DIGITS[1] * frame[1]
                + DIGITS[2] * frame[2]
                + DIGITS[3] * frame[3];
        int minutes = DIGITS[0] * frame[4]
                + DIGITS[1] * frame[5]
                + DIGITS[2] * frame[6]
                + DIGITS[3] * frame[7]
                + DIGITS[4] * frame[8]
                + DIGITS[5] * frame[9];
        addTime(hours, minutes);
    }

    private void addTime(int hours, int minutes) {
        if (hours < 0 || hours > 11 || minutes < 0 || minutes > 59) return;
        list.add(getTimeString(hours, minutes));
    }

    private String getTimeString(int hours, int minutes) {
        return String.format("%02d:%02d", hours, minutes);
    }

}
