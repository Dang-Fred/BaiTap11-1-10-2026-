package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import vn.hcmute.models.Orders_24110304;
import vn.hcmute.models.Users_24110304;
import vn.hcmute.services.IOrderService_24110304;
import vn.hcmute.services.impl.OrderServiceImpl_24110304;

@WebServlet(urlPatterns = {"/order/history"})
public class OrderHistoryController_24110304 extends HttpServlet {
    private IOrderService_24110304 orderService = new OrderServiceImpl_24110304();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Users_24110304 user = (Users_24110304) session.getAttribute("account");
        
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Lấy status từ URL, mặc định là ALL nếu không truyền
        String status = req.getParameter("status");
        if (status == null || status.isEmpty()) {
            status = "ALL";
        }

        // Lấy danh sách đơn hàng
        List<Orders_24110304> orders = orderService.findByUsernameAndStatus(user.getUsername(), status);
        
        req.setAttribute("orders", orders);
        req.setAttribute("currentStatus", status);
        
        req.getRequestDispatcher("/views/web/order-history.jsp").forward(req, resp);
    }
}