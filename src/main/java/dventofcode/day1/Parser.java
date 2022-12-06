package dventofcode.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    public int getElfNumber(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        var elf = 0;
        var max = 0;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            var sum = 0;
            var counter = 0;
            while (line != null) {
                if (line.isEmpty()) {
                    counter++;
                    if (sum > max) {
                        elf = counter;
                        max = sum;
                    }
                    System.out.printf("%-4d %6d %4d\n", counter, sum, elf);
                    sum = 0;
                } else {
                    var temp = Integer.parseInt(line);
                    sum += temp;
                }
                line = reader.readLine();
            }
        }
        return elf;

    }

}
