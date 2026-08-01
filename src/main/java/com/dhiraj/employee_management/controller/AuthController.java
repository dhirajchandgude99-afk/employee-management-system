package com.dhiraj.employee_management.controller;

import com.dhiraj.employee_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.dhiraj.employee_management.entity.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return service.register(user);
    }

}