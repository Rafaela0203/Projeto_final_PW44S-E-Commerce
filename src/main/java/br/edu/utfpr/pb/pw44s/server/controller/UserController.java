package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.UserDTO;
import br.edu.utfpr.pb.pw44s.server.dto.response.ResponseUserDTO;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends CrudController<User, UserDTO, ResponseUserDTO, Long> {

    private static IUserService userService;
    private static ModelMapper modelMapper;

    public UserController(IUserService userService, ModelMapper modelMapper) {
        super(User.class, UserDTO.class, ResponseUserDTO.class);
    this.userService = userService;
    this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<User, Long> getService() {
        return UserController.userService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return UserController.modelMapper;
    }


//    @PostMapping
//    public String saveTeste(PedidoDTO pedidoDTO) {
//        Pedido p = new Pedido();
//
//        p.setData(new Date())
//                List itensPedido = new ArrayList
//        pedidoDTO.list.foreach(il -> {
//                ItemPedido ip = new ItemPedido
//            ip.setQtde(il.getQtde)
//                    ip.setPedido(p)
//                            itensPedido.add(ip)
//        })
//
//
//    }
}
