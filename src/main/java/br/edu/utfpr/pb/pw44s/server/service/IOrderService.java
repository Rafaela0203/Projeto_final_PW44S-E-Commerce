package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService extends ICrudService<Order, Long> {
    OrderDTO SaveCompleteOrder(OrderDTO orderDTO);
    List<Order> getOrdersByAuthenticatedUser();
}
