package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import vn.hcmute.models.Videos_24110304;
import vn.hcmute.services.IVideoService_24110304;
import vn.hcmute.services.impl.VideoServiceImpl_24110304;

@WebServlet(urlPatterns = {"/admin/videos", "/admin/videos/add", "/admin/videos/edit", "/admin/videos/delete"})
public class VideoController_24110304 extends HttpServlet {
    private IVideoService_24110304 videoService = new VideoServiceImpl_24110304();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        
        if (path.equals("/admin/videos")) {
            // Xử lý phân trang
            int pageSize = 6;
            String pageStr = req.getParameter("page");
            int page = (pageStr != null) ? Integer.parseInt(pageStr) : 1;
            
            List<Videos_24110304> list = videoService.findAll(page, pageSize);
            int totalVideos = videoService.countAll();
            int endPage = totalVideos / pageSize;
            if (totalVideos % pageSize != 0) endPage++;
            
            req.setAttribute("videos", list);
            req.setAttribute("endPage", endPage);
            req.setAttribute("currentPage", page);
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
            
        } else if (path.equals("/admin/videos/add")) {
            req.getRequestDispatcher("/views/admin/video-form.jsp").forward(req, resp);
            
        } else if (path.equals("/admin/videos/edit")) {
            String id = req.getParameter("id");
            Videos_24110304 video = videoService.findById(id);
            req.setAttribute("video", video);
            req.getRequestDispatcher("/views/admin/video-form.jsp").forward(req, resp);
            
        } else if (path.equals("/admin/videos/delete")) {
            String id = req.getParameter("id");
            videoService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        String videoId = req.getParameter("videoId");
        String title = req.getParameter("title");
        String poster = req.getParameter("poster");
        Integer views = Integer.parseInt(req.getParameter("views"));
        String description = req.getParameter("description");
        Boolean active = req.getParameter("active") != null;
        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
        
        Videos_24110304 video = new Videos_24110304();
        video.setVideoId(videoId);
        video.setTitle(title);
        video.setPoster(poster);
        video.setViews(views);
        video.setDescription(description);
        video.setActive(active);
        video.setCategoryId(categoryId);
        
        if (req.getParameter("isEdit") != null && req.getParameter("isEdit").equals("true")) {
            videoService.update(video);
        } else {
            videoService.insert(video);
        }
        
        resp.sendRedirect(req.getContextPath() + "/admin/videos");
    }
}