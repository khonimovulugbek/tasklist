package com.example.tasklist.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {
    @NotNull(message = "Username must be not null.")
    private String username;
    @NotNull(message = "Password must bu not null.")
    private String password;
}
