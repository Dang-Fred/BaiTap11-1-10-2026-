<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div style="padding: 40px 20px;">
    <!-- Bảng hiển thị thông tin bám sát cấu trúc đề thi -->
    <table border="1" style="width: 100%; max-width: 800px; margin: 0 auto; border-collapse: collapse; font-family: Arial, sans-serif; font-size: 16px;">
        <!-- Dòng 1: Chứa Poster và các thông tin cơ bản -->
        <tr>
            <!-- Cột trái: Poster Ảnh -->
            <td style="width: 40%; text-align: center; vertical-align: middle; padding: 15px;">
                <c:choose>
                    <c:when test="${not empty video.poster}">
                        <img src="${pageContext.request.contextPath}/uploads/${video.poster}" alt="[poster]" style="max-width: 100%; height: auto; border-radius: 4px;">
                    </c:when>
                    <c:otherwise>
                        <div style="width: 100%; height: 300px; background-color: #f8f9fa; display: flex; align-items: center; justify-content: center; border: 1px solid #ddd;">
                            <span style="color: #6c757d;">[poster]</span>
                        </div>
                    </c:otherwise>
                </c:choose>
            </td>
            
            <!-- Cột phải: Tiêu đề, Mã, Category, View, Share, Like & THÊM GIỎ HÀNG -->
            <td style="width: 60%; vertical-align: top; padding: 20px; line-height: 2;">
                <div><strong>Tiêu đề:</strong> ${video.title}</div>
                <div><strong>Mã video:</strong> ${video.videoId}</div>
                <div><strong>Category name:</strong> ${categoryName}</div>
                <div><strong>View:</strong> ${video.views}</div>
                <div><strong>Share(${shares})</strong></div>
                <div><strong>Like(${likes})</strong></div>
                
                <!-- BẮT ĐẦU: Form Thêm vào giỏ hàng -->
                <div style="margin-top: 15px; border-top: 1px dashed #ccc; padding-top: 15px;">
                    <form action="${pageContext.request.contextPath}/cart/add" method="post" style="display: flex; align-items: center; gap: 10px; margin: 0;">
                        <input type="hidden" name="videoId" value="${video.videoId}" />
                        
                        <label for="quantity" style="font-weight: bold; margin: 0;">Số lượng:</label>
                        <!-- Giới hạn min=1, max=5 -->
                        <input type="number" id="quantity" name="quantity" value="1" min="1" max="5" style="width: 60px; padding: 5px; text-align: center; border: 1px solid #ccc; border-radius: 4px;" />
                        
                        <button type="submit" style="padding: 7px 15px; background-color: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; font-weight: bold;">
                            Thêm vào giỏ
                        </button>
                    </form>
                </div>
                <!-- KẾT THÚC: Form Thêm vào giỏ hàng -->
            </td>
        </tr>
        
        <!-- Dòng 2: Chứa Description (Gộp 2 cột lại) -->
        <tr>
            <td colspan="2" style="padding: 20px; text-align: justify; line-height: 1.6;">
                <strong>description:</strong> <br>
                ${video.description}
            </td>
        </tr>
    </table>
</div>