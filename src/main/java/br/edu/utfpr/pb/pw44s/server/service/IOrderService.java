package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.response.ResponseOrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderService extends ICrudService<Order, Long> {
    OrderDTO SaveCompleteOrder(OrderDTO orderDTO);
    ResponseEntity<List<ResponseOrderDTO>> getOrdersByAuthenticatedUser();
}
