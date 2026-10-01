package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.hcmute.models.Users_24110304;
import vn.hcmute.utils.EmailUtil_24110304;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController_24110304 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");

        Users_24110304 pendingUser = new Users_24110304();
        pendingUser.setUsername(username);
        pendingUser.setEmail(email);
        pendingUser.setPassword(password);
        pendingUser.setFullname(fullname);
        pendingUser.setAdmin(false);
        pendingUser.setActive(true); // Hoặc false tùy logic hệ thống

        String otp = EmailUtil_24110304.generateOTP();
        EmailUtil_24110304.sendOtpEmail(email, otp);

        HttpSession session = req.getSession();
        session.setAttribute("pendingUser", pendingUser);
        session.setAttribute("otpCode", otp);

        resp.sendRedirect(req.getContextPath() + "/verify-otp");
    }
}