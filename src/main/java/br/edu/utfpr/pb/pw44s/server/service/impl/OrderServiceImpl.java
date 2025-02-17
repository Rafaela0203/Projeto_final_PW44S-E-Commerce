package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemsDTO;
import br.edu.utfpr.pb.pw44s.server.dto.response.ResponseOrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.response.ResponseOrderItemsDTO;
import br.edu.utfpr.pb.pw44s.server.model.*;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemsRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Long> implements IOrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final AuthService authService;
    private final ProductServiceImpl productService;
    private final AddressServiceImpl addressService;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemsRepository orderItemsRepository,
                            OrderItemsRepository orderItemRepository, AuthService authService,
                            ProductServiceImpl productService, ModelMapper modelMapper, AddressServiceImpl addressService) {
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemRepository;
        this.productService = productService;
        this.addressService = addressService;
        this.modelMapper = modelMapper;
        this.authService = authService;
    }


    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    public OrderDTO SaveCompleteOrder(OrderDTO entity) {
        Address address = addressService.findOne(entity.getAddressId());
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setUser(authService.getAuthenticatedUser());
        order.setAddress(address);
        order.setPayment(entity.getPayment());
        order.setShipping(entity.getShipping());

        orderRepository.save(order);

        for(OrderItemsDTO dtoItem : entity.getItemsList()) {
            OrderItems item = new OrderItems();
            Product product = productService.findOne(dtoItem.getProductId().getId());
            item.setOrder(order);
            item.setQuantity(dtoItem.getQuantity());
            item.setProductId(product);
            item.setPrice(product.getPrice());

            orderItemsRepository.save(item);
        }

        entity.setUserId(order.getUser().getId());
        return entity;
    }



    @Override
    public ResponseEntity<List<ResponseOrderDTO>> getOrdersByAuthenticatedUser() {
        User currentUser = authService.getAuthenticatedUser();

        // Fetch all orders for the authenticated user
        List<Order> userOrders = orderRepository.findByUser(currentUser);

        // Map each Order to ResponseOrderDTO
        List<ResponseOrderDTO> responseOrders = userOrders.stream()
                .map(order -> {
                    // Convert Order to ResponseOrderDTO
                    ResponseOrderDTO orderDTO = modelMapper.map(order, ResponseOrderDTO.class);

                    // Fetch associated OrderItems for this order
                    List<OrderItems> orderItems = orderItemsRepository.findByOrder_Id(order.getId());

                    // Map OrderItems to ResponseOrderItemDTO and set in the orderDTO
                    List<ResponseOrderItemsDTO> orderItemDTOs = orderItems.stream()
                            .map(item -> {

                                ResponseOrderItemsDTO itemDTO = new ResponseOrderItemsDTO();
                                itemDTO.setId(item.getId());
                                itemDTO.setProductName(productService.findOne(item.getProductId().getId()).getName());
                                itemDTO.setPrice(item.getPrice());
                                itemDTO.setQuantity(item.getQuantity());
                                return itemDTO;
                            })
                            .collect(Collectors.toList());

                    orderDTO.setItemsList(orderItemDTOs);
                    return orderDTO;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseOrders);
    }
}
