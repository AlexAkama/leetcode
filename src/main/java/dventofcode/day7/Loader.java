package dventofcode.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Loader {

    private static final Directory ROOT = Directory.getRoot();

    private static final int LIMIT = 100_000;
    private static final int DISK_LIMIT = 70_000_000;
    private static final int FREE_LIMIT = 30_000_000;

    private static Directory pointer = ROOT;
    private static String path = "root";
    private static int total = 0;
    private static int toFree = Integer.MAX_VALUE;
    private static int needle = 0;

    public static void main(String[] args) throws IOException {
        var fileName = "src/main/java/dventofcode/day7/data.txt";
        java.io.File file = new java.io.File(fileName);
        FileReader fileReader = new FileReader(file);
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                parse(line);
                line = reader.readLine();
            }
        }

        int rootSize = ROOT.getSize();
        int realFreeSize = DISK_LIMIT - rootSize;
        needle = FREE_LIMIT - realFreeSize;

        System.out.println(rootSize);
        System.out.println(realFreeSize);
        System.out.println(needle);

        countFree(ROOT);

        System.out.println(toFree);

    }

    private static void countFree(Directory directory) {
        List<Directory> subDirectories = directory.getDirectories();
        if (!subDirectories.isEmpty()) {
            for (Directory subDirectory : subDirectories) {
                countFree(subDirectory);
            }
        }
        int size = directory.getSize();
        if (size > needle && size < toFree) toFree = size;
    }

    private static void count(Directory directory) {
        List<Directory> subDirectories = directory.getDirectories();
        if (!subDirectories.isEmpty()) {
            for (Directory subDirectory : subDirectories) {
                count(subDirectory);
            }
        }
        int size = directory.getSize();
        if (size < LIMIT) total += size;
    }

    private static void parse(String s) {
        if (s.charAt(0) == '$') parseCommand(s.substring(2));
        else parseData(s);
    }

    private static void parseCommand(String s) {
        String[] split = s.split(" ");
        var command = split[0];
        if (command.equals("cd")) {
            var name = split[1];
            if (name.equals("/")) {
                pointer = ROOT;
                path = "root";
            } else if (name.equals("..")) {
                pointer = pointer.getMaster();
                int end = path.lastIndexOf("/");
                path = path.substring(0, end);
            } else {
                pointer = pointer.getSubDirectory(name);
                path += "/" + name;
            }
            //System.out.println(path);
        }
    }

    private static void parseData(String s) {
        if (Character.isDigit(s.charAt(0))) parseFile(s);
        else parseDirectory(s);
    }

    private static void parseDirectory(String s) {
        String[] split = s.split(" ");
        pointer.add(split[1]);
    }

    private static void parseFile(String s) {
        String[] split = s.split(" ");
        File file = new File(split[1], Integer.parseInt(split[0]));
        pointer.add(file);
    }

}
