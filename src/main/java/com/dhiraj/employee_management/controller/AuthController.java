package com.dhiraj.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.dhiraj.employee_management.dto.AuthRequest;
import com.dhiraj.employee_management.dto.AuthResponse;
import com.dhiraj.employee_management.entity.User;
import com.dhiraj.employee_management.security.JwtService;
import com.dhiraj.employee_management.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    // Register User
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // Login User
    @PostMapping("/login")
public AuthResponse login(@RequestBody AuthRequest request) {

    try {

        System.out.println("STEP 1");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        System.out.println("STEP 2");

        String token = jwtService.generateToken(request.getUsername());

        System.out.println("STEP 3");

        return new AuthResponse(token);

    } catch (Exception e) {
        e.printStackTrace();
        throw e;
    }
}
}