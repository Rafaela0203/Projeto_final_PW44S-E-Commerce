package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemsDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItems;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemsRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;


@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Long> implements IOrderService {
    private OrderRepository orderRepository;
    private OrderItemsRepository orderItemsRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    public OrderDTO SaveCompleteOrder(OrderDTO entity) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setUser(entity.getUser());//ubstituir metodo
        order.setAddress(entity.getAddress());
        order.setPayment(entity.getPayment());
        order.setShipping(entity.getShipping());

        orderRepository.save(order);

        for(OrderItemsDTO dtoItem : entity.getItemsList()) {
            OrderItems item = new OrderItems();
            item.setOrderId(order);
            item.setQuantity(dtoItem.getQuantity());
            item.setProductId(dtoItem.getProductId());
            item.setPrice(dtoItem.getProductId().getPrice());
            orderItemsRepository.save(item);
        }

        entity.setId(order.getId());
        return entity;
    }
}
