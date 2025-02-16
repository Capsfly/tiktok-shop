package org.group.mall.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.group.mall.model.user.dto.LoginRequest;
import org.group.mall.model.user.dto.RegisterRequest;
import org.group.mall.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Integer> register(@Valid @RequestBody RegisterRequest request) {
        // 确认密码一致性校验
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("两次输入的密码不一致");
        }
        return ResponseEntity.ok(userService.register(request.getEmail(), request.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request.getEmail(), request.getPassword()));
    }
}