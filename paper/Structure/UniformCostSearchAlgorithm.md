
# Giải Thích Code: UniformCostSearchAlgorithm

## Giới Thiệu
Đoạn mã này triển khai thuật toán tìm đường theo chi phí đồng đều (Uniform Cost Search - UCS), một biến thể của thuật toán Dijkstra, 
được sử dụng để tìm đường đi với chi phí thấp nhất trong một ma trận hai chiều.

## Chi Tiết Các Phương Thức
### Phương Thức `findPath`
Phương thức `findPath` kiểm tra nếu có đường đi từ điểm bắt đầu (`start`) đến điểm đích (`goal`) trong ma trận `matrix`. 
Phương thức này trả về `true` nếu tìm thấy đường đi, ngược lại trả về `false`. Logic tìm kiếm được thực hiện trong phương thức 
`findPathWithPathMatrix`.

### Phương Thức `findPathWithPathMatrix`
Phương thức này triển khai thuật toán UCS để tìm đường đi từ điểm bắt đầu (`start`) đến điểm đích (`goal`).

1. **Khởi tạo**: Phương thức khởi tạo các biến `rows` và `cols` để xác định kích thước ma trận. Sử dụng ma trận `visited` để đánh dấu các ô đã duyệt, 
   hàng đợi ưu tiên `openList` để lưu các nút sẽ duyệt (ưu tiên nút có chi phí thấp nhất), và mảng `parent` để lưu thông tin cha của mỗi ô.

2. **Thiết lập Ban Đầu**: Thiết lập chi phí (`cost`) của `start` là `0` và thêm `start` vào `openList`.

3. **Duyệt UCS**: Trong khi `openList` không rỗng, lấy nút có chi phí thấp nhất từ hàng đợi. Nếu tọa độ của nút hiện tại là đích (`goal`), 
   gọi phương thức `tracePath` để đánh dấu đường đi trong `path` và trả về `true`.

4. **Kiểm tra và Di Chuyển**: Đối với mỗi ô lân cận (lên, xuống, trái, phải), nếu tọa độ hợp lệ, ô không phải là chướng ngại vật (`matrix[newX][newY] != 1`), 
   và chưa được thăm, thì tạo `neighbor`, đặt chi phí cho `neighbor` bằng chi phí của `current` cộng thêm 1, và thêm vào `openList`. Đồng thời, lưu cha của `neighbor` trong `parent`.

### Phương Thức `tracePath`
Phương thức `tracePath` đánh dấu đường đi từ điểm đích `goal` về điểm bắt đầu bằng cách duyệt ngược thông qua `parent`. Mỗi ô trên đường đi được đánh dấu `true` trong ma trận `path`.

## Kết Luận
Lớp `UniformCostSearchAlgorithm` sử dụng thuật toán tìm kiếm chi phí đồng đều (UCS) để tìm đường đi ngắn nhất trong ma trận với chi phí tối ưu.
