package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.UserDTO;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.service.impl.UserServiceImpl;
import br.edu.utfpr.pb.pw44s.server.shared.GenericResponse;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    public UserController(UserServiceImpl userService) {

        this.userService = userService;
        this.modelMapper = new ModelMapper();
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createUser(@RequestBody @Valid UserDTO user) {
        userService.save(modelMapper.map(user, User.class));

        return ResponseEntity.ok(new GenericResponse("User saved!"));
    }
}
