package vn.hcmute.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;
import vn.hcmute.configs.JPAConfig_24110304; // Class đã tạo ở câu 2
import vn.hcmute.dao.IVideoDao_24110304;
import vn.hcmute.models.Videos_24110304;

public class VideoDaoImpl_24110304 implements IVideoDao_24110304 {
    @Override
    public void insert(Videos_24110304 video) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally { enma.close(); }
    }

    @Override
    public void update(Videos_24110304 video) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally { enma.close(); }
    }

    @Override
    public void delete(String videoId) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Videos_24110304 video = enma.find(Videos_24110304.class, videoId);
            if(video != null) enma.remove(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally { enma.close(); }
    }

    @Override
    public Videos_24110304 findById(String videoId) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        Videos_24110304 video = enma.find(Videos_24110304.class, videoId);
        enma.close();
        return video;
    }

    @Override
    public List<Videos_24110304> findAll(int page, int pageSize) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        TypedQuery<Videos_24110304> query = enma.createQuery("SELECT v FROM Videos_24110304 v", Videos_24110304.class);
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<Videos_24110304> list = query.getResultList();
        enma.close();
        return list;
    }

    @Override
    public int countAll() {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        Long count = enma.createQuery("SELECT COUNT(v) FROM Videos_24110304 v", Long.class).getSingleResult();
        enma.close();
        return count.intValue();
    }
    @Override
    public int countLikes(String videoId) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        try {
            // Dùng Native Query đếm số dòng trong bảng Favorites
            Number count = (Number) enma.createNativeQuery("SELECT COUNT(*) FROM Favorites WHERE VideoId = :id")
                    .setParameter("id", videoId)
                    .getSingleResult();
            return count.intValue();
        } finally { enma.close(); }
    }

    @Override
    public int countShares(String videoId) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        try {
            Number count = (Number) enma.createNativeQuery("SELECT COUNT(*) FROM Shares WHERE VideoId = :id")
                    .setParameter("id", videoId)
                    .getSingleResult();
            return count.intValue();
        } finally { enma.close(); }
    }

    @Override
    public String getCategoryName(Integer categoryId) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        try {
            String name = (String) enma.createNativeQuery("SELECT Categoryname FROM Category WHERE CategoryId = :id")
                    .setParameter("id", categoryId)
                    .getSingleResult();
            return name;
        } catch (Exception e) {
            return "Không xác định";
        } finally { enma.close(); }
    }
    @Override
    public List<Videos_24110304> findByCategory(Integer categoryId, int page, int pageSize) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        try {
            TypedQuery<Videos_24110304> query = enma.createQuery(
                "SELECT v FROM Videos_24110304 v WHERE v.categoryId = :catId", Videos_24110304.class);
            query.setParameter("catId", categoryId);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } finally { enma.close(); }
    }

    @Override
    public int countByCategory(Integer categoryId) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        try {
            Long count = enma.createQuery(
                "SELECT COUNT(v) FROM Videos_24110304 v WHERE v.categoryId = :catId", Long.class)
                .setParameter("catId", categoryId)
                .getSingleResult();
            return count.intValue();
        } finally { enma.close(); }
    }
    @Override
    public List<Object[]> countVideosPerCategory() {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        try {
            // Dùng LEFT JOIN để đếm cả những Category chưa có video nào (Count = 0)
            String sql = "SELECT c.CategoryId, c.Categoryname, COUNT(v.VideoId) " +
                         "FROM Category c LEFT JOIN Videos v ON c.CategoryId = v.CategoryId " +
                         "GROUP BY c.CategoryId, c.Categoryname";
            return enma.createNativeQuery(sql).getResultList();
        } finally { 
            enma.close(); 
        }
    }
}