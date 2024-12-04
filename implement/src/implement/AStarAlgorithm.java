package implement;

import java.util.PriorityQueue;
import java.util.Comparator;

public class AStarAlgorithm implements PathFindingAlgorithm {
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
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Node[][] parent = new Node[rows][cols];

        start.cost = heuristic(start, goal);
        openList.add(start);

        while (!openList.isEmpty()) {
            maxSpaceUsed = Math.max(maxSpaceUsed, openList.size());
            Node current = openList.poll();
            timeComplexity++; // Tăng số bước thực hiện

            if (visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;
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
                    Node neighbor = new Node(newX, newY);
                    neighbor.cost = current.cost + 1 + heuristic(neighbor, goal);
                    neighbor.parent = current;
                    openList.add(neighbor);
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

    private int heuristic(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private void tracePath(boolean[][] path, Node[][] parent, Node goal) {
        Node current = goal;
        while (current != null) {
            path[current.x][current.y] = true;
            current = parent[current.x][current.y];
        }
    }
}
