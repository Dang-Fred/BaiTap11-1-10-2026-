<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div style="padding: 20px; max-width: 600px; margin: 0 auto;">
    <h2>${video != null ? 'Cập nhật Video' : 'Thêm Video Mới'}</h2>
    
    <form action="${pageContext.request.contextPath}/admin/videos" method="post">
        <c:if test="${video != null}">
            <input type="hidden" name="isEdit" value="true">
        </c:if>
        
        <div style="margin-bottom: 10px;">
            <label>Video ID:</label><br>
            <input type="text" name="videoId" value="${video.videoId}" ${video != null ? 'readonly' : 'required'} style="width: 100%;">
        </div>
        <div style="margin-bottom: 10px;">
            <label>Title:</label><br>
            <input type="text" name="title" value="${video.title}" required style="width: 100%;">
        </div>
        <div style="margin-bottom: 10px;">
            <label>Poster (Tên file ảnh):</label><br>
            <input type="text" name="poster" value="${video.poster}" style="width: 100%;">
        </div>
        <div style="margin-bottom: 10px;">
            <label>Views:</label><br>
            <input type="number" name="views" value="${video.views != null ? video.views : 0}" style="width: 100%;">
        </div>
        <div style="margin-bottom: 10px;">
            <label>Description:</label><br>
            <textarea name="description" rows="4" style="width: 100%;">${video.description}</textarea>
        </div>
        <div style="margin-bottom: 10px;">
            <label>Category ID:</label><br>
            <input type="number" name="categoryId" value="${video.categoryId}" required style="width: 100%;">
        </div>
        <div style="margin-bottom: 10px;">
            <label>
                <input type="checkbox" name="active" ${video.active ? 'checked' : ''}> Hoạt động (Active)
            </label>
        </div>
        
        <button type="submit" style="padding: 10px 20px; background: #0d6efd; color: white; border: none; cursor: pointer;">Lưu Dữ Liệu</button>
        <a href="${pageContext.request.contextPath}/admin/videos" style="margin-left: 10px;">Hủy bỏ</a>
    </form>
</div>