package implement;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgorithm implements PathFindingAlgorithm {
    private int maxSpaceUsed = 0;
    private int timeComplexity = 0; // Số bước thực hiện

    @Override
    public boolean findPath(int[][] matrix, Node start, Node goal) {
        return findPathWithPathMatrix(matrix, start, goal, new boolean[matrix.length][matrix[0].length]);
    }

    @Override
    public boolean findPathWithPathMatrix(int[][] matrix, Node start, Node goal, boolean[][] path) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Node> queue = new LinkedList<>();
        Node[][] parent = new Node[rows][cols];

        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            maxSpaceUsed = Math.max(maxSpaceUsed, queue.size());
            Node current = queue.poll();
            timeComplexity++; // Tăng số bước thực hiện

            if (current.x == goal.x && current.y == goal.y) {
                tracePath(path, parent, goal);
                return true;
            }

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols &&
                        matrix[newX][newY] != 1 && !visited[newX][newY]) {
                    queue.add(new Node(newX, newY));
                    visited[newX][newY] = true;
                    parent[newX][newY] = current;
                }
            }
        }
        return false;
    }

    @Override
    public int getSpaceComplexity() {
        return maxSpaceUsed;
    }

    @Override
    public int getTimeComplexity() {
        return timeComplexity;
    }

    private void tracePath(boolean[][] path, Node[][] parent, Node goal) {
        Node current = goal;
        while (current != null) {
            path[current.x][current.y] = true;
            current = parent[current.x][current.y];
        }
    }
}
