<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập hệ thống</title>
    <style>
        .auth-container { max-width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; background: #fff; }
        .auth-container h2 { text-align: center; color: #0d6efd; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: bold; }
        .form-group input { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn-submit { width: 100%; padding: 10px; background: #0d6efd; color: white; border: none; border-radius: 4px; cursor: pointer; font-weight: bold; }
        .btn-submit:hover { background: #0b5ed7; }
        .alert { padding: 10px; margin-bottom: 15px; border-radius: 4px; text-align: center; }
        .alert-error { background: #f8d7da; color: #842029; }
        .alert-success { background: #d1e7dd; color: #0f5132; }
        .link-register { display: block; text-align: center; margin-top: 15px; }
    </style>
</head>
<body>
    <div class="auth-container">
        <h2>Đăng Nhập</h2>
        
        <c:if test="${param.error == 'invalid'}">
            <div class="alert alert-error">Sai tên đăng nhập hoặc mật khẩu!</div>
        </c:if>
        <c:if test="${param.error == 'not_admin'}">
            <div class="alert alert-error">Bạn không có quyền truy cập trang Quản trị! Vui lòng đăng nhập lại.</div>
        </c:if>
        <c:if test="${param.msg == 'success'}">
            <div class="alert alert-success">Kích hoạt tài khoản thành công! Hãy đăng nhập.</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label>Tên đăng nhập</label>
                <input type="text" name="username" required>
            </div>
            <div class="form-group">
                <label>Mật khẩu</label>
                <input type="password" name="password" required>
            </div>
            <button type="submit" class="btn-submit">Đăng nhập</button>
        </form>
        
        <a href="${pageContext.request.contextPath}/register" class="link-register">Chưa có tài khoản? Đăng ký ngay</a>
    </div>
</body>
</html>