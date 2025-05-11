package com.ftgrl.library_project_getir.dto;

import com.ftgrl.library_project_getir.entity.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}


