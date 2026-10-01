package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vn.hcmute.models.Videos_24110304;
import vn.hcmute.services.IVideoService_24110304;
import vn.hcmute.services.impl.VideoServiceImpl_24110304;

@WebServlet(urlPatterns = {"/home"})
public class UserHomeController_24110304 extends HttpServlet {
    private IVideoService_24110304 videoService = new VideoServiceImpl_24110304();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy categoryId từ URL (Mặc định là 1 nếu không truyền)
        String catIdParam = req.getParameter("categoryId");
        int categoryId = (catIdParam != null && !catIdParam.isEmpty()) ? Integer.parseInt(catIdParam) : 1;
        
        // Cấu hình phân trang: 3 video / 1 trang theo đúng đề bài
        int pageSize = 3; 
        String pageStr = req.getParameter("page");
        int page = (pageStr != null) ? Integer.parseInt(pageStr) : 1;
        
        // 1. Fetch danh sách video và tổng số video
        List<Videos_24110304> videos = videoService.findByCategory(categoryId, page, pageSize);
        int totalVideos = videoService.countByCategory(categoryId);
        String categoryName = videoService.getCategoryName(categoryId);
        
        // 2. Tính toán số trang (Pagination)
        int endPage = totalVideos / pageSize;
        if (totalVideos % pageSize != 0) endPage++;
        
        // 3. Lấy số lượng Like/Share cho từng Video lưu vào Map
        Map<String, Integer> likesMap = new HashMap<>();
        Map<String, Integer> sharesMap = new HashMap<>();
        for (Videos_24110304 v : videos) {
            likesMap.put(v.getVideoId(), videoService.countLikes(v.getVideoId()));
            sharesMap.put(v.getVideoId(), videoService.countShares(v.getVideoId()));
        }
        
        // 4. Set Attribute và forward sang JSP
        req.setAttribute("videos", videos);
        req.setAttribute("totalVideos", totalVideos);
        req.setAttribute("categoryName", categoryName);
        req.setAttribute("categoryId", categoryId);
        req.setAttribute("likesMap", likesMap);
        req.setAttribute("sharesMap", sharesMap);
        req.setAttribute("currentPage", page);
        req.setAttribute("endPage", endPage);
        
     // Lấy danh sách đếm số lượng video theo từng thể loại
        List<Object[]> categoryCounts = videoService.countVideosPerCategory();
        req.setAttribute("categoryCounts", categoryCounts);
        
        req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
        
        
    }
}