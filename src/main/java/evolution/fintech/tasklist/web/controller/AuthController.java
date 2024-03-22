package evolution.fintech.tasklist.web.controller;

import evolution.fintech.tasklist.domain.user.User;
import evolution.fintech.tasklist.service.AuthService;
import evolution.fintech.tasklist.service.UserService;
import evolution.fintech.tasklist.web.dto.auth.JwtRequest;
import evolution.fintech.tasklist.web.dto.auth.JwtResponse;
import evolution.fintech.tasklist.web.dto.user.UserDto;
import evolution.fintech.tasklist.web.dto.validation.OnCreate;
import evolution.fintech.tasklist.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
