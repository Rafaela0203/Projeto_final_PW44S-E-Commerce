package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.response.ResponseOrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
public class OrderController extends CrudController<Order, OrderDTO, ResponseOrderDTO, Long> {
    private static IOrderService orderService;
    private static ModelMapper modelMapper;

    public OrderController(IOrderService orderService, ModelMapper modelMapper) {
        super(Order.class, OrderDTO.class, ResponseOrderDTO.class);
        OrderController.orderService = orderService;
        OrderController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Order, Long> getService() {return OrderController.orderService;}

    @Override
    protected ModelMapper getModelMapper() {return OrderController.modelMapper;}

    @Override
    public ResponseEntity<List<ResponseOrderDTO>> findAll() {
        List<Order> userOrders = orderService.getOrdersByAuthenticatedUser();

        List<ResponseOrderDTO> responseOrders = userOrders.stream()
                .map(order -> modelMapper.map(order, ResponseOrderDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseOrders);
    }

    @Override
    public ResponseEntity<ResponseOrderDTO> create(OrderDTO entity) {
        OrderDTO savedOrderDTO = orderService.SaveCompleteOrder(entity);
        ResponseOrderDTO responseOrderDTO = modelMapper.map(savedOrderDTO, ResponseOrderDTO.class);

        return ResponseEntity.ok(responseOrderDTO);
    }
}
