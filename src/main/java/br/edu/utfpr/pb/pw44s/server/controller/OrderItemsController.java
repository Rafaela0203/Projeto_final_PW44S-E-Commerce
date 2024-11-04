package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderItemsDTO;
import br.edu.utfpr.pb.pw44s.server.model.OrderItems;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderItemsService;
import org.modelmapper.ModelMapper;

public class OrderItemsController extends CrudController<OrderItems, OrderItemsDTO, Long> {
    private static IOrderItemsService orderItemsService;
    private static ModelMapper modelMapper;

    public OrderItemsController(IOrderItemsService orderItemsService, ModelMapper modelMapper) {
        super(OrderItems.class, OrderItemsDTO.class);

        OrderItemsController.orderItemsService = orderItemsService;
        OrderItemsController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<OrderItems, Long> getService() {return OrderItemsController.orderItemsService;}

    @Override
    protected ModelMapper getModelMapper(){return OrderItemsController.modelMapper;}
}