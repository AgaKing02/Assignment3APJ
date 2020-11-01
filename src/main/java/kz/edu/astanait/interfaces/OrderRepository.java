package kz.edu.astanait.interfaces;

import kz.edu.astanait.models.Order;

import java.util.List;

public interface OrderRepository extends EntityRepository<Order>{

    List<Order> getMyOrders(String username);

    void moveBackTheBook(int id,String username);

    void removeOrderSByBookIsbn(int isbn);
}
