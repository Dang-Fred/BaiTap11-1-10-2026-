<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Tự động chuyển hướng sang Controller xử lý đăng nhập
    response.sendRedirect(request.getContextPath() + "/login");
%>