package com.lambdCode.springcrud.controller;

import com.lambdCode.springcrud.entity.User;
import com.lambdCode.springcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "Successfully added user.";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}