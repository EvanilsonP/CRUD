package com.lambdCode.springcrud.service;

import com.lambdCode.springcrud.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();
}
