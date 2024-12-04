package implement;

import java.util.PriorityQueue;
import java.util.Comparator;

public class AStarBidirectionalAlgorithm implements PathFindingAlgorithm {
    private int maxSpaceUsedStart = 0;
    private int maxSpaceUsedGoal = 0;
    private int timeComplexity = 0; // Số bước thực hiện

    @Override
    public boolean findPathWithPathMatrix(int[][] matrix, Node start, Node goal, boolean[][] path) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visitedStart = new boolean[rows][cols];
        boolean[][] visitedGoal = new boolean[rows][cols];
        PriorityQueue<Node> openStart = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        PriorityQueue<Node> openGoal = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Node[][] parentStart = new Node[rows][cols];
        Node[][] parentGoal = new Node[rows][cols];

        start.cost = heuristic(start, goal);
        goal.cost = heuristic(goal, start);
        openStart.add(start);
        openGoal.add(goal);

        while (!openStart.isEmpty() && !openGoal.isEmpty()) {
            maxSpaceUsedStart = Math.max(maxSpaceUsedStart, openStart.size());
            maxSpaceUsedGoal = Math.max(maxSpaceUsedGoal, openGoal.size());

            if (expandNode(matrix, openStart, visitedStart, visitedGoal, parentStart, goal)) {
                tracePathBidirectional(path, parentStart, parentGoal, start, goal);
                return true;
            }

            if (expandNode(matrix, openGoal, visitedGoal, visitedStart, parentGoal, start)) {
                tracePathBidirectional(path, parentStart, parentGoal, start, goal);
                return true;
            }

            timeComplexity++; // Tăng số bước thực hiện
        }

        return false;
    }

    private boolean expandNode(int[][] matrix, PriorityQueue<Node> openList, boolean[][] visitedThisSide,
                               boolean[][] visitedOtherSide, Node[][] parent, Node goal) {
        if (openList.isEmpty()) return false;

        Node current = openList.poll();

        if (visitedThisSide[current.x][current.y]) return false;
        visitedThisSide[current.x][current.y] = true;

        if (visitedOtherSide[current.x][current.y]) {
            return true;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newX = current.x + dir[0];
            int newY = current.y + dir[1];

            if (isValid(matrix, newX, newY, visitedThisSide)) {
                Node neighbor = new Node(newX, newY);
                neighbor.cost = current.cost + 1 + heuristic(neighbor, goal);
                neighbor.parent = current;
                openList.add(neighbor);
                parent[newX][newY] = current;
            }
        }

        return false;
    }

    private boolean isValid(int[][] matrix, int x, int y, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length &&
               matrix[x][y] != 1 && !visited[x][y];
    }

    private int heuristic(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private void tracePathBidirectional(boolean[][] path, Node[][] parentStart, Node[][] parentGoal,
                                        Node start, Node goal) {
        Node mid = findMeetingPoint(parentStart, parentGoal);
        tracePath(path, parentStart, mid);
        tracePath(path, parentGoal, mid);
    }

    private Node findMeetingPoint(Node[][] parentStart, Node[][] parentGoal) {
        for (int i = 0; i < parentStart.length; i++) {
            for (int j = 0; j < parentStart[0].length; j++) {
                if (parentStart[i][j] != null && parentGoal[i][j] != null) {
                    return new Node(i, j);
                }
            }
        }
        return null;
    }

    private void tracePath(boolean[][] path, Node[][] parent, Node current) {
        while (current != null) {
            path[current.x][current.y] = true;
            current = parent[current.x][current.y];
        }
    }

    @Override
    public int getSpaceComplexity() {
        return Math.max(maxSpaceUsedStart, maxSpaceUsedGoal);
    }

    @Override
    public int getTimeComplexity() {
        return timeComplexity;
    }

    @Override
    public boolean findPath(int[][] matrix, Node start, Node goal) {
        return findPathWithPathMatrix(matrix, start, goal, new boolean[matrix.length][matrix[0].length]);
    }
}
