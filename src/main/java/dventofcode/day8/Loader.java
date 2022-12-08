package dventofcode.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Loader {

    private static int[][] grid;
    private static int gridSize;

    private static int maxScenic = 0;

    public static void main(String[] args) throws IOException {
        parse();
        int count = countVisible();
        System.out.println(count);
        System.out.println(maxScenic);
    }

    private static int countVisible() {
        int count = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (isVisibleAndScenic(i, j)) count++;
            }
        }
        return count;
    }

    private static boolean isVisibleAndScenic(int x, int y) {
        if (x == 0 || y == 0 || x == gridSize - 1 || y == gridSize - 1) return true;
        int current = grid[y][x];
        boolean topVisible = true;
        int topScenic = 0;
        boolean rightVisible = true;
        int rightScenic = 0;
        boolean bottomVisible = true;
        int bottomScenic = 0;
        boolean leftVisible = true;
        int leftScenic = 0;
        for (int i = y - 1; i > -1; i--) {
            topScenic++;
            if (grid[i][x] >= current) {
                topVisible = false;
                break;
            }
        }
        for (int i = x + 1; i < gridSize; i++) {
            rightScenic++;
            if (grid[y][i] >= current) {
                rightVisible = false;
                break;
            }
        }
        for (int i = y + 1; i < gridSize; i++) {
            bottomScenic++;
            if (grid[i][x] >= current) {
                bottomVisible = false;
                break;
            }
        }
        for (int i = x - 1; i > -1; i--) {
            leftScenic++;
            if (grid[y][i] >= current) {
                leftVisible = false;
                break;
            }
        }
        int scenic = topScenic * rightScenic * bottomScenic * leftScenic;
        if (scenic > maxScenic) maxScenic = scenic;
        return topVisible || rightVisible || bottomVisible || leftVisible;
    }

    private static boolean isVisible(int x, int y) {
        if (x == 0 || y == 0 || x == gridSize - 1 || y == gridSize - 1) return true;
        int current = grid[y][x];
        boolean topVisible = true;
        boolean rightVisible = true;
        boolean bottomVisible = true;
        boolean leftVisible = true;
        for (int i = y - 1; i > -1; i--) {
            if (grid[i][x] >= current) {
                topVisible = false;
                break;
            }
        }
        if (!topVisible) {
            for (int i = x + 1; i < gridSize; i++) {
                if (grid[y][i] >= current) {
                    rightVisible = false;
                    break;
                }
            }
        }
        if (!topVisible && !rightVisible) {
            for (int i = y + 1; i < gridSize; i++) {
                if (grid[i][x] >= current) {
                    bottomVisible = false;
                    break;
                }
            }
        }
        if (!topVisible && !rightVisible && !bottomVisible) {
            for (int i = x - 1; i > -1; i--) {
                if (grid[y][i] >= current) {
                    leftVisible = false;
                    break;
                }
            }
        }
        return topVisible || rightVisible || bottomVisible || leftVisible;
    }

    private static void parse() throws IOException {
        var fileName = "src/main/java/dventofcode/day8/data.txt";
        java.io.File file = new java.io.File(fileName);
        FileReader fileReader = new FileReader(file);
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            gridSize = line.length();
            grid = new int[gridSize][gridSize];
            int y = 0;
            while (line != null) {
                int x = 0;
                for (char c : line.toCharArray()) {
                    grid[y][x++] = Character.getNumericValue(c);
                }
                line = reader.readLine();
                y++;
            }
        }
    }

}
