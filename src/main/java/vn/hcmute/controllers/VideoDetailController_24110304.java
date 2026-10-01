package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.hcmute.models.Videos_24110304;
import vn.hcmute.services.IVideoService_24110304;
import vn.hcmute.services.impl.VideoServiceImpl_24110304;

@WebServlet(urlPatterns = {"/video/detail"})
public class VideoDetailController_24110304 extends HttpServlet {
    private IVideoService_24110304 videoService = new VideoServiceImpl_24110304();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String videoId = req.getParameter("id");
        Videos_24110304 video = videoService.findById(videoId);
        
        if (video != null) {
            // Gọi 3 hàm đã viết ở DAO để lấy số Like, Share và tên Category
            int likes = videoService.countLikes(videoId);
            int shares = videoService.countShares(videoId);
            String categoryName = videoService.getCategoryName(video.getCategoryId());
            
            req.setAttribute("video", video);
            req.setAttribute("likes", likes);
            req.setAttribute("shares", shares);
            req.setAttribute("categoryName", categoryName);
            
            req.getRequestDispatcher("/views/web/video-detail.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}