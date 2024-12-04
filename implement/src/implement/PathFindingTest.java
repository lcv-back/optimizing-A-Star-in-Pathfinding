package implement;

import java.util.Scanner;

public class PathFindingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 50; // Kích thước ma trận
        double obstacleRatio = 0.2; // Tỷ lệ vật cản

        // Tạo ma trận và xác định điểm bắt đầu và kết thúc
        int[][] matrix = MatrixGenerator.generateMatrix(size, obstacleRatio);
        Node start = new Node(0, 0);
        Node goal = new Node(size - 1, size - 1);

        // Hiển thị ma trận ban đầu
        System.out.println("Ma trận ban đầu:");
        MatrixGenerator.printMatrix(matrix, start, goal, null);

        while (true) {
            System.out.println("\nChọn thuật toán tìm đường:");
            System.out.println("1. BFS");
            System.out.println("2. DFS");
            System.out.println("3. A*");
            System.out.println("4. A* cải tiến");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = scanner.nextInt();

            PathFindingAlgorithm algorithm;
            boolean[][] path = new boolean[size][size];
            boolean pathFound = false;

            switch (choice) {
                case 1:
                    algorithm = new BFSAlgorithm();
                    pathFound = algorithm.findPathWithPathMatrix(matrix, start, goal, path);
                    break;
                case 2:
                    algorithm = new DFSAlgorithm();
                    pathFound = algorithm.findPathWithPathMatrix(matrix, start, goal, path);
                    break;
                case 3:
                    algorithm = new AStarAlgorithm();
                    pathFound = algorithm.findPathWithPathMatrix(matrix, start, goal, path);
                    break;
                case 4:
                    algorithm = new AStarBidirectionalAlgorithm();
                    pathFound = algorithm.findPathWithPathMatrix(matrix, start, goal, path);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    continue;
            }

            // Hiển thị kết quả
            if (pathFound) {
                System.out.println("Đường đi tìm thấy:");
                MatrixGenerator.printMatrix(matrix, start, goal, path);
                System.out.println("Độ phức tạp thời gian (số bước): " + algorithm.getTimeComplexity());
                System.out.println("Độ phức tạp không gian (bộ nhớ): " + algorithm.getSpaceComplexity());
            } else {
                System.out.println("Không tìm thấy đường đi.");
                System.out.println("Độ phức tạp thời gian (số bước): " + algorithm.getTimeComplexity());
                System.out.println("Độ phức tạp không gian (bộ nhớ): " + algorithm.getSpaceComplexity());
            }
        }
    }
}
