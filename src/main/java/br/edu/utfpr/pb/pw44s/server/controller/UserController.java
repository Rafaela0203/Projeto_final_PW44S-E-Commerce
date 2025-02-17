package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.UserDTO;
import br.edu.utfpr.pb.pw44s.server.dto.response.ResponseUserDTO;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController extends CrudController<User, UserDTO, ResponseUserDTO, Long> {

    private static IUserService userService;
    private static ModelMapper modelMapper;
    private final AuthService authService;

    public UserController(IUserService userService, ModelMapper modelMapper, AuthService authService) {
        super(User.class, UserDTO.class, ResponseUserDTO.class);
    this.userService = userService;
    this.modelMapper = modelMapper;
        this.authService = authService;
    }

    @Override
    protected ICrudService<User, Long> getService() {
        return UserController.userService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return UserController.modelMapper;
    }


    @Override
    public ResponseEntity<List<ResponseUserDTO>> findAll() {
        List<User> userbyauth = userService.findUserByAuth();
        return ResponseEntity.ok(userbyauth.stream()
                .map(user -> modelMapper.map(user, ResponseUserDTO.class))
                .collect(Collectors.toList()));
    }
}
