package dventofcode.day2;

import java.util.HashMap;
import java.util.Map;

public enum Unit {
    ROCK,
    PAPER,
    SCISSORS;

    private static final int LOST = 0;
    private static final int DRAW = 3;
    private static final int WIN = 6;

    private static final Map<Character, Unit> UNIT_MAP;

    static {
        Map<Character, Unit> map = new HashMap<>(6);
        map.put('A', ROCK);
        map.put('B', PAPER);
        map.put('C', SCISSORS);
        map.put('X', ROCK);
        map.put('Y', PAPER);
        map.put('Z', SCISSORS);
        UNIT_MAP = map;
    }

    public static Unit findByCharacter(Character c) {
        return UNIT_MAP.get(c);
    }

    public int play(Unit you) {
        int win = this.win(you);
        int res = you.getWeight();
        if (win == 1) {
            res += WIN;
        } else if (win == 0) {
            res += DRAW;
        } else {
            res += LOST;
        }
        return res;
    }

    public Unit getTargetUnit(Character c) {
        int win = 0;
        if (c == 'X') win = -1;
        if (c == 'Z') win = 1;
        if (win == 0) return this;
        if (win > 0) {
            if (this == ROCK) return PAPER;
            if (this == PAPER) return SCISSORS;
            return ROCK;
        }
        if (this == ROCK) return SCISSORS;
        if (this == PAPER) return ROCK;
        return PAPER;
    }

    private int win(Unit other) {
        if (this == other) return 0;
        if ((this == ROCK && other == SCISSORS)
                || (this == PAPER && other == ROCK)
                || (this == SCISSORS && other == PAPER)) {
            return -1;
        } else {
            return 1;
        }
    }

    private int getWeight() {
        return ordinal() + 1;
    }

}
