<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div style="padding: 20px;">
    <h2>Quản lý Video</h2>
    <a href="${pageContext.request.contextPath}/admin/videos/add" style="padding: 5px 15px; background: #28a745; color: white; text-decoration: none; border-radius: 4px;">+ Thêm Video Mới</a>
    
    <table border="1" style="width: 100%; margin-top: 15px; border-collapse: collapse; text-align: center;">
        <tr style="background: #e9ecef;">
            <th>Video ID</th>
            <th>Title</th>
            <th>Poster</th>
            <th>Views</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        <c:forEach items="${videos}" var="v">
            <tr>
                <td>${v.videoId}</td>
                <td>${v.title}</td>
                <td>${v.poster}</td>
                <td>${v.views}</td>
                <td>${v.active ? 'Hoạt động' : 'Đã khóa'}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/videos/edit?id=${v.videoId}" style="color: blue;">Sửa</a> |
                    <a href="${pageContext.request.contextPath}/admin/videos/delete?id=${v.videoId}" style="color: red;" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <!-- Khối Phân Trang -->
    <div style="margin-top: 20px; text-align: center;">
        <c:forEach begin="1" end="${endPage}" var="i">
            <a href="${pageContext.request.contextPath}/admin/videos?page=${i}" 
               style="padding: 5px 10px; border: 1px solid #ccc; margin: 0 2px; text-decoration: none; 
               ${currentPage == i ? 'background: #0d6efd; color: white;' : 'color: black;'}">
               ${i}
            </a>
        </c:forEach>
    </div>
</div>