
# MatrixGenerator.md

## 🗒️ Giải thích đoạn mã MatrixGenerator.java

Đoạn mã trên được chia thành hai phần chính: `generateMatrix` và `printMatrix`.

### 1. Phương thức `generateMatrix`:
- **Mục đích**: Tạo một ma trận vuông có kích thước `size x size` với các ô có thể chứa chướng ngại vật (được đại diện bởi số `1`).
- **Các bước thực hiện**:
  - Khởi tạo một mảng 2D `matrix` với kích thước cho trước.
  - Tính tổng số lượng chướng ngại vật cần đặt vào ma trận dựa trên tỷ lệ `obstacleRatio`.
  - Dùng vòng lặp để đặt ngẫu nhiên chướng ngại vật vào ma trận. Các ô được kiểm tra để đảm bảo không trùng lặp và không đặt chướng ngại vật ở ô đầu (`0,0`) hoặc ô cuối (`size-1, size-1`).
- **Kết quả**: Trả về ma trận có các chướng ngại vật được đặt ngẫu nhiên.

### 2. Phương thức `printMatrix`:
- **Mục đích**: In ra ma trận kèm theo điểm bắt đầu (`start`), điểm đích (`goal`), và đường đi (`path`) nếu có.
- **Các bước thực hiện**:
  - Duyệt qua từng phần tử của ma trận.
  - In ký tự đại diện cho:
    - `S` cho điểm bắt đầu.
    - `G` cho điểm đích.
    - `X` cho chướng ngại vật.
    - `*` cho các ô thuộc đường đi.
    - `-` cho các ô trống không có chướng ngại vật và không thuộc đường đi.
- **Kết quả**: Hiển thị ma trận với các ký hiệu mô tả cấu trúc, giúp dễ dàng hình dung vị trí của chướng ngại vật, đường đi, và điểm quan trọng.
