<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f8f9fa; }
        header { background: #0d6efd; padding: 15px 30px; display: flex; justify-content: space-between; align-items: center; }
        header a { color: white; text-decoration: none; margin-right: 20px; font-weight: bold; }
        header a:hover { text-decoration: underline; }
        footer { background: #212529; color: white; text-align: center; padding: 15px; position: fixed; bottom: 0; width: 100%; }
        main { padding: 30px; min-height: 500px; padding-bottom: 70px; }
    </style>
</head>
<body>
    <header>
        <div>
            <a href="${pageContext.request.contextPath}/home">Trang Chủ</a>
            <a href="${pageContext.request.contextPath}/products">Sản phẩm</a>
        </div>
        
        <div>
    <c:choose>
        <%-- Nếu session có tồn tại biến 'account' (Đã đăng nhập) --%>
        <c:when test="${not empty sessionScope.account}">
            <span style="color: white; font-weight: bold; margin-right: 15px;">
                Xin chào, ${sessionScope.account.username}!
            </span>
            <a href="${pageContext.request.contextPath}/logout" 
               style="padding: 5px 15px; background: #dc3545; color: white; text-decoration: none; border-radius: 4px;">
               Đăng xuất
            </a>
        </c:when>
        
        <%-- Nếu session trống (Chưa đăng nhập) --%>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/login" 
               style="padding: 5px 15px; background: white; color: #0d6efd; text-decoration: none; border-radius: 4px; font-weight: bold;">
               Đăng nhập
            </a>
        </c:otherwise>
    </c:choose>
</div>
    </header>

    <main>
        <sitemesh:write property='body'/>
    </main>

    <footer>
        Họ tên: Đặng Nhật Phúc - MSSV: 24110304 - Mã đề: 3
    </footer>
</body>
</html>