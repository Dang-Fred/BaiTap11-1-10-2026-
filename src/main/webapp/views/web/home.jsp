<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div style="padding: 30px;">
    
    <!-- HEADER BỔ SUNG: Chứa nút Giỏ hàng góc phải -->
    <div style="display: flex; justify-content: flex-end; margin-bottom: 20px;">
        <a href="${pageContext.request.contextPath}/cart" style="display: inline-flex; align-items: center; text-decoration: none; padding: 10px 20px; background-color: #ffc107; color: #333; font-weight: bold; border-radius: 5px; position: relative; border: 1px solid #d39e00; transition: 0.3s;">
            <!-- Icon Cart SVG -->
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" style="margin-right: 8px;" viewBox="0 0 16 16">
                <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
            </svg>
            Giỏ hàng
            
            <!-- Huy hiệu đếm số lượng (Chỉ hiện khi > 0) -->
            <c:if test="${not empty sessionScope.cartTotalItems and sessionScope.cartTotalItems > 0}">
                <span style="position: absolute; top: -10px; right: -10px; background-color: #dc3545; color: white; padding: 3px 8px; border-radius: 50%; font-size: 13px;">
                    ${sessionScope.cartTotalItems}
                </span>
            </c:if>
        </a>
    </div>
    <!-- KẾT THÚC HEADER -->

    <!-- Khối Câu 5: Menu hiển thị Category và Số lượng Video -->
    <div style="margin-bottom: 20px; padding: 15px; border: 1px solid #ddd; background-color: #f8f9fa;">
        <h4 style="margin-top: 0; color: #333;">Lọc theo danh mục:</h4>
        <div style="display: flex; gap: 15px; flex-wrap: wrap;">
            
            <c:forEach items="${categoryCounts}" var="cat">
                <a href="${pageContext.request.contextPath}/home?categoryId=${cat[0]}"
                   style="text-decoration: none; padding: 8px 15px; background: ${categoryId == cat[0] ? '#dc3545' : '#0d6efd'}; color: white; border-radius: 5px; font-weight: bold; transition: 0.3s;">
                    <!-- cat[1] là Tên Category, cat[2] là Số lượng Video -->
                    ${cat[1]} 
                    <span style="background: white; color: black; padding: 2px 8px; border-radius: 50%; font-size: 0.9em; margin-left: 5px;">
                        ${cat[2]}
                    </span>
                </a>
            </c:forEach>
            
        </div>
    </div>
    
    <!-- Bảng chính bám sát cấu trúc đề bài -->
    <table border="1" style="width: 100%; border-collapse: collapse; text-align: left; font-family: Arial, sans-serif;">
        
        <!-- Hàng 1: Tên Category và Tổng số Video -->
        <tr style="background-color: #f8f9fa;">
            <th colspan="3" style="padding: 10px; font-size: 18px;">
                ${categoryName} (${totalVideos})
            </th>
        </tr>
        
        <!-- Hàng 2: Chỉ hiển thị hình ảnh Poster -->
        <tr>
            <c:forEach items="${videos}" var="v">
                <td style="width: 33.33%; padding: 10px; text-align: center; border: 1px solid black;">
                    <div style="margin-bottom: 5px; color: #666;">[poster]</div>
                    <c:choose>
                        <c:when test="${not empty v.poster}">
                            <img src="${pageContext.request.contextPath}/uploads/${v.poster}" alt="poster" style="max-width: 100%; height: 200px; object-fit: cover;">
                        </c:when>
                        <c:otherwise>
                            <div style="width: 100%; height: 200px; background: #eee; display: flex; align-items: center; justify-content: center;">No Image</div>
                        </c:otherwise>
                    </c:choose>
                </td>
            </c:forEach>
            <!-- Xử lý lỗi giao diện nếu trang cuối có ít hơn 3 video -->
            <c:forEach begin="${videos.size() + 1}" end="3">
                <td style="width: 33.33%; border: 1px solid black;"></td>
            </c:forEach>
        </tr>
        
        <!-- Hàng 3: Chỉ hiển thị thông tin chi tiết -->
        <tr>
            <c:forEach items="${videos}" var="v">
                <td style="padding: 10px; border: 1px solid black; vertical-align: top; line-height: 1.8;">
                    <div><strong>Tiêu đề:</strong> ${v.title}</div>
                    <div><strong>Mã video:</strong> ${v.videoId}</div>
                    <div><strong>Category name:</strong> ${categoryName}</div>
                    <div><strong>View:</strong> ${v.views}</div>
                    <div><strong>Share(${sharesMap[v.videoId]})</strong></div>
                    <div><strong>Like(${likesMap[v.videoId]})</strong></div>
                    
                    <!-- NÚT BẤM CHUYỂN SANG CÂU 3 ĐƯỢC THÊM VÀO ĐÂY -->
                    <div style="margin-top: 15px; text-align: center;">
                        <a href="${pageContext.request.contextPath}/video/detail?id=${v.videoId}" 
                           style="padding: 5px 15px; background-color: #198754; color: white; text-decoration: none; border-radius: 4px; font-weight: bold; font-size: 0.9em;">
                           Xem chi tiết &gt;&gt;
                        </a>
                    </div>
                </td>
            </c:forEach>
            <!-- Điền ô trống nếu không đủ 3 video -->
            <c:forEach begin="${videos.size() + 1}" end="3">
                <td style="border: 1px solid black;"></td>
            </c:forEach>
        </tr>
        
        <!-- Hàng 4: Phân trang (Pagination) -->
        <tr>
            <td colspan="3" style="text-align: center; padding: 15px; border: 1px solid black;">
                <c:if test="${endPage > 0}">
                    <a href="${pageContext.request.contextPath}/home?categoryId=${categoryId}&page=1" style="text-decoration: none; color: black; margin: 0 5px;">&lt;&lt;</a>
                    
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <a href="${pageContext.request.contextPath}/home?categoryId=${categoryId}&page=${i}" 
                           style="text-decoration: none; margin: 0 5px; ${currentPage == i ? 'font-weight: bold; color: red;' : 'color: black;'}">
                           ${i}
                        </a>
                    </c:forEach>
                    
                    <a href="${pageContext.request.contextPath}/home?categoryId=${categoryId}&page=${endPage}" style="text-decoration: none; color: black; margin: 0 5px;">&gt;&gt;</a>
                </c:if>
            </td>
        </tr>
        
    </table>
</div>