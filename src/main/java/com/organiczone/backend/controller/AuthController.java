package com.college.organiczone_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.college.organiczone_backend.dto.LoginRequestDTO;
import com.college.organiczone_backend.dto.LoginResponseDTO;
import com.college.organiczone_backend.dto.UserRequestDTO;
import com.college.organiczone_backend.model.User;
import com.college.organiczone_backend.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRequestDTO dto) {
        userService.createUser(dto);
        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO dto) {
        User user = userService.login(dto.getEmail(), dto.getPassword());
        return new LoginResponseDTO(user.getEmail(), user.getRole());
    }
}

