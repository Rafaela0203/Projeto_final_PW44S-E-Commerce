package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemsDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItems;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemsRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            item.setProductId(dtoItem.getProductId());
            item.setPrice(product.getPrice());

            orderItemsRepository.save(item);
        }

        entity.setId(order.getId());
        return entity;
    }

    @Override
    public List<Order> findByUser_Id(Long userid) {
        return List.of();
    }

    @Override
    public List<Order> findByUser(User user) {
        return List.of();
    }

    @Override
    public Page<Order> findByUser(User user, Pageable pageable) {
        return null;
    }

    @Override
    public List<Order> findOrdersByUser() {
        return List.of();
    }

    public List<OrderItems> findItemsByOrderId(Long orderId) {
        return orderItemsRepository.findByOrderId_Id(orderId);
    }

//    public ResponseOrderDTO findOrderById(Long orderId) {
//        Order order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//        List<OrderItems> orderItems = orderItemsRepository.findByOrder_Id(orderId);
//
//        // Convert Order and OrderItems to DTOs
//        ResponseOrderDTO responseOrderDTO = modelMapper.map(order, ResponseOrderDTO.class);
//
//        List<ResponseOrderItemsDTO> itemDTOs = orderItems.stream()
//                .map(item -> {
//                    ResponseOrderItemsDTO dto = new ResponseOrderItemsDTO();
//                    dto.setProductName(item.getProductId().getName());
//                    dto.setPrice(item.getPrice());
//                    dto.setQuantity(item.getQuantity());
//                    return dto;
//                })
//                .toList();
//
//        responseOrderDTO.setItemsList(itemDTOs);
//        return responseOrderDTO;
//    }
//
//    @Override
//    public ResponseEntity<List<ResponseOrderDTO>> findOrdersByUser() {
//        // Fetch the currently authenticated user (you can get the user from the security context or session)
//        User currentUser = authService.getAuthenticatedUser();
//
//        // Fetch all orders for the authenticated user
//        List<Order> userOrders = orderRepository.findByUser(currentUser);
//
//        // Map each Order to ResponseOrderDTO
//        List<ResponseOrderDTO> responseOrders = userOrders.stream()
//                .map(order -> {
//                    // Convert Order to ResponseOrderDTO
//                    ResponseOrderDTO orderDTO = modelMapper.map(order, ResponseOrderDTO.class);
//
//                    // Fetch associated OrderItems for this order
//                    List<OrderItems> orderItems = orderItemsRepository.findByOrderId(order.getId());
//
//                    // Map OrderItems to ResponseOrderItemDTO and set in the orderDTO
//                    List<ResponseOrderItemsDTO> orderItemDTOs = orderItems.stream()
//                            .map(item -> {
//                                ResponseOrderItemsDTO itemDTO = new ResponseOrderItemsDTO();
////                                itemDTO.setProductId(item.getProduct().getId());
//                                itemDTO.setProductName(item.getProductId().getName());
//                                itemDTO.setPrice(item.getPrice());
//                                itemDTO.setQuantity(item.getQuantity());
//                                return itemDTO;
//                            })
//                            .collect(Collectors.toList());
//
//                    orderDTO.setItemsList(orderItemDTOs);
//                    return orderDTO;
//                })
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(responseOrders);
//    }
//
//    //@Override
//    public ResponseEntity<Page<ResponseOrderDTO>> findPageableOrdersByUser(int page, int size, String sortBy, Boolean asc) {
//        // Fetch the currently authenticated user
//        User currentUser = authService.getAuthenticatedUser();
//
//        // Create a Pageable object with sorting
//        Sort sort = asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable = PageRequest.of(page, size, sort);
//
//        // Fetch paginated orders for the authenticated user
//        Page<Order> userOrders = orderRepository.findByUser(currentUser, pageable);
//
//        // Map each Order to ResponseOrderDTO
//        Page<ResponseOrderDTO> responseOrders = userOrders.map(order -> {
//            // Convert Order to ResponseOrderDTO
//            ResponseOrderDTO orderDTO = modelMapper.map(order, ResponseOrderDTO.class);
//
//            // Fetch associated OrderItems for this order
//            List<OrderItems> orderItems = orderItemsRepository.findByOrderId(order.getId());
//
//            // Map OrderItems to ResponseOrderItemDTO and set in the orderDTO
//            List<ResponseOrderItemsDTO> orderItemDTOs = orderItems.stream()
//                    .map(item -> {
//                        ResponseOrderItemsDTO itemDTO = new ResponseOrderItemsDTO();
//                        itemDTO.setProductName(item.getProductId().getName());
//                        itemDTO.setPrice(item.getPrice());
//                        itemDTO.setQuantity(item.getQuantity());
//                        return itemDTO;
//                    })
//                    .collect(Collectors.toList());
//
//            orderDTO.setItemsList(orderItemDTOs);
//            return orderDTO;
//        });
//
//        // Return the paginated response
//        return ResponseEntity.ok(responseOrders);
//    }

    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
