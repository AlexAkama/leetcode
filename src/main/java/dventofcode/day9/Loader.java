package dventofcode.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static dventofcode.day9.Loader.Direction.DOWN;
import static dventofcode.day9.Loader.Direction.LEFT;
import static dventofcode.day9.Loader.Direction.RIGHT;
import static dventofcode.day9.Loader.Direction.UP;
import static dventofcode.day9.Loader.Direction.findBy;

public class Loader {

    // 6337
    // 2455

    private static final int SIZE = 2000;
    private static final int HALF = SIZE / 2;
    private static final int[][] MAP = new int[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        var fileName = "src/main/java/dventofcode/day9/data.txt";
        java.io.File file = new java.io.File(fileName);
        FileReader fileReader = new FileReader(file);
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            Position head = new Position(0, 0);
            head.next = new Position(0, 0);
            head.next.next = new Position(0, 0);
            head.next.next.next = new Position(0, 0);
            head.next.next.next.next = new Position(0, 0);
            head.next.next.next.next.next = new Position(0, 0);
            head.next.next.next.next.next.next = new Position(0, 0);
            head.next.next.next.next.next.next.next = new Position(0, 0);
            head.next.next.next.next.next.next.next.next = new Position(0, 0);
            head.next.next.next.next.next.next.next.next.next = new Position(0, 0);

            while (line != null) {
                var parse = parse(line);
                for (int i = 0; i < parse.steps; i++) {
                    head.moveTo(DirectionPair.getVector(parse.direction));
                }
                line = reader.readLine();
            }
        }
        System.out.println(count());

    }

    private static int count() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == 1) count++;
            }
        }
        return ++count;
    }

    private static ParsePair parse(String s) {
        Direction direction = findBy(s.charAt(0));
        int steps = Integer.parseInt(s.substring(2));
        return new ParsePair(direction, steps);
    }

    private static class Position {

        private int x;
        private int y;

        private Position next;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setNext(Position next) {
            this.next = next;
        }

        public void moveTo(DirectionPair vector) {
            if (vector == null) return;
            if (vector.h == null && vector.v == null) return;
            if (vector.h != null) {
                if (vector.h == RIGHT) this.x++;
                else this.x--;
            }
            if (vector.v != null) {
                if (vector.v == UP) this.y++;
                else this.y--;
            }
            if (this.next == null) {
                MAP[HALF + this.y][HALF + this.x] = 1;
                return;
            }
            vector = this.whereMoveTail(this.next);
            this.next.moveTo(vector);
        }

        public DirectionPair whereMoveTail(Position tail) {
            if (this.x == tail.x && this.y == tail.y
                    || (Math.abs(this.x - tail.x) < 2 && Math.abs(this.y - tail.y) < 2))
                return DirectionPair.getNullPair();
            Direction h;
            Direction v;
            h = (this.x - tail.x) > 0 ? RIGHT : LEFT;
            v = (this.y - tail.y) > 0 ? UP : DOWN;
            if (this.y == tail.y) v = null;
            if (this.x == tail.x) h = null;
            return new DirectionPair(h, v);

        }

        @Override
        public String toString() {
            return "x:" + x + ",y:" + y;
        }

    }

    private static class DirectionPair {

        private final Direction h;
        private final Direction v;

        public DirectionPair(Direction h, Direction v) {
            this.h = h;
            this.v = v;
        }

        public static DirectionPair getNullPair() {
            return new DirectionPair(null, null);
        }

        public static DirectionPair getVector(Direction direction) {
            if (direction == UP) return new DirectionPair(null, UP);
            if (direction == RIGHT) return new DirectionPair(RIGHT, null);
            if (direction == DOWN) return new DirectionPair(null, DOWN);
            if (direction == LEFT) return new DirectionPair(LEFT, null);
            return null;
        }

        @Override
        public String toString() {
            return String.format("to %s:%s", h, v);
        }

    }

    private static class ParsePair {

        Direction direction;
        int steps;

        public ParsePair(Direction direction, int steps) {
            this.direction = direction;
            this.steps = steps;
        }

        @Override
        public String toString() {
            return direction + " " + steps;
        }

    }

    enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT;

        private static final Map<Character, Direction> map;

        static {
            map = new HashMap<>(4);
            map.put('U', UP);
            map.put('R', RIGHT);
            map.put('D', DOWN);
            map.put('L', LEFT);
        }

        public static Direction findBy(Character c) {
            return map.get(c);
        }

    }


}
