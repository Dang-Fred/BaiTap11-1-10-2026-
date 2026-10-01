package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutController_24110304 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hủy session hiện tại chứa thông tin user
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Điều hướng người dùng về lại trang đăng nhập
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}