package com.ftgrl.library_project_getir.service;


import com.ftgrl.library_project_getir.dto.AuthRequest;
import com.ftgrl.library_project_getir.dto.AuthResponse;
import com.ftgrl.library_project_getir.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
}

