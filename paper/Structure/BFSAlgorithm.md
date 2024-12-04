
# Giải Thích Code: BFSAlgorithm

## Giới Thiệu
Đoạn mã này triển khai thuật toán tìm đường theo cách duyệt đồ thị theo chiều rộng (Breadth-First Search - BFS). 
Lớp `BFSAlgorithm` triển khai giao diện `PathFindingAlgorithm` để thực hiện tìm kiếm đường đi trong một ma trận (matrix) hai chiều.

## Chi Tiết Các Phương Thức
### Phương Thức `findPath`
Phương thức `findPath` kiểm tra nếu có đường đi từ điểm bắt đầu (`start`) đến điểm đích (`goal`) trong ma trận `matrix`. 
Phương thức này trả về `true` nếu tìm thấy đường đi, ngược lại trả về `false`. Logic tìm kiếm đường đi được giữ nguyên bằng cách gọi đến 
`findPathWithPathMatrix` với một ma trận `path` để theo dõi các điểm đã đi qua.

### Phương Thức `findPathWithPathMatrix`
Đây là phương thức chính sử dụng thuật toán BFS để tìm đường đi từ điểm bắt đầu (`start`) đến điểm đích (`goal`).

1. **Khởi tạo**: Phương thức khởi tạo các biến `rows`, `cols` là số hàng và số cột của `matrix`. Tạo ma trận `visited` để đánh dấu các ô đã duyệt qua và 
   hàng đợi `queue` để lưu các nút sẽ duyệt. Biến `parent` lưu thông tin cha của mỗi ô để có thể truy ngược lại đường đi.

2. **Duyệt BFS**: Thực hiện duyệt BFS bằng cách lấy nút hiện tại từ `queue`. Nếu tọa độ của nút hiện tại trùng với tọa độ của `goal`, thì gọi phương thức `tracePath` để đánh dấu đường đi trong ma trận `path`, sau đó trả về `true`.

3. **Kiểm tra và Di Chuyển**: Phương thức di chuyển đến các ô lân cận theo bốn hướng (lên, xuống, trái, phải). Nếu tọa độ mới hợp lệ (nằm trong ma trận), ô không phải là chướng ngại vật (`matrix[newX][newY] != 1`), và ô chưa được thăm, thì thêm nút mới vào `queue`, đánh dấu `visited`, và ghi lại `parent` của ô.

### Phương Thức `tracePath`
Phương thức `tracePath` đánh dấu đường đi từ điểm `goal` về điểm bắt đầu bằng cách duyệt ngược từ `goal` về `start` qua thông tin cha lưu trong `parent`. 
Mỗi ô trên đường đi được đánh dấu `true` trong ma trận `path`.

## Kết Luận
Lớp `BFSAlgorithm` cung cấp một cách tiếp cận hiệu quả để tìm kiếm đường đi ngắn nhất trong ma trận hai chiều sử dụng thuật toán BFS.
