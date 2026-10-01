package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import vn.hcmute.models.CartItem_24110304;
import vn.hcmute.models.Videos_24110304;
import vn.hcmute.services.IVideoService_24110304;
import vn.hcmute.services.impl.VideoServiceImpl_24110304;

@WebServlet(urlPatterns = {"/cart", "/cart/add", "/cart/update", "/cart/remove"})
public class CartController_24110304 extends HttpServlet {
    
    private IVideoService_24110304 videoService = new VideoServiceImpl_24110304();
    private static final int MAX_QUANTITY = 5; // Giới hạn số lượng tối đa

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        HttpSession session = req.getSession();
        
        if ("/cart".equals(path)) {
            req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
        } else if ("/cart/remove".equals(path)) {
            String videoId = req.getParameter("id");
            Map<String, CartItem_24110304> cart = (Map<String, CartItem_24110304>) session.getAttribute("cart");
            
            if (cart != null && cart.containsKey(videoId)) {
                cart.remove(videoId);
                updateCartTotal(session, cart);
            }
            resp.sendRedirect(req.getContextPath() + "/cart");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        HttpSession session = req.getSession();
        
        // Lấy giỏ hàng từ session hoặc khởi tạo mới
        Map<String, CartItem_24110304> cart = (Map<String, CartItem_24110304>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        String videoId = req.getParameter("videoId");
        int quantity = 1;
        try {
            quantity = Integer.parseInt(req.getParameter("quantity"));
        } catch (NumberFormatException e) {
            quantity = 1;
        }
        
        if ("/cart/add".equals(path)) {
            if (cart.containsKey(videoId)) {
                CartItem_24110304 item = cart.get(videoId);
                int newQuantity = item.getQuantity() + quantity;
                item.setQuantity(Math.min(newQuantity, MAX_QUANTITY));
            } else {
                Videos_24110304 video = videoService.findById(videoId);
                if (video != null) {
                    cart.put(videoId, new CartItem_24110304(video, Math.min(quantity, MAX_QUANTITY)));
                }
            }
        } else if ("/cart/update".equals(path)) {
            if (cart.containsKey(videoId)) {
                if (quantity <= 0) {
                    cart.remove(videoId); // Xóa nếu set số lượng về 0
                } else {
                    CartItem_24110304 item = cart.get(videoId);
                    item.setQuantity(Math.min(quantity, MAX_QUANTITY));
                }
            }
        }

        updateCartTotal(session, cart);
        resp.sendRedirect(req.getContextPath() + "/cart");
    }

    // Hàm phụ trợ cập nhật tổng số item lên session để hiển thị icon giỏ hàng
    private void updateCartTotal(HttpSession session, Map<String, CartItem_24110304> cart) {
        session.setAttribute("cart", cart);
        int totalItems = cart.size();
        session.setAttribute("cartTotalItems", totalItems);
    }
}