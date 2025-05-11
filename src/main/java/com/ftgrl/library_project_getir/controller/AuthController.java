package com.ftgrl.library_project_getir.controller;


import com.ftgrl.library_project_getir.dto.AuthRequest;
import com.ftgrl.library_project_getir.dto.AuthResponse;
import com.ftgrl.library_project_getir.dto.RegisterRequest;
import com.ftgrl.library_project_getir.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}

