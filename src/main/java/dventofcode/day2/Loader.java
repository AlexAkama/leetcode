package dventofcode.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loader {

    public static void main(String[] args) throws IOException {

        var fileName = "src/main/java/dventofcode/day2/data.txt";
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        int count = 0;
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                var c1 = line.charAt(0);
                var c2 = line.charAt(2);
                var u1 = Unit.findByCharacter(c1);
                //var u2 = Unit.findByCharacter(c2);
                var u2 = u1.getTargetUnit(c2);
                sum += u1.play(u2);
                System.out.printf("%-4d %s -> %s :%d\n", ++count, c1, c2, sum);
                line = reader.readLine();
            }
        }

    }

}
