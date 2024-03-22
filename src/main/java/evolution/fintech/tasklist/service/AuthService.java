package evolution.fintech.tasklist.service;


import evolution.fintech.tasklist.web.dto.auth.JwtRequest;
import evolution.fintech.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
