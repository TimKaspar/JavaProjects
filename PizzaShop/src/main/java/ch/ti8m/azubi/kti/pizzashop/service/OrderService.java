package ch.ti8m.azubi.kti.pizzashop.service;

import ch.ti8m.azubi.kti.pizzashop.dto.Order;

import java.util.List;

public interface OrderService {
    
    Order get(int id) throws Exception;

    List<Order> list() throws Exception;

    void update(Order order) throws Exception;

    Order create (Order order) throws Exception;

    void remove (int id) throws Exception;

}
