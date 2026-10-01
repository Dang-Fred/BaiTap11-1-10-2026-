package vn.hcmute.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.hcmute.configs.JPAConfig_24110304;
import vn.hcmute.dao.IUserDao_24110304;
import vn.hcmute.models.Users_24110304;

public class UserDaoImpl_24110304 implements IUserDao_24110304 {
    @Override
    public void insert(Users_24110304 user) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(user);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            enma.close();
        }
    }

    @Override
    public Users_24110304 findByUsername(String username) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        Users_24110304 user = enma.find(Users_24110304.class, username);
        enma.close();
        return user;
    }
}