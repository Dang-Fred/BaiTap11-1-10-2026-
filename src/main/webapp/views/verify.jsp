<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xác nhận mã OTP</title>
    <style>
        .auth-container { max-width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; background: #fff; text-align: center; }
        .auth-container h2 { color: #ffc107; }
        .form-group { margin-bottom: 15px; text-align: left; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: bold; }
        .form-group input { width: 100%; padding: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; font-size: 1.2em; text-align: center; letter-spacing: 5px; }
        .btn-submit { width: 100%; padding: 10px; background: #ffc107; color: #000; border: none; border-radius: 4px; cursor: pointer; font-weight: bold; }
        .btn-submit:hover { background: #e0a800; }
        .alert-error { background: #f8d7da; color: #842029; padding: 10px; border-radius: 4px; margin-bottom: 15px; }
        p.info-text { color: #555; font-size: 0.9em; margin-bottom: 20px; }
    </style>
</head>
<body>
    <div class="auth-container">
        <h2>Xác Thực Tài Khoản</h2>
        <p class="info-text">Một mã OTP gồm 6 chữ số đã được gửi đến Email của bạn.<br>Vui lòng kiểm tra hộp thư đến (hoặc thư mục Spam).</p>
        
        <c:if test="${not empty error}">
            <div class="alert-error">${error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/verify-otp" method="post">
            <div class="form-group">
                <input type="text" name="otp" required maxlength="6" placeholder="------" autocomplete="off">
            </div>
            <button type="submit" class="btn-submit">Xác nhận</button>
        </form>
    </div>
</body>
</html>