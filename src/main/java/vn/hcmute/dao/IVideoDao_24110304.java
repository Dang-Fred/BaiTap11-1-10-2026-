package vn.hcmute.dao;
import java.util.List;
import vn.hcmute.models.Videos_24110304;

public interface IVideoDao_24110304 {
    void insert(Videos_24110304 video);
    void update(Videos_24110304 video);
    void delete(String videoId);
    Videos_24110304 findById(String videoId);
    List<Videos_24110304> findAll(int page, int pageSize);
    int countAll();
    int countLikes(String videoId);
    int countShares(String videoId);
    String getCategoryName(Integer categoryId);
    List<Videos_24110304> findByCategory(Integer categoryId, int page, int pageSize);
    int countByCategory(Integer categoryId);
    List<Object[]> countVideosPerCategory();
}