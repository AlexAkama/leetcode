package dventofcode.day1;

import java.io.IOException;

public class Loader {

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        System.out.println(parser.getElfNumber("src/main/java/dventofcode/day1/data.txt"));
    }

}
