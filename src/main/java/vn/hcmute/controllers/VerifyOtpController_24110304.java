package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.hcmute.models.Users_24110304;
import vn.hcmute.services.IUserService_24110304;
import vn.hcmute.services.impl.UserServiceImpl_24110304;

@WebServlet(urlPatterns = {"/verify-otp"})
public class VerifyOtpController_24110304 extends HttpServlet {
    private IUserService_24110304 userService = new UserServiceImpl_24110304();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/verify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userOtp = req.getParameter("otp");
        HttpSession session = req.getSession();
        String sessionOtp = (String) session.getAttribute("otpCode");

        if (sessionOtp != null && sessionOtp.equals(userOtp)) {
            Users_24110304 user = (Users_24110304) session.getAttribute("pendingUser");
            userService.register(user);
            
            session.removeAttribute("pendingUser");
            session.removeAttribute("otpCode");
            
            resp.sendRedirect(req.getContextPath() + "/login?msg=success");
        } else {
            req.setAttribute("error", "OTP không hợp lệ!");
            req.getRequestDispatcher("/views/verify.jsp").forward(req, resp);
        }
    }
}