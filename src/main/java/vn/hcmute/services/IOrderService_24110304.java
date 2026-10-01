package vn.hcmute.services;
import java.util.List;
import vn.hcmute.models.OrderDetails_24110304;
import vn.hcmute.models.Orders_24110304;

public interface IOrderService_24110304 {
	boolean createOrder(Orders_24110304 order, List<OrderDetails_24110304> details);
	List<Orders_24110304> findByUsernameAndStatus(String username, String status);
}
