package implement;

public interface PathFindingAlgorithm {
    boolean findPath(int[][] matrix, Node start, Node goal);
    boolean findPathWithPathMatrix(int[][] matrix, Node start, Node goal, boolean[][] path);
    int getSpaceComplexity();
    int getTimeComplexity();
}

