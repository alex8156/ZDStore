package com.soling.store.controller;


import com.soling.store.model.User;
import com.soling.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public List<User> findAll() {
        return userService.findAll(User.class);
    }

    @PostMapping(value = "/user")
    public void insert(@RequestBody User user) {
        userService.insert(User.class,user);
    }

}
