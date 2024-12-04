# Complexity Time of UCS, A\*, BFS, and DFS

## 1. **Chi phí mở rộng trạng thái (State Expansion)**

- **BFS**: Tìm kiếm theo chiều rộng mở rộng tất cả các trạng thái ở mức độ hiện tại trước khi chuyển sang mức độ tiếp theo. Do không có yêu cầu về chi phí, mỗi trạng thái sẽ được xử lý một lần.
- **DFS**: Tìm kiếm theo chiều sâu mở rộng trạng thái theo chiều sâu, không cần phải tính đến chi phí, nên thời gian có thể ít hơn trong một số trường hợp (mặc dù không hiệu quả trong tìm kiếm không gian trạng thái lớn).
- **UCS**: Đảm bảo tìm kiếm theo chi phí thấp nhất, điều này đồng nghĩa với việc phải theo dõi tất cả các chi phí đường đi đã đi qua và lựa chọn trạng thái tiếp theo dựa trên chi phí này. Việc duy trì hàng đợi ưu tiên (priority queue) để lấy trạng thái có chi phí thấp nhất sẽ tốn thêm thời gian.
- **A\***: Tương tự UCS, nhưng có thêm hàm ước lượng (heuristic), giúp tìm kiếm nhanh hơn trong một số trường hợp, nhưng vẫn yêu cầu tính toán thêm để kết hợp chi phí thực tế và ước lượng.

## 2. **Sử dụng Hàng đợi Ưu tiên**

- **UCS và A\*** sử dụng hàng đợi ưu tiên để xử lý các trạng thái theo chi phí, điều này yêu cầu thao tác liên tục với hàng đợi, thêm và xóa các trạng thái có chi phí thấp nhất. Các thao tác này tốn thời gian tính toán, đặc biệt khi không gian trạng thái lớn.
- **BFS** và **DFS** không yêu cầu tổ chức trạng thái theo chi phí, điều này giúp chúng ít tốn tài nguyên hơn trong quá trình duyệt.

## 3. **Tìm kiếm theo chi phí thay vì chiều sâu hoặc chiều rộng**

- **UCS** và **A\*** phải xử lý nhiều trạng thái hơn vì chúng cần kiểm tra tất cả các chi phí tiềm năng, trong khi **BFS** chỉ cần di chuyển theo chiều rộng và **DFS** di chuyển theo chiều sâu mà không quan tâm đến chi phí.
- Điều này dẫn đến việc UCS và A\* có thể phải mở rộng nhiều nhánh hơn, làm tăng số lượng trạng thái được kiểm tra.

## 4. **Hàm Ước Lượng trong A\***

- **A\*** sử dụng một hàm ước lượng (heuristic) để ước tính chi phí từ một trạng thái đến đích. Tuy nhiên, nếu hàm này không chính xác hoặc không tối ưu, thuật toán sẽ phải kiểm tra nhiều trạng thái hơn để tìm ra con đường tốt nhất, dẫn đến thời gian tìm kiếm lâu hơn.

## Kết luận:

**UCS** và **A\*** cần thời gian nhiều hơn vì chúng phải tính toán chi phí của từng bước đi, xử lý các trạng thái theo chi phí, và có thể phải kiểm tra một số lượng lớn các trạng thái trong không gian trạng thái. Ngược lại, **BFS** và **DFS** không yêu cầu các phép tính chi phí, làm cho chúng nhanh hơn trong các bài toán đơn giản nhưng có thể không hiệu quả trong tìm kiếm tối ưu.
