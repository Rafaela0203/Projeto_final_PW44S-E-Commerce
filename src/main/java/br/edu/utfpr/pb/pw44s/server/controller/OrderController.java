package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.modelmapper.ModelMapper;

public class OrderController extends CrudController<Order, OrderDTO, Long> {
    private static IOrderService orderService;
    private static ModelMapper modelMapper;

    public OrderController(IOrderService orderService, ModelMapper modelMapper) {
        super(Order.class, OrderDTO.class);
        OrderController.orderService = orderService;
        OrderController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Order, Long> getService() {return OrderController.orderService;}

    @Override
    protected ModelMapper getModelMapper() {return OrderController.modelMapper;}
}
