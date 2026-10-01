package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.hcmute.models.Users_24110304;
import vn.hcmute.services.IUserService_24110304;
import vn.hcmute.services.impl.UserServiceImpl_24110304;

@WebServlet(urlPatterns = {"/login"})
public class LoginController_24110304 extends HttpServlet {
    private IUserService_24110304 userService = new UserServiceImpl_24110304();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

     // Đoạn này nằm trong hàm doPost, sau khi bạn kiểm tra login thành công
        Users_24110304 user = userService.login(username, password);

        if (user != null) {
            // Lưu tài khoản vào session
            HttpSession session = req.getSession();
            session.setAttribute("account", user); // Tên attribute có thể là "account" hoặc "user" tùy bạn đặt
            
            // PHÂN LUỒNG ĐĂNG NHẬP Ở ĐÂY:
            if (user.getAdmin() != null && user.getAdmin()) {
                // Nếu là Admin -> Cho vào trang quản trị
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            } else {
                // Nếu là User thường -> Đưa về trang chủ xem video (Câu 4)
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            // Đăng nhập thất bại
            req.setAttribute("alert", "Tài khoản hoặc mật khẩu không đúng!");
            req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
        }
    }
}