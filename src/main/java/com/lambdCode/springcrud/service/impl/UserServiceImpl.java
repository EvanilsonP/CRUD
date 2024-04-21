package com.lambdCode.springcrud.service.impl;

import com.lambdCode.springcrud.entity.User;
import com.lambdCode.springcrud.repository.UserRepository;
import com.lambdCode.springcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid id: " + id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        // check whether the user is in the database or not
        userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid id: " + id));
        user.setId(id);
        userRepository.save(user);
    }
}
