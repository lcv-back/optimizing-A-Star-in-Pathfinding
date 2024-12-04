# Mô tả cách hoạt động của thuật toán A\* trong ma trận có vật cản

Đoạn mã trên triển khai thuật toán A\* (A-star) để tìm đường đi trong ma trận có vật cản. Thuật toán này sử dụng một ma trận 2D (`matrix`), trong đó mỗi ô có thể là một ô trống (được đánh dấu bằng `0`) hoặc vật cản (được đánh dấu bằng `1`). Dưới đây là mô tả chi tiết về cách hoạt động của mã nguồn này.

## Các lớp chính:

- **`Node`**: Lớp đại diện cho một ô trong ma trận với các thuộc tính như vị trí (x, y), chi phí (`cost`), và con trỏ tới ô cha (`parent`) để truy ngược lại đường đi khi thuật toán hoàn thành.
- **`AStarAlgorithm`**: Lớp triển khai thuật toán A\* để tìm đường đi trong ma trận.

## Các bước hoạt động chính:

### 1. Khởi tạo thuật toán A\*

- Phương thức `findPath` sẽ gọi `findPathWithPathMatrix` với ma trận và các nút bắt đầu (`start`) và đích (`goal`).
- Một ma trận `visited` để theo dõi các ô đã được thăm.
- Một ma trận `path` để đánh dấu các ô có trong đường đi (được sử dụng để trực quan hóa hoặc kiểm tra đường đi).
- Một danh sách mở `openList` (sử dụng `PriorityQueue`) để lưu trữ các nút sẽ được duyệt. Các nút trong danh sách này được sắp xếp theo chi phí (`cost`), đảm bảo rằng thuật toán luôn chọn nút có chi phí thấp nhất.

### 2. Thuật toán tìm kiếm đường đi (A\*)

- **Bước 1**: Khởi tạo nút bắt đầu (`start`) với chi phí ban đầu được tính bằng hàm heuristic. Hàm `heuristic` tính toán khoảng cách ước tính từ một ô hiện tại đến ô đích, dùng khoảng cách Manhattan (đơn giản là tổng sự khác biệt tuyệt đối giữa các chỉ số hàng và cột của hai ô).
- **Bước 2**: Đưa nút bắt đầu vào danh sách mở (`openList`).

### 3. Lặp qua các nút trong danh sách mở

- **Bước 3**: Trong vòng lặp `while`, thuật toán lấy nút có chi phí thấp nhất từ `openList` (dùng phương thức `poll()` của `PriorityQueue`). Đây là nút mà thuật toán sẽ kiểm tra tiếp.
- **Bước 4**: Nếu nút này đã được thăm, tiếp tục vòng lặp.
- **Bước 5**: Nếu nút hiện tại là ô đích (`goal`), thuật toán sẽ dừng và truy ngược lại đường đi từ ô đích đến ô bắt đầu thông qua các ô cha (sử dụng phương thức `tracePath`).

### 4. Kiểm tra các ô lân cận

- **Bước 6**: Thuật toán duyệt qua các ô lân cận của ô hiện tại. Các ô lân cận được xác định bằng cách cộng với các hướng di chuyển cố định (lên, xuống, trái, phải) vào vị trí hiện tại (x, y).
- **Bước 7**: Nếu ô lân cận nằm trong phạm vi của ma trận, không phải là vật cản (`matrix[newX][newY] != 1`), và chưa được thăm, thuật toán tính toán chi phí tổng cộng của ô lân cận:
  - Chi phí (`cost`) của ô này là tổng của chi phí hiện tại cộng thêm 1 (do đi sang ô lân cận) cộng với giá trị heuristic (ước tính từ ô lân cận đến ô đích).
- **Bước 8**: Ô lân cận được thêm vào danh sách mở và được cập nhật với chi phí và cha của nó là ô hiện tại.

### 5. Kết thúc thuật toán

- **Bước 9**: Nếu danh sách mở trống và không tìm thấy đường đi đến ô đích, thuật toán sẽ trả về `false`, báo hiệu không có đường đi hợp lệ.
- **Bước 10**: Nếu tìm thấy đường đi đến ô đích, phương thức `tracePath` sẽ được gọi để truy ngược lại đường đi từ ô đích về ô bắt đầu, đánh dấu các ô trong đường đi bằng cách cập nhật ma trận `path`.

## Các phương thức phụ trợ:

- **`heuristic(Node a, Node b)`**: Hàm heuristic sử dụng khoảng cách Manhattan giữa hai ô `a` và `b` làm ước tính chi phí còn lại từ ô hiện tại đến ô đích.
- **`tracePath(boolean[][] path, Node[][] parent, Node goal)`**: Hàm này được gọi khi thuật toán tìm thấy ô đích. Nó lần ngược qua các nút cha (parent) của mỗi ô từ ô đích đến ô bắt đầu để đánh dấu đường đi trong ma trận `path`.

## Tổng quan về cách hoạt động:

1. Thuật toán A\* khởi tạo với ô bắt đầu và đích, sau đó duyệt qua các ô trong ma trận dựa trên chi phí thực tế cộng với ước tính chi phí còn lại.
2. Thuật toán sẽ ưu tiên các ô có tổng chi phí (chi phí thực tế cộng với chi phí ước tính) thấp nhất, do đó đảm bảo tìm được đường đi ngắn nhất nếu tồn tại.
3. Các ô vật cản sẽ không được duyệt qua, giúp đảm bảo thuật toán không đi vào vùng bị cản trở.
   """
