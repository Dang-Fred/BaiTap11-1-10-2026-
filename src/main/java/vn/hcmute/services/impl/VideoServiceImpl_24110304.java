package vn.hcmute.services.impl;
import java.util.List;
import vn.hcmute.dao.IVideoDao_24110304;
import vn.hcmute.dao.impl.VideoDaoImpl_24110304;
import vn.hcmute.models.Videos_24110304;
import vn.hcmute.services.IVideoService_24110304;

public class VideoServiceImpl_24110304 implements IVideoService_24110304 {
    private IVideoDao_24110304 videoDao = new VideoDaoImpl_24110304();

    @Override public void insert(Videos_24110304 video) { videoDao.insert(video); }
    @Override public void update(Videos_24110304 video) { videoDao.update(video); }
    @Override public void delete(String videoId) { videoDao.delete(videoId); }
    @Override public Videos_24110304 findById(String videoId) { return videoDao.findById(videoId); }
    @Override public List<Videos_24110304> findAll(int page, int pageSize) { return videoDao.findAll(page, pageSize); }
    @Override public int countAll() { return videoDao.countAll(); }
    @Override public int countLikes(String videoId) { return videoDao.countLikes(videoId); }
    @Override public int countShares(String videoId) { return videoDao.countShares(videoId); }
    @Override public String getCategoryName(Integer categoryId) { return videoDao.getCategoryName(categoryId); }
    @Override
    public List<Videos_24110304> findByCategory(Integer categoryId, int page, int pageSize) {
        return videoDao.findByCategory(categoryId, page, pageSize);
    }

    @Override
    public int countByCategory(Integer categoryId) {
        return videoDao.countByCategory(categoryId);
    }
    @Override
    public List<Object[]> countVideosPerCategory() {
        return videoDao.countVideosPerCategory();
    }
}