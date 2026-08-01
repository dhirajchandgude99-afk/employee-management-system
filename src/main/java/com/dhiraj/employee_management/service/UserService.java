package com.dhiraj.employee_management.service;

import com.dhiraj.employee_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dhiraj.employee_management.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public User register(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        return repository.save(user);
    }

}