<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đặt hàng thành công</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="alert alert-success text-center py-5 shadow-sm bg-white">
            <h2 class="text-success mb-4">🎉 Đặt hàng thành công!</h2>
            <p class="fs-5">Cảm ơn bạn đã đặt hàng. Phương thức thanh toán: <strong>Thanh toán khi nhận hàng (COD)</strong>.</p>
            <p class="fs-5">Mã đơn hàng của bạn là: <strong class="text-danger">${orderId}</strong></p>
            
            <a href="${pageContext.request.contextPath}/home" class="btn btn-primary mt-4 px-4 py-2">
                Quay về Trang Chủ
            </a>
        </div>
    </div>
</body>
</html>