package com.college.organiczone_backend.service;

import com.college.organiczone_backend.dto.UserRequestDTO;
import com.college.organiczone_backend.model.User;

public interface UserService {

    User createUser(UserRequestDTO dto);
    User getUserByEmail(String email);
    User login(String email, String password);
}
