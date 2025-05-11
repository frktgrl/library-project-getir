package com.ftgrl.library_project_getir.dto;

import com.ftgrl.library_project_getir.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private String name;
    private Role role;
}
