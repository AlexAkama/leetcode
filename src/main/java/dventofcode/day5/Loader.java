package dventofcode.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Loader {

    private static final Deque[] DEQUES = new Deque[9];

    static {
        for (int i = 0; i < 9; i++) {
            DEQUES[i] = new ArrayDeque<>();
        }
    }

    public static void main(String[] args) throws IOException {
        var fileName = "src/main/java/dventofcode/day5/data.txt";
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (!line.isEmpty()) {
                parseStacks(line);
                line = reader.readLine();
            }
            line = reader.readLine();
            while (line != null) {
                var data = lineParse(line);
                move(data.getCount(), data.getForm(), data.getTo());
                line = reader.readLine();
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            res.append(DEQUES[i].getLast());
        }
        System.out.println(res);
    }

    private static void move(int count, int from, int to) {
        var fromDeque = DEQUES[from - 1];
        var toDeque = DEQUES[to - 1];
        Deque buff = new ArrayDeque(count);
        for (int i = 0; i < count; i++) {
            var element = fromDeque.pollLast();
            buff.add(element);
        }
        for (int i = 0; i < count; i++) {
            var element = buff.pollLast();
            toDeque.addLast(element);
        }
    }

    private static void moveStepByStep(int count, int from, int to) {
        var fromDeque = DEQUES[from - 1];
        var toDeque = DEQUES[to - 1];
        for (int i = 0; i < count; i++) {
            var element = fromDeque.pollLast();
            toDeque.addLast(element);
        }
    }

    private static void parseStacks(String s) {
        int count = (s.length() + 1) / 4;
        for (int i = 0; i < count; i++) {
            char label = s.charAt(i * 4 + 1);
            if (Character.isUpperCase(label)) {
                DEQUES[i].addFirst(label);
            }
        }
    }

    private static Trinity lineParse(String s) {
        s = s.substring(5);

        int pos = s.indexOf(" ");
        int move = Integer.parseInt(s.substring(0, pos));
        s = s.substring(pos + 1);
        int from = Character.getNumericValue(s.charAt(5));
        int to = Character.getNumericValue(s.charAt(10));

        return new Trinity(move, from, to);
    }

    static class Trinity {

        private final int count;
        private final int form;
        private final int to;

        Trinity(int count, int form, int to) {
            this.count = count;
            this.form = form;
            this.to = to;
        }

        public int getCount() {
            return count;
        }

        public int getForm() {
            return form;
        }

        public int getTo() {
            return to;
        }

        @Override
        public String toString() {
            return "Trinity{" +
                    "move=" + count +
                    ", form=" + form +
                    ", to=" + to +
                    '}';
        }

    }

}
