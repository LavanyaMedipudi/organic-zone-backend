package com.college.organiczone_backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.college.organiczone_backend.dto.UserRequestDTO;
import com.college.organiczone_backend.service.UserService;

@RestController
@RequestMapping("/test/users")
public class UserTestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(
            @Valid @RequestBody UserRequestDTO dto) {

        userService.createUser(dto);
        return ResponseEntity.ok("User created successfully");
    }
}





