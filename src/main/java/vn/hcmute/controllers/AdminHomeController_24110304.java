package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/home"})
public class AdminHomeController_24110304 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Trỏ tới file giao diện JSP của trang chủ
        req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
    }
}