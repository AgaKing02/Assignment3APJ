package interfaces;

import models.Order;

import java.util.List;

public interface OrderRepository extends EntityRepository<Order>{

    List<Order> getMyOrders(String username);
}
