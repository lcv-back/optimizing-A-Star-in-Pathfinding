
# Giải Thích Code: AStarAlgorithm

## Giới Thiệu
Đoạn mã này triển khai thuật toán tìm đường A* (A-star), một thuật toán phổ biến trong tìm kiếm đường đi ngắn nhất với chi phí tối ưu trong một ma trận hai chiều.

## Chi Tiết Các Phương Thức
### Phương Thức `findPath`
Phương thức `findPath` kiểm tra nếu có đường đi từ điểm bắt đầu (`start`) đến điểm đích (`goal`) trong ma trận `matrix`. 
Phương thức này trả về `true` nếu tìm thấy đường đi, ngược lại trả về `false`. Tương tự như `BFSAlgorithm`, logic của phương thức 
này được thực hiện trong `findPathWithPathMatrix`.

### Phương Thức `findPathWithPathMatrix`
Phương thức này triển khai thuật toán A* để tìm đường đi từ điểm bắt đầu (`start`) đến điểm đích (`goal`).

1. **Khởi tạo**: Tạo các biến `rows` và `cols` để xác định kích thước ma trận. Sử dụng ma trận `visited` để đánh dấu các ô đã thăm và hàng đợi ưu tiên 
   `openList` (ưu tiên các nút có chi phí thấp nhất). Mảng `parent` lưu thông tin nút cha của mỗi ô.

2. **Thiết lập Ban Đầu**: Chi phí (`cost`) của nút bắt đầu được đặt bằng giá trị ước lượng từ `start` đến `goal` (sử dụng hàm `heuristic`), sau đó thêm `start` vào `openList`.

3. **Duyệt A\***: Lấy nút có chi phí thấp nhất từ `openList`. Nếu nút hiện tại trùng với `goal`, gọi phương thức `tracePath` để đánh dấu đường đi trong `path` và trả về `true`.

4. **Kiểm tra và Di Chuyển**: Với mỗi ô lân cận (lên, xuống, trái, phải), nếu tọa độ hợp lệ, ô không phải chướng ngại vật và chưa được thăm, thì tạo `neighbor`, đặt chi phí của nó, và thêm vào `openList`. Đồng thời, lưu thông tin cha của `neighbor` trong `parent`.

### Phương Thức `heuristic`
Phương thức `heuristic` ước lượng khoảng cách từ một nút đến nút `goal` bằng cách sử dụng khoảng cách Manhattan, là tổng của các khoảng cách hàng và cột giữa hai điểm.

### Phương Thức `tracePath`
Phương thức `tracePath` đánh dấu đường đi từ điểm `goal` về điểm bắt đầu thông qua `parent`. Mỗi ô trên đường đi được đánh dấu `true` trong ma trận `path`.

## Kết Luận
Lớp `AStarAlgorithm` sử dụng thuật toán A* để tìm kiếm đường đi ngắn nhất trong ma trận, kết hợp giữa duyệt đồ thị và heuristic để tối ưu hóa chi phí.
