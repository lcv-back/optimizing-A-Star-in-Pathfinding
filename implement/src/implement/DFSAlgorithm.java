package implement;

import java.util.Stack;

public class DFSAlgorithm implements PathFindingAlgorithm {
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
        Stack<Node> stack = new Stack<>();
        Node[][] parent = new Node[rows][cols];

        stack.push(start);
        visited[start.x][start.y] = true;

        while (!stack.isEmpty()) {
            maxSpaceUsed = Math.max(maxSpaceUsed, stack.size()); // Cập nhật maxSpaceUsed
            Node current = stack.pop();
            timeComplexity++; // Tăng số bước thực hiện
            path[current.x][current.y] = true;

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
                    stack.push(new Node(newX, newY));
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
