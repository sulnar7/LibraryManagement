package com.example.librarymanagement.controller;

import com.example.librarymanagement.entity.Auth;
import com.example.librarymanagement.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@Valid @RequestBody Auth auth) {
        log.info("login auth: {}", auth);
        return authService.login(auth.getEmail(), auth.getPassword());
    }
}
