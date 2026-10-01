<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Giỏ Hàng Của Bạn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5 bg-white p-4 rounded shadow-sm">
    <h2 class="mb-4">Giỏ hàng của bạn</h2>
    
    <c:if test="${empty sessionScope.cart}">
        <div class="alert alert-info text-center py-4">
            <h5>Giỏ hàng của bạn đang trống!</h5>
            <p class="mb-0">Hãy quay lại trang chủ để chọn những video yêu thích.</p>
        </div>
        <div class="text-center">
            <a href="${pageContext.request.contextPath}/home" class="btn btn-primary mt-2">Quay lại Trang Chủ</a>
        </div>
    </c:if>

    <c:if test="${not empty sessionScope.cart}">
        <table class="table table-hover align-middle">
            <thead class="table-dark">
                <tr>
                    <th scope="col" style="width: 15%">Hình ảnh</th>
                    <th scope="col" style="width: 40%">Tên Video</th>
                    <th scope="col" style="width: 25%">Số lượng</th>
                    <th scope="col" style="width: 20%" class="text-center">Hành động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${sessionScope.cart}">
                    <c:set var="item" value="${entry.value}" />
                    <tr>
                        <td>
                            <img src="${item.video.poster}" alt="${item.video.title}" class="img-fluid rounded" style="max-height: 80px; object-fit: cover;">
                        </td>
                        <td class="fw-semibold">${item.video.title}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart/update" method="post" class="d-flex align-items-center m-0">
                                <input type="hidden" name="videoId" value="${item.video.videoId}">
                                <div class="input-group input-group-sm w-75">
                                    <input type="number" name="quantity" value="${item.quantity}" min="1" max="5" class="form-control text-center">
                                    <button type="submit" class="btn btn-outline-success">Cập nhật</button>
                                </div>
                            </form>
                        </td>
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/cart/remove?id=${item.video.videoId}" 
                               class="btn btn-sm btn-danger px-3"
                               onclick="return confirm('Bạn có chắc chắn muốn xóa video này khỏi giỏ?');">
                               Xóa
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="mt-4 pt-3 border-top">
            <h4 class="text-success mb-3">Thanh toán khi nhận hàng (COD)</h4>
            
            <!-- Kiểm tra xem đã đăng nhập chưa -->
            <c:choose>
                <c:when test="${not empty sessionScope.account}">
                    <!-- Form thanh toán -->
                    <form action="${pageContext.request.contextPath}/checkout" method="post" class="w-50">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Địa chỉ giao hàng chi tiết:</label>
                            <textarea name="address" class="form-control" rows="2" required placeholder="Nhập số nhà, tên đường, phường/xã, quận/huyện..."></textarea>
                        </div>
                        
                        <div class="d-flex justify-content-between align-items-center">
                            <a href="${pageContext.request.contextPath}/home" class="btn btn-outline-secondary">Tiếp tục chọn Video</a>
                            <button type="submit" class="btn btn-success px-5 py-2 fw-bold">Xác nhận Đặt hàng (COD)</button>
                        </div>
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-warning">
                        Bạn cần <strong>đăng nhập</strong> để có thể thanh toán đơn hàng. <a href="${pageContext.request.contextPath}/login">Đăng nhập ngay</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </c:if>
</div>

</body>
</html>