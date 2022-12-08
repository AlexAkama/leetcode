package dventofcode.day7;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private final Directory master;
    private final String name;
    private final List<Directory> directories;
    private final List<File> files;

    private Directory(Directory master, String name) {
        this.master = master;
        this.name = name;
        directories = new ArrayList<>();
        files = new ArrayList<>();
    }

    static Directory getRoot() {
        return new Directory(null, "/");
    }

    public void add(String dir) {
        Directory directory = new Directory(this, dir);
        directories.add(directory);
    }

    public void add(File file) {
        //System.out.printf("%-12s %8d\n", file.getName(), file.getSize());
        files.add(file);
    }

    public int getSize() {
        int dirSum = directories.stream().mapToInt(Directory::getSize).sum();
        int fileSum = files.stream().mapToInt(File::getSize).sum();
        return dirSum + fileSum;
    }

    public String getName() {
        return name;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public List<File> getFiles() {
        return files;
    }

    public Directory getMaster() {
        return master;
    }

    public Directory getSubDirectory(String name) {
        for (Directory directory : directories) {
            if (directory.getName().equals(name)) return directory;
        }
        return null;
    }

}
