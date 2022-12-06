package dventofcode.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loader {

    public static final String LINE_DELIMITER = ",";
    public static final String PARSE_DELIMITER = "-";

    public static void main(String[] args) throws IOException {
        var fileName = "src/main/java/dventofcode/day4/data.txt";
        File file = new File(fileName);
        System.out.println(calculateIntersection(file));

    }

    private static int calculateIntersection(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(LINE_DELIMITER);
                var p1 = parseToPair(split[0]);
                var p2 = parseToPair(split[1]);
                sum += (isIntersection(p1, p2)) ? 1 : 0;
                line = reader.readLine();
            }
        }
        return sum;
    }

    private static int calculateIncluded(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(LINE_DELIMITER);
                var p1 = parseToPair(split[0]);
                var p2 = parseToPair(split[1]);
                sum += (isInclude(p1, p2)) ? 1 : 0;
                line = reader.readLine();
            }
        }
        return sum;
    }

    private static Pair parseToPair(String s) {
        String[] split = s.split(PARSE_DELIMITER);
        var i1 = Integer.parseInt(split[0]);
        var i2 = Integer.parseInt(split[1]);
        return new Pair(i1, i2);
    }

    private static boolean isInclude(Pair p1, Pair p2) {
        if (p1.getSecond() < p2.getFirst() || p2.getSecond() < p1.getFirst()) return false;
        return p1.getFirst() <= p2.getFirst() && p1.getSecond() >= p2.getSecond()
                || (p2.getFirst() <= p1.getFirst() && p2.getSecond() >= p1.getSecond());
    }

    private static boolean isIntersection(Pair p1, Pair p2) {
        return p1.getSecond() >= p2.getFirst() && p2.getSecond() >= p1.getFirst();
    }

    static class Pair {

        private final Integer first;
        private final Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }

    }

}
