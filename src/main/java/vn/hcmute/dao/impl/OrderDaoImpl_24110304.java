package vn.hcmute.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import vn.hcmute.configs.JPAConfig_24110304;
import vn.hcmute.dao.IOrderDao_24110304;
import vn.hcmute.models.OrderDetails_24110304;
import vn.hcmute.models.Orders_24110304;

public class OrderDaoImpl_24110304 implements IOrderDao_24110304 {
    @Override
    public boolean createOrder(Orders_24110304 order, List<OrderDetails_24110304> details) {
        EntityManager enma = JPAConfig_24110304.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(order); // Lưu bảng Orders
            for (OrderDetails_24110304 detail : details) {
                enma.persist(detail); // Lưu các dòng Chi tiết
            }
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return false;
        } finally {
            enma.close();
        }
    }
}