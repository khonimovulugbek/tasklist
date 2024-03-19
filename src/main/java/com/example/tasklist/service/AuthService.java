package com.example.tasklist.service;

import com.example.tasklist.web.dto.auth.JwtResponse;
import com.example.tasklist.web.dto.auth.JwtRequest;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
