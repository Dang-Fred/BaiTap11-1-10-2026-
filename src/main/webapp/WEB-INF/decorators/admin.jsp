<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f6f9; }
        /* Header admin màu đen để phân biệt với trang User */
        header { background: #212529; padding: 15px 30px; display: flex; justify-content: space-between; align-items: center; border-bottom: 3px solid #dc3545; }
        header a { color: #f8f9fa; text-decoration: none; margin-right: 20px; font-weight: bold; }
        header a:hover { color: #dc3545; }
        footer { background: #212529; color: white; text-align: center; padding: 15px; position: fixed; bottom: 0; width: 100%; border-top: 2px solid #495057; }
        main { padding: 30px; min-height: 500px; padding-bottom: 70px; }
    </style>
</head>
<body>
    <header>
        <div>
            <a href="${pageContext.request.contextPath}/admin/home" style="color: #dc3545; font-size: 1.1em;">ADMIN PANEL</a>
            <a href="${pageContext.request.contextPath}/admin/users">Quản lý User</a>
            <a href="${pageContext.request.contextPath}/admin/categories">Quản lý Category</a>
            <a href="${pageContext.request.contextPath}/admin/videos">Quản lý Video</a>
        </div>
        
        
 
        <div>
            <a href="${pageContext.request.contextPath}/" style="font-weight: normal; font-size: 0.9em;">Trang ngoài</a>
            <span style="color: #28a745; font-weight: bold;">Admin: ${sessionScope.user.fullname}</span>
        </div>
    </header>

    <main>
        <sitemesh:write property='body'/>
    </main>

    <footer>
        Họ tên: Đặng Nhật Phúc - MSSV: [24110304] - Mã đề: 3
    </footer>
</body>
</html>