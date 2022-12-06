package dventofcode.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Loader {

    private static final int[] buf1 = new int[52];
    private static final int[] buf2 = new int[52];
    private static final int[] buf3 = new int[52];

    public static void main(String[] args) throws IOException {

        var fileName = "src/main/java/dventofcode/day3/data.txt";
        File file = new File(fileName);
        System.out.println(findGroupSum(file));
    }

    private static int findGroupSum(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line1 = reader.readLine();
            String line2;
            String line3;
            while (line1 != null) {
                line2 = reader.readLine();
                line3 = reader.readLine();
                sum += groupCalculate(line1, line2, line3);
                line1 = reader.readLine();
            }
        }
        return sum;
    }

    private static int groupCalculate(String s1, String s2, String s3) {
        createFrame(s1, buf1);
        createFrame(s2, buf2);
        createFrame(s3, buf3);

        int code = 0;
        for (int i = 0; i < 52; i++) {
            if (buf1[i] > 0 && buf2[i] > 0 && buf3[i] > 0) {
                code = i + 1;
            }
        }

        Arrays.fill(buf1, 0);
        Arrays.fill(buf2, 0);
        Arrays.fill(buf3, 0);

        return code;
    }

    private static int findSum(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                sum += calculate(line);
                line = reader.readLine();
            }
        }
        return sum;
    }

    private static int calculate(String s) {

        var mid = s.length() / 2;
        var half1 = s.substring(0, mid);
        var half2 = s.substring(mid);

        createFrame(half1, buf1);
        createFrame(half2, buf2);

        int code = 0;
        for (int i = 0; i < 52; i++) {
            if (buf1[i] > 0 && buf2[i] > 0) {
                code = i + 1;
                break;
            }
        }

        Arrays.fill(buf1, 0);
        Arrays.fill(buf2, 0);

        return code;
    }

    private static void createFrame(String s, int[] buff) {
        for (byte aByte : s.getBytes()) {
            int i = getWeight(aByte) - 1;
            buff[i] = buff[i] + 1;
        }
    }

    private static int getWeight(byte code) {
        if (code > 90) return code - 'a' + 1;
        else return code - 'A' + 27;
    }

}
