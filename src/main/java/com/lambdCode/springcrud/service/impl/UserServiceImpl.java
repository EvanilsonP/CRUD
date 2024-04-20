package com.lambdCode.springcrud.service.impl;

import com.lambdCode.springcrud.entity.User;
import com.lambdCode.springcrud.repository.UserRepository;
import com.lambdCode.springcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
