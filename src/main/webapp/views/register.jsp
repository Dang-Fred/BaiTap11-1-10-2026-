<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
    <style>
        .auth-container { max-width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; background: #fff; }
        .auth-container h2 { text-align: center; color: #198754; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: bold; }
        .form-group input { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn-submit { width: 100%; padding: 10px; background: #198754; color: white; border: none; border-radius: 4px; cursor: pointer; font-weight: bold; }
        .btn-submit:hover { background: #157347; }
        .link-login { display: block; text-align: center; margin-top: 15px; }
    </style>
</head>
<body>
    <div class="auth-container">
        <h2>Đăng Ký</h2>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <label>Tên đăng nhập</label>
                <input type="text" name="username" required>
            </div>
            <div class="form-group">
                <label>Mật khẩu</label>
                <input type="password" name="password" required minlength="6">
            </div>
            <div class="form-group">
                <label>Họ và tên</label>
                <input type="text" name="fullname" required>
            </div>
            <div class="form-group">
                <label>Email (Dùng để nhận OTP)</label>
                <input type="email" name="email" required>
            </div>
            <button type="submit" class="btn-submit">Đăng ký</button>
        </form>
        <a href="${pageContext.request.contextPath}/login" class="link-login">Đã có tài khoản? Đăng nhập</a>
    </div>
</body>
</html>