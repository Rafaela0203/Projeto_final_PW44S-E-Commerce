package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.User;

import java.util.List;

public interface IUserService extends ICrudService<User, Long> {
    List<User> findUserByAuth();
}
