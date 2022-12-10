package dventofcode.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static dventofcode.day10.Loader.Command.ADDX;
import static dventofcode.day10.Loader.Command.NOOP;

public class Loader {

    private static final int PERIOD = 40;
    private static final int OFFSET = 20;

    private static final char LIT = '#';
    private static final char DARK = ' ';
    private static int cycle = 0;
    private static int x = 1;
    private static int signal = 0;

    public static void main(String[] args) throws IOException {
        var fileName = "src/main/java/dventofcode/day10/data.txt";
        java.io.File file = new java.io.File(fileName);
        FileReader fileReader = new FileReader(file);
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                var parse = parse(line);
                var command = parse.command;
                for (int i = 0; i < command.duration; i++) {
                    cycle++;
                    part2();
                }
                if (command == ADDX) x += parse.volume;
                line = reader.readLine();
            }
        }
    }

    private static void part2() {
        int pos = (cycle - 1) % PERIOD;
        if (pos == 0) System.out.println();
        if (Math.abs(pos - x) < 2) System.out.print(LIT);
        else System.out.print(DARK);
    }


    private static void part1() {
        if ((cycle - OFFSET) % PERIOD == 0) {
            signal += cycle * x;
        }
    }

    private static ParsePair parse(String s) {
        if (s.charAt(0) == 'a') {
            int volume = Integer.parseInt(s.substring(5));
            return new ParsePair(ADDX, volume);
        } else {
            return new ParsePair(NOOP);
        }
    }

    static class ParsePair {

        private final Command command;
        private final Integer volume;

        public ParsePair(Command command, Integer volume) {
            this.command = command;
            this.volume = volume;
        }

        public ParsePair(Command command) {
            this(command, null);
        }

        @Override
        public String toString() {
            return command + ((volume != null) ? " " + volume : "");
        }

    }

    enum Command {
        NOOP(1),
        ADDX(2);

        private final int duration;

        Command(int duration) {
            this.duration = duration;
        }
    }

}
