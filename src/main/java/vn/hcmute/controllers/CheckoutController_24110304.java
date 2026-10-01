package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import vn.hcmute.models.CartItem_24110304;
import vn.hcmute.models.OrderDetails_24110304;
import vn.hcmute.models.Orders_24110304;
import vn.hcmute.models.Users_24110304;
import vn.hcmute.services.IOrderService_24110304;
import vn.hcmute.services.impl.OrderServiceImpl_24110304;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController_24110304 extends HttpServlet {
    private IOrderService_24110304 orderService = new OrderServiceImpl_24110304();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        
        // 1. Kiểm tra đăng nhập (Bắt buộc phải login mới được mua)
        Users_24110304 user = (Users_24110304) session.getAttribute("account");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // 2. Lấy giỏ hàng
        Map<String, CartItem_24110304> cart = (Map<String, CartItem_24110304>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/cart");
            return;
        }

        // 3. Tạo Đơn hàng mới
        String address = req.getParameter("address");
        String orderId = "COD-" + System.currentTimeMillis(); // Tạo mã đơn ngẫu nhiên theo thời gian

        Orders_24110304 order = new Orders_24110304();
        order.setOrderId(orderId);
        order.setUsername(user.getUsername());
        order.setOrderDate(new Date());
        order.setPaymentMethod("COD");
        order.setAddress(address);
        order.setStatus("Mới");

        // 4. Tạo danh sách Chi tiết đơn hàng
        List<OrderDetails_24110304> details = new ArrayList<>();
        for (CartItem_24110304 item : cart.values()) {
            OrderDetails_24110304 detail = new OrderDetails_24110304();
            detail.setOrderId(orderId);
            detail.setVideoId(item.getVideo().getVideoId());
            detail.setQuantity(item.getQuantity());
            details.add(detail);
        }

        // 5. Lưu xuống DB
        boolean isSuccess = orderService.createOrder(order, details);

        if (isSuccess) {
            // Xóa giỏ hàng sau khi đặt thành công
            session.removeAttribute("cart");
            session.removeAttribute("cartTotalItems");
            
            // Chuyển tới trang thành công
            req.setAttribute("orderId", orderId);
            req.getRequestDispatcher("/views/web/checkout-success.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/cart?error=true");
        }
    }
}