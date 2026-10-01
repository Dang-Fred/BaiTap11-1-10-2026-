package vn.hcmute.services.impl;

import java.util.List;
import vn.hcmute.dao.IOrderDao_24110304;
import vn.hcmute.dao.impl.OrderDaoImpl_24110304;
import vn.hcmute.models.OrderDetails_24110304;
import vn.hcmute.models.Orders_24110304;
import vn.hcmute.services.IOrderService_24110304;

public class OrderServiceImpl_24110304 implements IOrderService_24110304 {
    private IOrderDao_24110304 orderDao = new OrderDaoImpl_24110304();

    @Override
    public boolean createOrder(Orders_24110304 order, List<OrderDetails_24110304> details) {
        return orderDao.createOrder(order, details);
    }
    
    @Override
    public List<Orders_24110304> findByUsernameAndStatus(String username, String status) {
        return orderDao.findByUsernameAndStatus(username, status);
    }
}