<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding: 40px 20px; text-align: center;">
    <h1 style="color: #28a745;">Chào mừng đến với Bảng Điều Khiển Quản Trị!</h1>
    <p style="font-size: 1.2em; color: #6c757d;">Hệ thống quản lý dữ liệu Web Cuối Kỳ</p>
    
    <div style="display: flex; justify-content: center; gap: 20px; margin-top: 40px;">
        <!-- Nút trỏ thẳng sang chức năng CRUD Video đã làm ở Câu 3 -->
        <a href="${pageContext.request.contextPath}/admin/videos" 
           style="padding: 20px 40px; background: #0d6efd; color: white; text-decoration: none; border-radius: 8px; font-weight: bold; font-size: 1.1em; box-shadow: 0 4px 6px rgba(0,0,0,0.1);">
           🎬 Quản lý Video
        </a>
        
        <a href="${pageContext.request.contextPath}/admin/categories" 
           style="padding: 20px 40px; background: #ffc107; color: black; text-decoration: none; border-radius: 8px; font-weight: bold; font-size: 1.1em; box-shadow: 0 4px 6px rgba(0,0,0,0.1);">
           📂 Quản lý Category
        </a>
        
        <a href="${pageContext.request.contextPath}/admin/users" 
           style="padding: 20px 40px; background: #198754; color: white; text-decoration: none; border-radius: 8px; font-weight: bold; font-size: 1.1em; box-shadow: 0 4px 6px rgba(0,0,0,0.1);">
           👥 Quản lý User
        </a>
    </div>
</div>