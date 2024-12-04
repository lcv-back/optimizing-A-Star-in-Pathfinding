package implement;

import java.util.Random;

public class MatrixGenerator {
    public static int[][] generateMatrix(int size, double obstacleRatio) {
        int[][] matrix = new int[size][size];
        Random rand = new Random();
        int totalObstacles = (int) (size * size * obstacleRatio);

        for (int i = 0; i < totalObstacles; i++) {
            int x, y;
            do {
                x = rand.nextInt(size);
                y = rand.nextInt(size);
            } while (matrix[x][y] == 1 || (x == 0 && y == 0) || (x == size - 1 && y == size - 1));
            matrix[x][y] = 1; // 1 đại diện cho vật cản
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix, Node start, Node goal, boolean[][] path) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == start.x && j == start.y) {
                    System.out.print("o ");
                } else if (i == goal.x && j == goal.y) {
                    System.out.print("F ");
                } else if (matrix[i][j] == 1) {
                    System.out.print("x ");
                } else if (path != null && path[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}


