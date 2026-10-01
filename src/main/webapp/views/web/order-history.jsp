<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Lịch Sử Đặt Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .nav-pills .nav-link.active {
            background-color: #dc3545; /* Đổi màu tab đang chọn sang đỏ */
        }
        .nav-pills .nav-link {
            color: #333;
            font-weight: 500;
        }
    </style>
</head>
<body class="bg-light">
<div class="container mt-5 bg-white p-4 rounded shadow-sm">
    <h2 class="mb-4">Lịch sử đặt hàng của bạn</h2>

    <!-- Thanh menu lọc trạng thái -->
    <ul class="nav nav-pills mb-4 border-bottom pb-3 gap-2">
        <li class="nav-item">
            <a class="nav-link ${currentStatus == 'ALL' ? 'active' : ''}" href="?status=ALL">Tất cả</a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${currentStatus == 'Mới' ? 'active' : ''}" href="?status=Mới">Đơn mới</a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${currentStatus == 'Đã xác nhận' ? 'active' : ''}" href="?status=Đã xác nhận">Đã xác nhận</a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${currentStatus == 'Chuẩn bị hàng' ? 'active' : ''}" href="?status=Chuẩn bị hàng">Chuẩn bị hàng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${currentStatus == 'Vận chuyển' ? 'active' : ''}" href="?status=Vận chuyển">Vận chuyển</a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${currentStatus == 'Đang giao' ? 'active' : ''}" href="?status=Đang giao">Đang giao</a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${currentStatus == 'Đã giao' ? 'active' : ''}" href="?status=Đã giao">Đã giao</a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${currentStatus == 'Đã hủy' ? 'active' : ''}" href="?status=Đã hủy">Đã hủy</a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${currentStatus == 'Hoàn trả' ? 'active' : ''}" href="?status=Hoàn trả">Hoàn trả</a>
        </li>
    </ul>

    <!-- Bảng danh sách đơn hàng -->
    <c:choose>
        <c:when test="${empty orders}">
            <div class="alert alert-warning text-center py-4">
                Hiện tại không có đơn hàng nào ở trạng thái này!
            </div>
        </c:when>
        <c:otherwise>
            <div class="table-responsive">
                <table class="table table-hover align-middle border">
                    <thead class="table-dark">
                        <tr>
                            <th>Mã Đơn Hàng</th>
                            <th>Ngày Đặt</th>
                            <th>Thanh Toán</th>
                            <th>Địa Chỉ Giao Hàng</th>
                            <th>Trạng Thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${orders}">
                            <tr>
                                <td class="fw-bold text-primary">${o.orderId}</td>
                                <td><fmt:formatDate value="${o.orderDate}" pattern="dd/MM/yyyy HH:mm"/></td>
                                <td>${o.paymentMethod}</td>
                                <td>${o.address}</td>
                                <td>
                                    <!-- Hiển thị màu badge theo trạng thái -->
                                    <c:choose>
                                        <c:when test="${o.status == 'Mới'}">
                                            <span class="badge bg-primary">${o.status}</span>
                                        </c:when>
                                        <c:when test="${o.status == 'Đã hủy' or o.status == 'Hoàn trả'}">
                                            <span class="badge bg-danger">${o.status}</span>
                                        </c:when>
                                        <c:when test="${o.status == 'Đã giao'}">
                                            <span class="badge bg-success">${o.status}</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge bg-info text-dark">${o.status}</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
    
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/home" class="btn btn-secondary">Quay lại Trang Chủ</a>
    </div>
</div>
</body>
</html>