package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;

import java.util.List;

public interface IOrderService extends ICrudService<Order, Long> {
    OrderDTO SaveCompleteOrder(OrderDTO entity);
    List<Order> findByUserId(Long userId);
    List<Order> findOrdersByUser();
}
