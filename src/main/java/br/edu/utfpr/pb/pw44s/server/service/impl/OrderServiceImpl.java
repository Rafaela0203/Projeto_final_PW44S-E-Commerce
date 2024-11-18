package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemsDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItems;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemsRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Long> implements IOrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final AuthService authService;
    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemsRepository orderItemsRepository,
                            OrderItemsRepository orderItemRepository, AuthService authService,
                            ProductServiceImpl productService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemRepository;
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.authService = authService;
    }


    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    public OrderDTO SaveCompleteOrder(OrderDTO entity) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setUser(authService.getAuthenticatedUser());
        order.setAddress(entity.getAddress());
        order.setPayment(entity.getPayment());
        order.setShipping(entity.getShipping());

        orderRepository.save(order);

        for(OrderItemsDTO dtoItem : entity.getItemsList()) {
            OrderItems item = new OrderItems();
            Product product = productService.findOne(dtoItem.getProductId().getId());
            item.setOrderId(order);
            item.setQuantity(dtoItem.getQuantity());
            item.setProductId(product);
            item.setPrice(product.getPrice());

            orderItemsRepository.save(item);
        }

        entity.setId(order.getId());
        return entity;
    }

    @Override
    public List<Order> getOrdersByAuthenticatedUser() {
        User user = authService.getAuthenticatedUser();
        return orderRepository.findByUser(user);
    }
}
